package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Product;

public interface IproductService {

	// �������м�¼�����ؽ������List
	public List<Product> all();

	// ������Ʒ
	public void insert(Product p);

	// ������Ʒ���Ʋ��Ҽ�¼
	public Product selectProductByName(String productname);

	// ������ƷID��ɾ����
	public void delete(int productId);

	// ������Ʒ
	public void update(Product p);

}
