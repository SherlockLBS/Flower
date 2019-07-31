package com.lnsf.model;

public class ProductDetail {
	
	private int productDetail_id;
	private int product_id;
	private int flower_id;
	private int flower_num;
	private int flag;
	public int getProductDetail_id() {
		return productDetail_id;
	}
	public void setProductDetail_id(int productDetail_id) {
		this.productDetail_id = productDetail_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getFlower_id() {
		return flower_id;
	}
	public void setFlower_id(int flower_id) {
		this.flower_id = flower_id;
	}
	public int getFlower_num() {
		return flower_num;
	}
	public void setFlower_num(int flower_num) {
		this.flower_num = flower_num;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	//���췽��
	public ProductDetail() {
		super();
	}
	public ProductDetail(int productDetail_id, int product_id, int flower_id,
			int flower_num, int flag) {
		super();
		this.productDetail_id = productDetail_id;
		this.product_id = product_id;
		this.flower_id = flower_id;
		this.flower_num = flower_num;
		this.flag = flag;
	}
	
	//toString
	@Override
	public String toString() {
		return "��Ʒ�����ţ�" + productDetail_id + "  ��Ʒ��ţ�" + product_id 
				+ "  �ʻ���ţ�" + flower_id + "  �ʻ�������" + flower_num 
				+ "  ��־λ��" + flag;
	}

}
