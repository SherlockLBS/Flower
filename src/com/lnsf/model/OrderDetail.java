package com.lnsf.model;

public class OrderDetail {

	private int orderDetail_id;
	private String order_id;
	private int product_id;
	private int product_count;
	private int flag;
	
	//get/set
	public int getOrderDetail_id() {
		return orderDetail_id;
	}
	public void setOrderDetail_id(int orderDetail_id) {
		this.orderDetail_id = orderDetail_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getProduct_count() {
		return product_count;
	}
	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	//构造
	public OrderDetail(int orderDetail_id, String order_id, int product_id,
			int product_count, int flag) {
		super();
		this.orderDetail_id = orderDetail_id;
		this.order_id = order_id;
		this.product_id = product_id;
		this.product_count = product_count;
		this.flag = flag;
	}
	
	public OrderDetail() {
		super();

	}
	
	//toString
	@Override
	public String toString() {
		return "订单详情编号：" + orderDetail_id + "  订单编号：" + order_id 
				+ "  商品编号：" + product_id + "  商品数量：" + product_count 
				+ "  标志位：" + flag;
	}
	
	

	
}
