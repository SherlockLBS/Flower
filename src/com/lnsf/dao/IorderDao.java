package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Orders;

public interface IorderDao {
	// �������м�¼�����ؽ������List
	public List<Orders> all();

	// ���ӣ����ز���ֵ
	public boolean insert(Orders o);

	// ���ݶ���ID��ɾ���������ز���ֵ
	public boolean delete(String orderid);

	// �޸ģ����ز���ֵ
	public boolean update(Orders o);

	// ����id����
	public Orders selectorderbyid(String orderid);

	// �����µ����ڲ���
	public List<Orders> selectByDate(String startDate, String endDate);
	
	//�޸Ķ���״̬
	public boolean updateState(Orders o);

}
