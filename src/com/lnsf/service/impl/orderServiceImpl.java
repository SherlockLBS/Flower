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
	
	//�Զ����ɶ�����
	public String orderId(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String first = sdf.format(date);
		int num = (int)((Math.random()*9+1)*100000);
		String second = String.valueOf(num);
		String orderId = first+second;
		return orderId;
	}
	
	
	//��ѯ���ж���
	public List<Orders> all(){
		return IorderDao.all();
	}
	
	//���붩��
	public void insert(Orders o){
		//���ɶ�����
		String orderId = orderId();
		//��ѯ�Ƿ��иö�����
		Orders OrderId = IorderDao.selectorderbyid(orderId);
		while(OrderId != null){
			orderId = orderId();
		}
		o.setOrder_id(orderId);
		IorderDao.insert(o);
	}
	
	//ɾ������
	public boolean delete(String orderId){
		boolean flag = false;
		//��ɾ����������
		IorderDetailDao.deleteOrderDetail(orderId);
		//��ɾ������
		IorderDao.delete(orderId);
		flag = true;
		return flag;	
	}
	
	
	
	

}
