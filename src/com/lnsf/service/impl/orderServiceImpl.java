package com.lnsf.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lnsf.dao.IorderDao;
import com.lnsf.dao.IorderDetailDao;
import com.lnsf.dao.impl.orderDaoImpl;
import com.lnsf.dao.impl.orderDetailDaoImpl;
import com.lnsf.model.OrderDetail;
import com.lnsf.model.Orders;

public class orderServiceImpl {

	private IorderDao IorderDao = new orderDaoImpl();
	private IorderDetailDao IorderDetailDao = new orderDetailDaoImpl();

	// 自动生成订单号
	public String orderId() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String first = sdf.format(date);
		int num = (int) ((Math.random() * 9 + 1) * 100000);
		String second = String.valueOf(num);
		String orderId = first + second;
		return orderId;
	}

	// 查询所有订单
	public List<Orders> all() {
		List<Orders> list = new ArrayList<Orders>();
		list = IorderDao.all();
		for (Orders l : list)
			System.out.println(l);
		return list;
	}

	// 修改一条完整的数据
	public void update(Orders o) {
		boolean flag = IorderDao.update(o);
		if(flag){
			System.out.println("修改成功！");
		}else{
			System.out.println("修改失败！");
		}
	}

	// 插入订单
	public void insert(Orders o) {
		// 生成订单号
		String orderId = orderId();
		// 查询是否有该订单号
		Orders OrderId = IorderDao.selectorderbyid(orderId);
		while (OrderId != null) {
			orderId = orderId();
			OrderId = IorderDao.selectorderbyid(orderId);
		}
		o.setOrder_id(orderId);
		IorderDao.insert(o);
	}

	// 删除订单
	public void delete(String orderId) {
		// 先删除订单详情
		IorderDetailDao.deleteOrderDetail(orderId);
		// 再删除订单
		IorderDao.delete(orderId);
		return;
	}

	// 根据id查找
	public Orders selectorderbyid(String orderid) {
		return IorderDao.selectorderbyid(orderid);
	}

	// 根据下单日期查找
	public List<Orders> selectByDate(String startDate, String endDate){
		List<Orders> l = IorderDao.selectByDate(startDate, endDate);
		if(l.isEmpty()){
			System.out.println("这段期间没有用户下单！");
		}else{
			System.out.println("以下为这段期间提交的订单：");
		}
		return l;
	}
	
	// 修改订单状态
	public void updateState(Orders o){
		boolean flag = IorderDao.updateState(o);
		if(flag){
			System.out.println("修改成功！");
		}else{
			System.out.println("修改失败！");
		}
		
	}
	
	// 根据订单状态返回信息
	public List<Orders> orders(int state){
		List<Orders> l = IorderDao.orders(state);
		if(l.isEmpty()){
			System.out.println("没有订单！");
		}else{
			System.out.println("该状态下的订单如下：");
		}
		return l;
		
	}

}
