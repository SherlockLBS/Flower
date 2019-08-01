package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.orderDetailDaoImpl;
import com.lnsf.model.OrderDetail;
import com.lnsf.service.impl.orderDetailServiceImpl;

public class orderDetailTest {

	public static void main(String[] args) {

		// 查找全部
//		 orderDetailDaoImpl od = new orderDetailDaoImpl();
//		 List<OrderDetail> list = new ArrayList<OrderDetail>();
//		 list = od.all();
//		 for(OrderDetail l:list)
//		 System.out.println(l);

		// 添加
//		 orderDetailDaoImpl od = new orderDetailDaoImpl();
//		 OrderDetail orderDetail= new OrderDetail();
//		 orderDetail.setOrder_id("10");
//		 orderDetail.setProduct_id(50);
//		 orderDetail.setProduct_count(1);
//		 boolean flag = od.insert(orderDetail);
//		 System.out.println(flag);

		// 更新
//		 orderDetailDaoImpl od = new orderDetailDaoImpl();
//		 OrderDetail orderDetail = new OrderDetail();
//		 orderDetail.setOrderDetail_id(17);
//		 orderDetail.setOrder_id("10");
//		 orderDetail.setProduct_id(49);
//		 orderDetail.setProduct_count(2);
//		 boolean flag = od.update(orderDetail);
//		 System.out.println(flag);

		// 删除
//		 orderDetailDaoImpl od = new orderDetailDaoImpl();
//		 boolean flag = od.delete(17);
//		 System.out.println(flag);

		// 查询一条记录
//		 orderDetailDaoImpl od = new orderDetailDaoImpl();
//		 boolean flag = od.selectOrderDetailById(15);
//		 System.out.println(flag);

		// 根据orderId删除订单详情
//		 orderDetailDaoImpl od = new orderDetailDaoImpl();
//		 boolean flag = od.deleteOrderDetail("1");
//		 System.out.println(flag);

		//根据orderDetailId查询订单详情
//		orderDetailDaoImpl od = new orderDetailDaoImpl();
//		System.out.println(od.selectorderdetailbyid(2));
		
		//测试Impl
		orderDetailServiceImpl ods = new orderDetailServiceImpl();
		ods.all();

	}

}
