package com.lnsf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.lnsf.dao.IorderDao;
import com.lnsf.model.Orders;

public class orderServiceImpl {
	
	private IorderDao orderDaoImpl;
	
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
		return orderDaoImpl.all();
	}
	
	//插入订单
	public void insert(Orders o){
		
	}

}
