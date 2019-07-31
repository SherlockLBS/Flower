package com.lnsf.model;

public class Level {
	
	private int level_id;
	private String level_name;
	private int low_point;
	private int high_point;
	private int flag;
	
	//get/set
	public int getLevel_id() {
		return level_id;
	}
	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}
	public String getLevel_name() {
		return level_name;
	}
	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}
	public int getLow_point() {
		return low_point;
	}
	public void setLow_point(int low_point) {
		this.low_point = low_point;
	}
	public int getHigh_point() {
		return high_point;
	}
	public void setHigh_point(int high_point) {
		this.high_point = high_point;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	//构造
	public Level() {
		super();
	}
	public Level(int level_id, String level_name, int low_point,
			int high_point, int flag) {
		super();
		this.level_id = level_id;
		this.level_name = level_name;
		this.low_point = low_point;
		this.high_point = high_point;
		this.flag = flag;
	}
	
	//toString
	@Override
	public String toString() {
		return "等级编号：" + level_id + "  等级名称：" + level_name
				+ "  最低积分：" + low_point + "  最高积分：" + high_point
				+ "  标志：" + flag ;
	}
	

}
