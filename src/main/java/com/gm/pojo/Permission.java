package com.gm.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * @Description: 权限实体类
 * @Author: guomeng
 * @Date: 2019/9/20 8:45
 **/
public class Permission implements Serializable {
	private static final long serialVersionUID = -3883182296105358494L;
	private int id;   //
	private String permissionId;   //权限id
	private String name;   //权限名称
	private String description;   //权限描述
	private String url;   //权限访问路径
	private String perms;   //权限标识
	private int parentId;   //父级权限id
	private int type;   //类型   0：目录   1：菜单   2：按钮
	private int orderNum;   //排序
	private String icon;   //图标
	private int status;   //状态：1有效；2删除
	private Date createTime;   //创建时间
	private Date updateTime;   //更新时间
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPerms() {
		return perms;
	}
	public void setPerms(String perms) {
		this.perms = perms;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
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
