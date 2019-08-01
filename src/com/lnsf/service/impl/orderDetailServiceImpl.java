package com.lnsf.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.orderDetailDaoImpl;
import com.lnsf.dao.IorderDetailDao;
import com.lnsf.model.OrderDetail;

public class orderDetailServiceImpl {

	private IorderDetailDao IorderDetailDao = new orderDetailDaoImpl();

	// ����һ����¼
	public OrderDetail selectorderdetailbyid(int orderdetailid) {
		OrderDetail orderDetail = IorderDetailDao
				.selectorderdetailbyid(orderdetailid);
		if (orderDetail == null) {
			System.out.println("�����ڸü�¼��");
		} else {
			System.out.println("��Ϣ���£�");
		}
		return orderDetail;

	}

	// �ж��Ƿ����
	public void selectOrderDetailById(int orderDetailId) {
		boolean existId = IorderDetailDao.selectOrderDetailById(orderDetailId);
		if (existId) {
			System.out.println("�����ڸü�¼��");
		} else {
			System.out.println("��Ϣ���£�");
		}
	}

	// �������м�¼�����ؽ������List
	public List<OrderDetail> all() {
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		list = IorderDetailDao.all();
		for (OrderDetail l : list)
			System.out.println(l);
		return list;
	}

	// ������Ʒ
	public void insert(OrderDetail od) {
		String orderId = od.getOrder_id();
		int productId = od.getProduct_id();
		OrderDetail old = IorderDetailDao
				.selectOrderDetailByOrderIdAndProductId(orderId, productId);
		if (old == null) {
			IorderDetailDao.insert(od);
		} else {
			old.setProduct_count(old.getProduct_count() + od.getProduct_count());
		}
	}

	// ���ݶ�����ϸID��ɾ����
	public void delete(int orderDetailId) {
		boolean flag = IorderDetailDao.delete(orderDetailId);
		if (flag) {
			System.out.println("ɾ���ɹ���");
		} else {
			System.out.println("ɾ��ʧ��");
		}

	}

	// �޸�
	public void update(OrderDetail od) {
		boolean flag = IorderDetailDao.update(od);
		if (flag) {
			System.out.println("�޸ĳɹ���");
		} else {
			System.out.println("�޸�ʧ�ܣ�");
		}
	}

	// ���ݶ�����ɾ����������
	public void deleteOrderDetail(String orderId) {
		boolean flag = IorderDetailDao.deleteOrderDetail(orderId);
		if (flag) {
			System.out.println("ɾ���ɹ���");
		} else {
			System.out.println("ɾ��ʧ�ܣ�");
		}
	}

}
