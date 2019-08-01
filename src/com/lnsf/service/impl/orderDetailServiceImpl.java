package com.lnsf.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.orderDetailDaoImpl;
import com.lnsf.dao.IorderDetailDao;
import com.lnsf.model.OrderDetail;

public class orderDetailServiceImpl {

	private IorderDetailDao IorderDetailDao = new orderDetailDaoImpl();

	// 查找一条记录
	public OrderDetail selectorderdetailbyid(int orderdetailid) {
		OrderDetail orderDetail = IorderDetailDao
				.selectorderdetailbyid(orderdetailid);
		if (orderDetail == null) {
			System.out.println("不存在该记录！");
		} else {
			System.out.println("信息如下：");
		}
		return orderDetail;

	}

	// 判断是否存在
	public void selectOrderDetailById(int orderDetailId) {
		boolean existId = IorderDetailDao.selectOrderDetailById(orderDetailId);
		if (existId) {
			System.out.println("不存在该记录！");
		} else {
			System.out.println("信息如下：");
		}
	}

	// 查找所有记录，返回结果集至List
	public List<OrderDetail> all() {
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		list = IorderDetailDao.all();
		for (OrderDetail l : list)
			System.out.println(l);
		return list;
	}

	// 增加商品
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

	// 根据订单明细ID“删除”
	public void delete(int orderDetailId) {
		boolean flag = IorderDetailDao.delete(orderDetailId);
		if (flag) {
			System.out.println("删除成功！");
		} else {
			System.out.println("删除失败");
		}

	}

	// 修改
	public void update(OrderDetail od) {
		boolean flag = IorderDetailDao.update(od);
		if (flag) {
			System.out.println("修改成功！");
		} else {
			System.out.println("修改失败！");
		}
	}

	// 根据订单号删除订单详情
	public void deleteOrderDetail(String orderId) {
		boolean flag = IorderDetailDao.deleteOrderDetail(orderId);
		if (flag) {
			System.out.println("删除成功！");
		} else {
			System.out.println("删除失败！");
		}
	}

}
