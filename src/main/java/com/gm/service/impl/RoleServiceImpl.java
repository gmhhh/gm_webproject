package com.gm.service.impl;

import com.gm.mapper.RoleMapper;
import com.gm.pojo.Role;
import com.gm.service.RoleService;
import com.gm.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public void addRole(Role role) {
		String roleId = BaseUtil.getTableId();
		role.setRoleId(roleId);		//设置随机生成的uuid
		role.setCreateTime(new Date());	//创建时间
		roleMapper.addRole(role);
	}

}
	