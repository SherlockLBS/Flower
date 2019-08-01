package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Orders;

public interface IorderService {

	// 自动生成订单号
	public String orderId();

	// 查询所有订单
	public List<Orders> all();

	// 修改一条完整的数据
	public void update(Orders o);

	// 插入订单
	public void insert(Orders o);

	// 删除订单
	public void delete(String orderId);

	// 根据id查找
	public Orders selectorderbyid(String orderid);

	// 根据下单日期查找
	public List<Orders> selectByDate(String startDate, String endDate);

	// 修改订单状态
	public void updateState(Orders o);

	// 根据订单状态返回信息
	public List<Orders> orders(int state);

}
