package com.lnsf.model;

public class User {
	
	private String user_id;
	private String user_name;
	private String password;
	private int role;
	private int flag;
	
	//get/set
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	//构造
	public User() {
		super();
	}
	public User(String user_id, String user_name, String password, int role,
			int flag) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.role = role;
		this.flag = flag;
	}
	
	//toString
	public String toString() {
		return "用户编号：" + user_id + "  用户名：" + user_name
				+ "    密码：" + password + "    权限：" + role + "   标志位："
				+ flag;
	}
	

}
