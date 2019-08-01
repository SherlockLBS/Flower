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

	// �Զ����ɶ�����
	public String orderId() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String first = sdf.format(date);
		int num = (int) ((Math.random() * 9 + 1) * 100000);
		String second = String.valueOf(num);
		String orderId = first + second;
		return orderId;
	}

	// ��ѯ���ж���
	public List<Orders> all() {
		List<Orders> list = new ArrayList<Orders>();
		list = IorderDao.all();
		for (Orders l : list)
			System.out.println(l);
		return list;
	}

	// �޸�һ������������
	public void update(Orders o) {
		boolean flag = IorderDao.update(o);
		if(flag){
			System.out.println("�޸ĳɹ���");
		}else{
			System.out.println("�޸�ʧ�ܣ�");
		}
	}

	// ���붩��
	public void insert(Orders o) {
		// ���ɶ�����
		String orderId = orderId();
		// ��ѯ�Ƿ��иö�����
		Orders OrderId = IorderDao.selectorderbyid(orderId);
		while (OrderId != null) {
			orderId = orderId();
			OrderId = IorderDao.selectorderbyid(orderId);
		}
		o.setOrder_id(orderId);
		IorderDao.insert(o);
	}

	// ɾ������
	public void delete(String orderId) {
		// ��ɾ����������
		IorderDetailDao.deleteOrderDetail(orderId);
		// ��ɾ������
		IorderDao.delete(orderId);
		return;
	}

	// ����id����
	public Orders selectorderbyid(String orderid) {
		return IorderDao.selectorderbyid(orderid);
	}

	// �����µ����ڲ���
	public List<Orders> selectByDate(String startDate, String endDate){
		List<Orders> l = IorderDao.selectByDate(startDate, endDate);
		if(l.isEmpty()){
			System.out.println("����ڼ�û���û��µ���");
		}else{
			System.out.println("����Ϊ����ڼ��ύ�Ķ�����");
		}
		return l;
	}
	
	// �޸Ķ���״̬
	public void updateState(Orders o){
		boolean flag = IorderDao.updateState(o);
		if(flag){
			System.out.println("�޸ĳɹ���");
		}else{
			System.out.println("�޸�ʧ�ܣ�");
		}
		
	}
	
	// ���ݶ���״̬������Ϣ
	public List<Orders> orders(int state){
		List<Orders> l = IorderDao.orders(state);
		if(l.isEmpty()){
			System.out.println("û�ж�����");
		}else{
			System.out.println("��״̬�µĶ������£�");
		}
		return l;
		
	}

}
