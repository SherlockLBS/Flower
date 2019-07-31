package com.lnsf.model;

public class Orders {

	private String order_id;
	private String order_date;
	private String deliver_date;
	private String finish_date;
	private int con_id;
	private float order_price;
	private int state;
	private int flag;
	
	//get/set
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getDeliver_date() {
		return deliver_date;
	}
	public void setDeliver_date(String deliver_date) {
		this.deliver_date = deliver_date;
	}
	public String getFinish_date() {
		return finish_date;
	}
	public void setFinish_date(String finish_date) {
		this.finish_date = finish_date;
	}
	public int getCon_id() {
		return con_id;
	}
	public void setCon_id(int con_id) {
		this.con_id = con_id;
	}
	public float getOrder_price() {
		return order_price;
	}
	public void setOrder_price(float d) {
		this.order_price = d;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	//构造
	public Orders(String order_id, String order_date, String deliver_date,
			String finish_date, int con_id, float order_price,
			int state, int flag) {
		super();
		this.order_id = order_id;
		this.order_date = order_date;
		this.deliver_date = deliver_date;
		this.finish_date = finish_date;
		this.con_id = con_id;
		this.order_price = order_price;
		this.state = state;
		this.flag = flag;
	}
	
	public Orders() {
		super();
	}
	
	//toString
	@Override
	public String toString() {
		return "订单编号：" + order_id + "  下单日期： " + order_date
				+ "  发货日期：" + deliver_date + "  收货日期："
				+ finish_date + "  收货人编号：" + con_id
				+ "  订单价格：" + order_price + " 订单状态：" + state
				+ "  标志：" + flag ;
	}

	
}
