package com.lnsf.model;

public class Consignee {

	private int con_id;
	private String con_name;
	private String con_tel;
	private String con_addr;
	private String user_id;
	private int flag;

	// get/set
	public int getCon_id() {
		return con_id;
	}

	public void setCon_id(int con_id) {
		this.con_id = con_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCon_name() {
		return con_name;
	}

	public void setCon_name(String con_name) {
		this.con_name = con_name;
	}

	public String getCon_tel() {
		return con_tel;
	}

	public void setCon_tel(String con_tel) {
		this.con_tel = con_tel;
	}

	public String getCon_addr() {
		return con_addr;
	}

	public void setCon_addr(String con_addr) {
		this.con_addr = con_addr;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	// 构造
	public Consignee() {
		super();
	}

	public Consignee(int con_id, String con_name, String con_tel, String con_addr,
			String user_id, int flag) {
		super();
		this.con_id = con_id;
		this.con_name = con_name;
		this.con_tel = con_tel;
		this.con_addr = con_addr;
		this.user_id = user_id;
		this.flag = flag;
	}
	

	//
	@Override
	public String toString() {
		return "收货人编号：" + con_id + "  收货人名称：" + con_name + "  收货人电话：" + con_tel
				+ "  收货人地址：" + con_addr + " 会员编号：" + user_id + "  标志：" + flag;
	}



}
