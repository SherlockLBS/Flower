package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Orders;

public interface IorderService {

	//�Զ����ɶ�����
	public String orderId();
	
	//��ѯ���ж���
	public List<Orders> all();
	
	//���붩��
	public void insert(Orders o);
	
	//ɾ������
	public boolean delete(String orderId);
	
	
}
