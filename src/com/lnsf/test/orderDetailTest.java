package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.orderDetailDaoImpl;
import com.lnsf.model.OrderDetail;
import com.lnsf.service.impl.orderDetailServiceImpl;

public class orderDetailTest {

	public static void main(String[] args) {

		// ����ȫ��
//		 orderDetailDaoImpl od = new orderDetailDaoImpl();
//		 List<OrderDetail> list = new ArrayList<OrderDetail>();
//		 list = od.all();
//		 for(OrderDetail l:list)
//		 System.out.println(l);

		// ���
//		 orderDetailDaoImpl od = new orderDetailDaoImpl();
//		 OrderDetail orderDetail= new OrderDetail();
//		 orderDetail.setOrder_id("10");
//		 orderDetail.setProduct_id(50);
//		 orderDetail.setProduct_count(1);
//		 boolean flag = od.insert(orderDetail);
//		 System.out.println(flag);

		// ����
//		 orderDetailDaoImpl od = new orderDetailDaoImpl();
//		 OrderDetail orderDetail = new OrderDetail();
//		 orderDetail.setOrderDetail_id(17);
//		 orderDetail.setOrder_id("10");
//		 orderDetail.setProduct_id(49);
//		 orderDetail.setProduct_count(2);
//		 boolean flag = od.update(orderDetail);
//		 System.out.println(flag);

		// ɾ��
//		 orderDetailDaoImpl od = new orderDetailDaoImpl();
//		 boolean flag = od.delete(17);
//		 System.out.println(flag);

		// ��ѯһ����¼
//		 orderDetailDaoImpl od = new orderDetailDaoImpl();
//		 boolean flag = od.selectOrderDetailById(15);
//		 System.out.println(flag);

		// ����orderIdɾ����������
//		 orderDetailDaoImpl od = new orderDetailDaoImpl();
//		 boolean flag = od.deleteOrderDetail("1");
//		 System.out.println(flag);

		//����orderDetailId��ѯ��������
//		orderDetailDaoImpl od = new orderDetailDaoImpl();
//		System.out.println(od.selectorderdetailbyid(2));
		
		//����Impl
		orderDetailServiceImpl ods = new orderDetailServiceImpl();
		ods.all();

	}

}
