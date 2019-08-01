package com.lnsf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.lnsf.dao.IorderDao;
import com.lnsf.dao.IorderDetailDao;
import com.lnsf.dao.impl.orderDaoImpl;
import com.lnsf.dao.impl.orderDetailDaoImpl;
import com.lnsf.model.Orders;

public class orderServiceImpl {
	
	private IorderDao IorderDao = new orderDaoImpl();
	private IorderDetailDao IorderDetailDao = new orderDetailDaoImpl();
	
	//自动生成订单号
	public String orderId(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String first = sdf.format(date);
		int num = (int)((Math.random()*9+1)*100000);
		String second = String.valueOf(num);
		String orderId = first+second;
		return orderId;
	}
	
	
	//查询所有订单
	public List<Orders> all(){
		return IorderDao.all();
	}
	
	//插入订单
	public void insert(Orders o){
		//生成订单号
		String orderId = orderId();
		//查询是否有该订单号
		Orders OrderId = IorderDao.selectorderbyid(orderId);
		while(OrderId != null){
			orderId = orderId();
		}
		o.setOrder_id(orderId);
		IorderDao.insert(o);
	}
	
	//删除订单
	public boolean delete(String orderId){
		boolean flag = false;
		//先删除订单详情
		IorderDetailDao.deleteOrderDetail(orderId);
		//再删除订单
		IorderDao.delete(orderId);
		flag = true;
		return flag;	
	}
	
	
	
	

}
