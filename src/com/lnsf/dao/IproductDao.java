package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Product;

public interface IproductDao {
	
	//���Ҽ�¼�Ƿ����
	public boolean selectProductById(int productId);
	
	// �������м�¼�����ؽ������List
	public List<Product> all();

	// ���ӣ����ز���ֵ
	public boolean insert(Product p);

	// ������ƷID��ɾ���������ز���ֵ
	public boolean delete(int productId);

	// �޸ģ����ز���ֵ
	public boolean update(Product p);
}
