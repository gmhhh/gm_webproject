package com.gm.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * @Description: 角色实体类
 * @Author: guomeng
 * @Date: 2019/9/20 8:45
 **/
public class Role implements Serializable {
	private static final long serialVersionUID = -3813292428826776771L;
	private int id;   //
	private String roleId;   //角色id
	private String name;   //角色名称
	private String description;   //角色描述
	private int status;   //状态：1有效；2删除
	private Date createTime;   //创建时间
	private Date updateTime;   //更新时间
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
