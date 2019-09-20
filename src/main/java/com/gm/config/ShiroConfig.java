package com.gm.config;

import com.gm.exception.MyExceptionResolver;
import com.gm.shiro.realm.MyShiroRealm;
import com.gm.shiro.util.ShiroUtil;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: shiro配置
 * @Author: guomeng
 * @Date: 2019/9/20 8:45
 **/
@Configuration
public class ShiroConfig {

	@Bean	//shiro 拦截器
	public ShiroFilterFactoryBean shiroFilter(SecurityManager manager) {
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		shiroFilter.setSecurityManager(manager);
		shiroFilter.setLoginUrl("/login.html");	//不设置默认会寻找Web工程根目录下的"/login.jsp"页面 
		shiroFilter.setUnauthorizedUrl("/unauthorized.html");	//未授权跳转
		shiroFilter.setSuccessUrl("/index");	//登录成功跳转
		//拦截器  # 用LinkedHashMap添加拦截的uri,其中authc指定需要认证的uri，anon指定排除认证的uri
		Map<String, String> map = new LinkedHashMap<>();
		map.put("/user/logout", "anon");	//退出登录
		map.put("/register.html", "anon");	//注册页面
		map.put("/user/register", "anon"); //排除注册拦截
		map.put("/user/login", "anon"); //排除登录拦截
		map.put("/logout", "logout"); // 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		map.put("/**", "authc"); //所有路径全部验证
		shiroFilter.setFilterChainDefinitionMap(map);
		return shiroFilter;
	}
	
	@Bean	//凭证匹配器 我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了 
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
		matcher.setHashAlgorithmName(ShiroUtil.HASH_ALGORITHM_NAME);	//设置散列算法
		matcher.setHashIterations(ShiroUtil.HASH_ITERATIONS);	//设置散列次数
		matcher.setStoredCredentialsHexEncoded(true);	//存储散列后的密码是否为16进制
		//matcher.setHashSalted(hashSalted);  作废的方法
		return matcher;
	}
	
	@Bean	//自定义realm
	public MyShiroRealm shiroRealm() {
		MyShiroRealm shiroRealm = new MyShiroRealm();
		shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return shiroRealm;
	}
	
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		//单realm
//		manager.setRealm(shiroRealm());
		//多realm
		ModularRealmAuthenticator modularRealmAuthenticator = new ModularRealmAuthenticator();
		modularRealmAuthenticator.setAuthenticationStrategy(new FirstSuccessfulStrategy());
		manager.setAuthenticator(modularRealmAuthenticator);
		List<Realm> realms = new ArrayList<>();
	    // TODO-多个realms进配置在这里 
	    realms.add(shiroRealm());
	    manager.setRealms(realms);
		return manager;
	}
	
	@Bean
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
    
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }
    
	@Bean(name = "exceptionHandler")  //注册全局异常
    public HandlerExceptionResolver handlerExceptionResolver() {  
        return new MyExceptionResolver();  
    }
}
