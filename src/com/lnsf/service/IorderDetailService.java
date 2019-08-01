package com.lnsf.service;

import java.util.List;

import com.lnsf.model.OrderDetail;

public interface IorderDetailService {

	// 查找一条记录
	public OrderDetail selectorderdetailbyid(int orderdetailid);

	// 判断是否存在
	public void selectOrderDetailById(int orderDetailId);

	// 查找所有记录，返回结果集至List
	public List<OrderDetail> all();

	// 增加，返回布尔值
	public void insert(OrderDetail od);

	// 根据订单明细ID“删除”，返回布尔值
	public void delete(int orderDetailId);

	// 修改，返回布尔值
	public void update(OrderDetail od);

	// 根据订单号删除订单详情
	public void deleteOrderDetail(String orderId);
}
