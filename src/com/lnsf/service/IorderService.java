package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Orders;

public interface IorderService {

	// �Զ����ɶ�����
	public String orderId();

	// ��ѯ���ж���
	public List<Orders> all();

	// �޸�һ������������
	public void update(Orders o);

	// ���붩��
	public void insert(Orders o);

	// ɾ������
	public void delete(String orderId);

	// ����id����
	public Orders selectorderbyid(String orderid);

	// �����µ����ڲ���
	public List<Orders> selectByDate(String startDate, String endDate);

	// �޸Ķ���״̬
	public void updateState(Orders o);

	// ���ݶ���״̬������Ϣ
	public List<Orders> orders(int state);

}
