package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Orders;

public interface IorderDao {
	// 查找所有记录，返回结果集至List
	public List<Orders> all();

	// 增加，返回布尔值
	public boolean insert(Orders o);

	// 根据订单ID“删除”，返回布尔值
	public boolean delete(String orderid);

	// 修改，返回布尔值
	public boolean update(Orders o);

	// 根据id查找
	public Orders selectorderbyid(String orderid);

	// 根据下单日期查找
	public List<Orders> selectByDate(String startDate, String endDate);
	
	//修改订单状态
	public boolean updateState(Orders o);

}
