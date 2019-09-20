package com.gm.service;

import com.gm.pojo.User;

import java.util.Set;
/**
 * @Description: 用户service
 * @Author: guomeng
 * @Date: 2019/9/20 8:45
 **/
public interface UserService {
	/**
	 * 添加用户
	 */
	public void addUser(User user);
	/**
	 * 根据用户名获取用户信息
	 */
	public User getUserByUsername(String username);
	/**
	 * 根据用户名获取角色信息
	 */
	public Set<String> findRolesByUsername(String username);
	/**
	 * 根据用户名获取权限
	 */
	public Set<String> findPermissionsByUsername(String username);
	/**
	 * 设置最后登录时间
	 */
	public void setLastLoginTime(User user);
}
