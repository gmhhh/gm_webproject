package com.gm.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 用户实体类
 * @Author: guomeng
 * @Date: 2019/9/20 8:45
 **/
public class User implements Serializable {
	private static final long serialVersionUID = 8155411466131334044L;
	private int	id;   //
	private String userId;   //用户id
	private String userName;   //用户名
	private String passWord;   //密码
	private String salt;   //盐
	private String name;   //昵称
	private String email;   //邮箱
	private String phone;   //电话
	private int sex;   //性别：1男2女
	private int	age;   //年龄
	private int	status;   //用户状态：1有效; 2删除
	private Date createTime;   //创建时间
	private Date updateTime;   //修改时间
	private Date lastLoginTime;   //最后登录时间
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}
