package com.gm.controller;


import com.gm.pojo.Role;
import com.gm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 角色控制器
 * @Author: guomeng
 * @Date: 2019/9/20 8:45
 **/
@RequestMapping("role")
@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@PostMapping("addRole")
	public String addRole(Role role) {
		roleService.addRole(role);
		return "添加成功";
	}
	
}
