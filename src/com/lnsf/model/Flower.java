package com.lnsf.model;

public class Flower {
	
	private int flower_id;
	private String flower_name;
	private int stock;
	private float flower_price;
	private int flag;
	
	//构造
	public Flower() {
		super();
	}
	public Flower(int flower_id, String flower_name, int stock,
			int flower_price, int flag) {
		super();
		this.flower_id = flower_id;
		this.flower_name = flower_name;
		this.stock = stock;
		this.flower_price = flower_price;
		this.flag = flag;
	}
	
	//get/set
	public int getFlower_id() {
		return flower_id;
	}
	public void setFlower_id(int flower_id) {
		this.flower_id = flower_id;
	}
	public String getFlower_name() {
		return flower_name;
	}
	public void setFlower_name(String flower_name) {
		this.flower_name = flower_name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public float getFlower_price() {
		return flower_price;
	}
	public void setFlower_price(float f) {
		this.flower_price = f;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "库存编号：" + flower_id + "  库存鲜花名称："
				+ flower_name + "  库存量：" + stock + "  鲜花单价："
				+ flower_price + "  标志：" + flag ;
	}

}
