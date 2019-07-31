package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.OrderDetail;

public interface IorderDetailDao {
	
	//����һ����¼
	public boolean selectOrderDetailById(int orderDetailId);
	
	// �������м�¼�����ؽ������List
	public List<OrderDetail> all();

	// ���ӣ����ز���ֵ
	public boolean insert(OrderDetail od);

	// ���ݶ�����ϸID��ɾ���������ز���ֵ
	public boolean delete(int orderDetailId);

	// �޸ģ����ز���ֵ
	public boolean update(OrderDetail od);
}
