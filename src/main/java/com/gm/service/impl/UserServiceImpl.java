package com.gm.service.impl;

import com.gm.mapper.UserMapper;
import com.gm.pojo.User;
import com.gm.service.UserService;
import com.gm.shiro.util.ShiroUtil;
import com.gm.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void addUser(User user) {
		user.setUserId(BaseUtil.getTableId());
		user.setCreateTime(new Date());
		String salt = ShiroUtil.getSalt();
		user.setSalt(salt);
		user.setPassWord(ShiroUtil.newPassWord(user.getPassWord(), salt));	
		userMapper.addUser(user);
	}
	
	@Override
	public User getUserByUsername(String username) {
		return userMapper.getUserByUsername(username);
	}

	@Override
	public Set<String> findRolesByUsername(String username) {
		List<String> role = userMapper.findRolesByUsername(username);
		Set<String> roleNames = new HashSet<>(role);
		return roleNames;
	}

	@Override
	public Set<String> findPermissionsByUsername(String username) {
		List<String> permission = userMapper.findPermissionsByUsername(username);
		Set<String> permissionNames = new HashSet<>(permission);
		return permissionNames;
	}

	@Override
	public void setLastLoginTime(User user) {
		userMapper.setLastLoginTime(user);
	}

}
