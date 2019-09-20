package com.gm.mapper;

import com.gm.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * @Description: 用户mapper
 * @Author: guomeng
 * @Date: 2019/9/20 8:45
 **/
@Mapper
public interface UserMapper {
	//添加用户
	public void addUser(User user);
	//根据用户名得到用户
	public User getUserByUsername(String username);
	//根据用户名得到该用户的所有角色
	public List<String> findRolesByUsername(String username);
	//根据用户名得到该用户的所有权限
	public List<String> findPermissionsByUsername(String username);
	//设置最后登录时间
	public void setLastLoginTime(User user);
}
