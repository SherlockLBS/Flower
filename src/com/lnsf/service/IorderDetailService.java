package com.lnsf.service;

import java.util.List;

import com.lnsf.model.OrderDetail;

public interface IorderDetailService {

	// ����һ����¼
	public OrderDetail selectorderdetailbyid(int orderdetailid);

	// �ж��Ƿ����
	public void selectOrderDetailById(int orderDetailId);

	// �������м�¼�����ؽ������List
	public List<OrderDetail> all();

	// ���ӣ����ز���ֵ
	public void insert(OrderDetail od);

	// ���ݶ�����ϸID��ɾ���������ز���ֵ
	public void delete(int orderDetailId);

	// �޸ģ����ز���ֵ
	public void update(OrderDetail od);

	// ���ݶ�����ɾ����������
	public void deleteOrderDetail(String orderId);
}
