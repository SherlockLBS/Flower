package com.lnsf.model;

public class Product {

	private int product_id;
	private String product_name;
	private float product_price;
	private String remark;
	private int use_id;
	private int object_id;
	private int festival_id;
	private int som_id;
	private int flag;
	
	//get/set
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public float getProduct_price() {
		return product_price;
	}
	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getUse_id() {
		return use_id;
	}
	public void setUse_id(int use_id) {
		this.use_id = use_id;
	}
	public int getObject_id() {
		return object_id;
	}
	public void setObject_id(int object_id) {
		this.object_id = object_id;
	}
	public int getFestival_id() {
		return festival_id;
	}
	public void setFestival_id(int festival_id) {
		this.festival_id = festival_id;
	}
	public int getSom_id() {
		return som_id;
	}
	public void setSom_id(int som_id) {
		this.som_id = som_id;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	//构造
	public Product() {
		super();
	}
	public Product(int product_id, String product_name, float product_price,
			String remark, int use_id, int object_id, int festival_id,
			int som_id, int flag) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.remark = remark;
		this.use_id = use_id;
		this.object_id = object_id;
		this.festival_id = festival_id;
		this.som_id = som_id;
		this.flag = flag;
	}
	
	//toString
	@Override
	public String toString() {
		return "商品编号：" + product_id + "  商品名称：" + product_name 
				+ "  商品价格：" + product_price + "  备注：" + remark 
				+ "  用途：" + use_id + "  对象：" + object_id 
				+ "  节日：" + festival_id + "  支/束：" + som_id 
				+ "  标志位：" + flag;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + festival_id;
		result = prime * result + flag;
		result = prime * result + object_id;
		result = prime * result + product_id;
		result = prime * result
				+ ((product_name == null) ? 0 : product_name.hashCode());
		result = prime * result + Float.floatToIntBits(product_price);
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + som_id;
		result = prime * result + use_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (festival_id != other.festival_id)
			return false;
		if (flag != other.flag)
			return false;
		if (object_id != other.object_id)
			return false;
		if (product_id != other.product_id)
			return false;
		if (product_name == null) {
			if (other.product_name != null)
				return false;
		} else if (!product_name.equals(other.product_name))
			return false;
		if (Float.floatToIntBits(product_price) != Float
				.floatToIntBits(other.product_price))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (som_id != other.som_id)
			return false;
		if (use_id != other.use_id)
			return false;
		return true;
	}

}
