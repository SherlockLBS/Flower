package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.orderDaoImpl;
import com.lnsf.model.Orders;

public class ordertest {
	public static void main(String[] args) {
		// 查找
//		List<Orders> l = new ArrayList<Orders>();
//		orderDaoImpl od = new orderDaoImpl();
//		l = od.all();
//		for (Orders o : l)
//			System.out.println(o.toString());

		// 插入
		// orderDaoImpl od = new orderDaoImpl();
		// Orders o=new Orders();
		// o.setOrder_id("207");
		// o.setDeliver_date("2019/7/31");
		// o.setOrder_date("2019/7/31");
		// o.setFinish_date("2019/7/31");
		// o.setCon_id(8);
		// o.setOrder_price(200);
		// System.out.println(od.insert(o));

		// 删除
		// orderDaoImpl od = new orderDaoImpl();
		// System.out.println(od.delete("207"));

		// 修改
		// orderDaoImpl od = new orderDaoImpl();
		// Orders o=new Orders();
		// o.setOrder_id("207");
		// o.setDeliver_date("2019/7/31");
		// o.setOrder_date("2019/7/31");
		// o.setFinish_date("2019/7/31");
		// o.setCon_id(8);
		// o.setOrder_price(200);
		// o.setState(2);
		// System.out.println(od.update(o));

		// 根据id查找
		// orderDaoImpl od = new orderDaoImpl();
		// System.out.println(od.selectorderbyid("1"));

		// // 根据下单日期查找
		// List<Orders> l = new ArrayList<Orders>();
		// orderDaoImpl od = new orderDaoImpl();
		// l = od.selectByDate("2019/7/1", "2019/8/1");
		// for (Orders o : l)
		// System.out.println(o.toString());

		// 修改订单状态
		// orderDaoImpl od = new orderDaoImpl();
		// Orders o = new Orders();
		// o.setOrder_id("8");
		// o.setState(4);
		// System.out.println(od.updateState(o));
		
		//根据状态返回信息
//		List<Orders> l = new ArrayList<Orders>();
//		orderDaoImpl od = new orderDaoImpl();
//		l = od.orders(4);
//		for (Orders o : l)
//			System.out.println(o.toString());

	}
}
