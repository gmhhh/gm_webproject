package com.gm.shiro.realm;

import com.gm.pojo.User;
import com.gm.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @Description: shiro域  shiro登录验证 获取该登录角色的权限交给shiro
 * @Author: guomeng
 * @Date: 2019/9/20 8:45
 **/
public class MyShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	
	@Override	//授权，即权限验证，验证某个已认证的用户是否拥有某个权限；即判断用户是否能做事情
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = ((User) principals.getPrimaryPrincipal()).getUserName();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		Set<String> roles = userService.findRolesByUsername(username);
		Set<String> permissions = userService.findPermissionsByUsername(username);
		info.setRoles(roles);
		info.setStringPermissions(permissions);
		return info;
	}

	@Override   //身份认证/登录，验证用户是不是拥有相应的身份；
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		String username = token.getUsername();
		User user = userService.getUserByUsername(username);
		//取出盐并编码
	    ByteSource salt = ByteSource.Util.bytes(user.getSalt());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassWord(), salt, getName());
		return info;
	}

}
