package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Orders;

public interface IorderService {

	//自动生成订单号
	public String orderId();
	
	//查询所有订单
	public List<Orders> all();
	
	//插入订单
	public void insert(Orders o);
	
	//删除订单
	public boolean delete(String orderId);
	
	
}
