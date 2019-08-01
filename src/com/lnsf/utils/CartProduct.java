package com.lnsf.utils;

public class CartProduct {
	private int product_id;
	private float product_price;
	private int num;
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public float getProduct_price() {
		return product_price;
	}
	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + product_id;
		result = prime * result + Float.floatToIntBits(product_price);
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
		CartProduct other = (CartProduct) obj;
		if (product_id != other.product_id)
			return false;
		if (Float.floatToIntBits(product_price) != Float
				.floatToIntBits(other.product_price))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "CartProduct [product_id=" + product_id + ", product_price="
				+ product_price + ", num=" + num + "]";
	}
	
	
}
