package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.OrderDetail;
import com.lnsf.model.Orders;

public interface IorderDetailDao {
	
	//����һ����¼
	public OrderDetail selectorderdetailbyid(int orderdetailid);
	
	//�ж�ID�Ƿ����
	public boolean selectOrderDetailById(int orderDetailId);
	
	//����orderId&productId����һ����¼
	public OrderDetail selectOrderDetailByOrderIdAndProductId(String orderId, int productId);
	
	// �������м�¼�����ؽ������List
	public List<OrderDetail> all();

	// ���ӣ����ز���ֵ
	public boolean insert(OrderDetail od);

	// ���ݶ�����ϸID��ɾ���������ز���ֵ
	public boolean delete(int orderDetailId);

	// �޸ģ����ز���ֵ
	public boolean update(OrderDetail od);
	
	//���ݶ�����ɾ����������
	public boolean deleteOrderDetail(String orderId);
}
