package com.lnsf.service;

import java.util.List;

import com.lnsf.model.ProductDetail;

public interface IproductDetailService {
	// �������м�¼�����ؽ������List
	public List<ProductDetail> all();

	// ����
	public void insert(ProductDetail pd);

	// ѭ������insert
	public void circulation(int num, ProductDetail pd);

	// ������Ʒ��ϸID��ɾ����
	public void delete(int productDetailId);

	// ������Ʒ��ϸ����Ϣ
	public void update(ProductDetail pd);
}
