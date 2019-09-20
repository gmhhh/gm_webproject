package com.gm.controller;

import com.gm.pojo.User;
import com.gm.service.UserService;
import com.gm.base.ResultJSONDto;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Description: 用户控制器
 * @Author: guomeng
 * @Date: 2019/9/20 8:45
 **/
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 登录
	 */
	@PostMapping("login")
	public ResultJSONDto login(String username, String password) {
		if (username == null || "".equals(username) || password == null || "".equals(password)) {
			return new ResultJSONDto(false, "用户名和密码不能为空或空字符串");
		}
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		token.setRememberMe(false);		//记住我
		Subject currentUser = SecurityUtils.getSubject();
		try {
			if (!currentUser.isAuthenticated()) {
				currentUser.login(token);	//登录验证 会进入自定义realm的doGetAuthenticationInfo验证
				Session session = currentUser.getSession();
				User user = userService.getUserByUsername(username);
				session.setAttribute("user", user);
			}
		} catch ( UnknownAccountException uae ) {
//			 UnknownAccountException 未知的账号
//			 CredentitalsException 凭证异常
//			 IncorrectCredentialsException 不正确的凭证
//			 ExpiredCredentialsException 凭证过期
//			 AccountException 账号异常
//			 ConcurrentAccessException 并发访问异常（多个用户同时登录时抛出）
//			 ExcessiveAttemptsException 认证次数超过限制
//			 DisabledAccountException 禁用的账号
//			 LockedAccountException 账号被锁定
//			 UnsupportedTokenException 使用了不支持的Token
		} catch ( AuthenticationException ae ) {
		    //认证失败异常父类  上边都是他的子类
			return new ResultJSONDto(false, "登录失败");
		}
		//currentUser.isAuthenticated();		//判断当前对象是否被认证，即是否登录。
		//currentUser.hasRole("role");	//对当前用户判断是否有一些角色信息.
		//currentUser.isPermitted('user:delete:zhangsan');	//判断当前主体是否有权限.判断用户是否有某种行为.当前代表user能够对zhangsan进行delete操作.
		//前面出现了Remembered和Authenticated。那这两种有什么区别呢？
		//需要注意的是，这是两种互斥的情况，当我们在登陆的时候，登陆成功之后，我们Authenticated返回的是true。
		//选择Remeber me的时候，我们下次可以不登陆直接访问，而我们下次登陆之后，Remembered返回的是true，但是Authenticated返回的是false。
		//在登陆之后，我们可以可以用currentUser.logout()方法来注销。这时候用户的信息都会被清空，包括保存在Cookie中的RemeberMe信息还有session也会被无效。
		
		return new ResultJSONDto(true, "登录成功");
	}
	/**
	 * 注册
	 */
	@PostMapping("register")
	public ResultJSONDto register(@RequestBody User user) {
		userService.addUser(user);
		return new ResultJSONDto(true,"注册成功");
	}
	/**
	 * 退出登录
	 */
	@GetMapping("logout")
	public ResultJSONDto logout() {
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser.isAuthenticated()) {
			User user = (User) currentUser.getSession().getAttribute("user");
			user.setLastLoginTime(new Date());
			//设置最后登录时间
			userService.setLastLoginTime(user);
			//退出登录
			currentUser.logout();
			return new ResultJSONDto(true,"退出登录成功");
		} else {
			return new ResultJSONDto(false,"无用户登录");
		}
	}
	/**
	 * 修改密码
	 */
	@PostMapping()
	public ResultJSONDto updatePassWord() {
		return new ResultJSONDto();
	}

	@GetMapping("index")
	public String index() {
		Subject currentUser = SecurityUtils.getSubject();
		String result = "/...";
		result = currentUser.hasRole("user") ? "有权限" : "无权限";
		return result;
	}
	
	@RequiresRoles("user")
	@GetMapping("index2")
	public String index2() {
		Subject currentUser = SecurityUtils.getSubject();
		String username = (String) currentUser.getSession().getAttribute("username");
		return "用户---" + username + "有user角色的用户";
	}
	
	@RequiresPermissions("select")
	@GetMapping("index3")
	public String index3() {
		Subject currentUser = SecurityUtils.getSubject();
		String username = (String) currentUser.getSession().getAttribute("username");
		return "用户---" + username + "有select权限角色的用户";
	}
}
