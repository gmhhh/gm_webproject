package com.gm.mapper;


import com.gm.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: 角色mapper
 * @Author: guomeng
 * @Date: 2019/9/20 8:45
 **/
@Mapper
public interface RoleMapper {
	public void addRole(Role role);
}
