package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.OrderDetail;

public interface IorderDetailDao {
	
	//查找一条记录
	public boolean selectOrderDetailById(int orderDetailId);
	
	// 查找所有记录，返回结果集至List
	public List<OrderDetail> all();

	// 增加，返回布尔值
	public boolean insert(OrderDetail od);

	// 根据订单明细ID“删除”，返回布尔值
	public boolean delete(int orderDetailId);

	// 修改，返回布尔值
	public boolean update(OrderDetail od);
}
