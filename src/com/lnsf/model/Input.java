package com.lnsf.model;

public class Input {

	private int input_id;
	private int flower_id;
	private int input_num;
	private float input_price;
	private String input_date;
	private int flag;
	
	//get/set
	public int getInput_id() {
		return input_id;
	}
	public void setInput_id(int input_id) {
		this.input_id = input_id;
	}
	public int getFlower_id() {
		return flower_id;
	}
	public void setFlower_id(int flower_id) {
		this.flower_id = flower_id;
	}
	public int getInput_num() {
		return input_num;
	}
	public void setInput_num(int input_num) {
		this.input_num = input_num;
	}
	public float getInput_price() {
		return input_price;
	}
	public void setInput_price(float input_price) {
		this.input_price = input_price;
	}
	public String getInput_date() {
		return input_date;
	}
	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	//构造
	public Input(int input_id, int flower_id, int input_num, float input_price,
			String input_date, int flag) {
		super();
		this.input_id = input_id;
		this.flower_id = flower_id;
		this.input_num = input_num;
		this.input_price = input_price;
		this.input_date = input_date;
		this.flag = flag;
	}
	public Input() {
		super();
	}
	
	//toString
	@Override
	public String toString() {
		return "进货编号：" + input_id + "  库存编号： " + flower_id
				+ "  进货数量：" + input_num + "  进货总价：" + input_price
				+ "  进货日期：" + input_date + "  标志：" + flag ;
	}
	
	
	
	
}
