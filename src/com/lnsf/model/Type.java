package com.lnsf.model;

public class Type {
	private int type_id;
	private String type_name;
	private int flag;
	//构造
	public Type() {
		super();
	}
	public Type(int type_id, String type_name, int flag) {
		super();
		this.type_id = type_id;
		this.type_name = type_name;
		this.flag = flag;
	}
	//get/set
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	//toString
	@Override
	public String toString() {
		return "分类编号：" + type_id + "  类别名称：" + type_name
				+ "  标志：" + flag ;
	}
	
}
