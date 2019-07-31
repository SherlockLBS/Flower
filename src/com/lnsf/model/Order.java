package com.lnsf.model;

public class Order {

	private String order_id;
	private String order_date;
	private String deliver_date;
	private String finish_date;
	private String user_id;
	private int con_id;
	private int order_price;
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getCon_id() {
		return con_id;
	}
	public void setCon_id(int con_id) {
		this.con_id = con_id;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
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
	
	//ππ‘Ï
	public Order(String order_id, String order_date, String deliver_date,
			String finish_date, String user_id, int con_id, int order_price,
			int state, int flag) {
		super();
		this.order_id = order_id;
		this.order_date = order_date;
		this.deliver_date = deliver_date;
		this.finish_date = finish_date;
		this.user_id = user_id;
		this.con_id = con_id;
		this.order_price = order_price;
		this.state = state;
		this.flag = flag;
	}
	
	public Order() {
		super();
	}
	
	//toString
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_date=" + order_date
				+ ", deliver_date=" + deliver_date + ", finish_date="
				+ finish_date + ", user_id=" + user_id + ", con_id=" + con_id
				+ ", order_price=" + order_price + ", state=" + state
				+ ", flag=" + flag + "]";
	}

	
}
