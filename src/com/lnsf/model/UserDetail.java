package com.lnsf.model;

public class UserDetail {
	
	private int userDetail_id;
	private String user_id;
	private String user_tel;
	private String user_sex;
	private int user_point;
	private String register_time;
	private int login_count;
	private String login_time;
	private int flag;
	
	//get/set
	public int getUserDetail_id() {
		return userDetail_id;
	}
	public void setUserDetail_id(int userDetail_id) {
		this.userDetail_id = userDetail_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public int getUser_point() {
		return user_point;
	}
	public void setUser_point(int user_point) {
		this.user_point = user_point;
	}
	public String getRegister_time() {
		return register_time;
	}
	public void setRegister_time(String register_time) {
		this.register_time = register_time;
	}
	public int getLogin_count() {
		return login_count;
	}
	public void setLogin_count(int login_count) {
		this.login_count = login_count;
	}
	public String getLogin_time() {
		return login_time;
	}
	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	//构造
	public UserDetail() {
		super();
	}
	public UserDetail(int userDetail_id, String user_id, String user_tel,
			String user_sex, int user_point, String register_time,
			int login_count, String login_time, int flag) {
		super();
		this.userDetail_id = userDetail_id;
		this.user_id = user_id;
		this.user_tel = user_tel;
		this.user_sex = user_sex;
		this.user_point = user_point;
		this.register_time = register_time;
		this.login_count = login_count;
		this.login_time = login_time;
		this.flag = flag;
	}
	
	//toString
	@Override
	public String toString() {
		return "用户详情编号：" + userDetail_id 
				+ "  用户编号：" + user_id 
				+ "  电话：" + user_tel + "  性别：" + user_sex
				+ "  积分：" + user_point + "  注册时间：" + register_time 
				+ "  登陆次数：" + login_count + "  最后登陆时间：" 
				+ login_time + "  标志位：" + flag;
	}	

}
