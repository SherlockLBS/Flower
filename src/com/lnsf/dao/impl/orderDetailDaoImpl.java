package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IorderDetailDao;
import com.lnsf.model.OrderDetail;
import com.lnsf.utils.DataAccess;

public class orderDetailDaoImpl implements IorderDetailDao {

	// 查找一条记录
	public boolean selectOrderDetailById(int orderDetailId) {
		String sql = "select * from orderDetail where orderDetail_id = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setInt(1, orderDetailId);
			rs = prepstat.executeQuery();
			if (rs.next()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}
		return flag;
	}

	// 查找所有记录，返回结果集至List
	public List<OrderDetail> all() {
		String sql = "select * from orderDetail";
		List<OrderDetail> l = new ArrayList<OrderDetail>();// 新建对象数组，存放得到的结果集
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			prepstat = conn.prepareStatement(sql);// SQL语句
			rs = prepstat.executeQuery();// 执行SQL语句，得到结果集
			while (rs.next()) {
				// 新建对象，并通过构造方法，将结果集中的每一条记录封装成一个对象
				OrderDetail od = new OrderDetail(rs.getInt("orderDetail_id"),
						rs.getString("order_id"), rs.getInt("product_id"), 
						rs.getInt("product_count"), rs.getInt("flag"));
				// 将得到的对象添加到对象数组
				l.add(od);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// 关闭连接
		}
		return l;// 返回最终得到的对象数组

	}

	// 增加，返回布尔值
	public boolean insert(OrderDetail od) {
		String sql = "insert into orderDetail(order_id, product_id, product_count) "
				+ "values (?,?,?)";
		// 得到对象中的内容
		String order_id = od.getOrder_id();
		int product_id = od.getProduct_id();
		int product_count = od.getProduct_count();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			prepstat = conn.prepareStatement(sql);// SQL语句
			prepstat.setString(1, order_id);
			prepstat.setInt(2, product_id);
			prepstat.setInt(3, product_count);
			prepstat.executeUpdate();// 执行SQL语句
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// 关闭连接
		}
		return flag;// SQL语句执行成功返回true，失败返回false

	}

	// 根据订单明细ID“删除”，返回布尔值
	public boolean delete(int orderDetailId) {
		String sql = "update orderDetail set flag = 0 where orderDetail_id = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			// 根据product_id确定记录
			prepstat = conn.prepareStatement(sql);// SQL语句
			prepstat.setInt(1, orderDetailId);
			prepstat.executeUpdate();// 执行SQL语句
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// 关闭连接
		}
		return flag;// SQL语句执行成功返回true，失败返回false

	}

	// 修改，返回布尔值
	public boolean update(OrderDetail od) {
		String sql = "update orderDetail set order_id = ?, product_id = ?, product_count = ?  where orderDetail_id = ?";
		// 得到对象中的内容
		int orderDetail_id = od.getOrderDetail_id();
		String order_id = od.getOrder_id();
		int product_id = od.getProduct_id();
		int product_count = od.getProduct_count();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			prepstat = conn.prepareStatement(sql);// SQL语句
			// 根据product_id确定记录
			prepstat.setString(1, order_id);
			prepstat.setInt(2, product_id);
			prepstat.setInt(3, product_count);
			prepstat.setInt(4, orderDetail_id);
			prepstat.executeUpdate();// 执行SQL语句
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// 关闭连接
		}
		return flag;// SQL语句执行成功返回true，失败返回false

	}

}
