package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.ProductDetail;

public interface IproductDetailDao {
	
	//��ѯһ����¼�Ƿ����
	public boolean selectProductDetailById(int productDetailId);
	
	// �������м�¼�����ؽ������List
	public List<ProductDetail> all();

	// ���ӣ����ز���ֵ
	public boolean insert(ProductDetail pd);

	// ������Ʒ��ϸID��ɾ���������ز���ֵ
	public boolean delete(int productDetailId);

	// �޸ģ����ز���ֵ
	public boolean update(ProductDetail pd);
}
