package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IorderDao;
import com.lnsf.model.Orders;
import com.lnsf.utils.DataAccess;

public class orderDaoImpl implements IorderDao {

	// 查找所有记录，返回结果集至List
	public List<Orders> all() {
		List<Orders> l = new ArrayList<Orders>();
		String sql = "select * from orders";
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			rs = prepstat.executeQuery();
			while (rs.next()) {
				Orders o = new Orders(rs.getString("order_id"),
						rs.getString("order_date"),
						rs.getString("deliver_date"),
						rs.getString("finish_date"), rs.getInt("con_id"),
						rs.getFloat("order_price"), rs.getInt("state"),
						rs.getInt("flag"));
				l.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}
		return l;
	}

	// 增加，返回布尔值
	@Override
	public boolean insert(Orders o) {
		String sql = "insert into orders(order_id,order_date,deliver_date,finish_date,con_id,order_price) values(?,?,?,?,?,?)";
		String order_id = o.getOrder_id();
		String order_date = o.getOrder_date();
		String deliver_date = o.getDeliver_date();
		String finish_date = o.getFinish_date();
		int con_id = o.getCon_id();
		float order_price = o.getOrder_price();
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setString(1, order_id);
			prepstat.setString(2, order_date);
			prepstat.setString(3, deliver_date);
			prepstat.setString(4, finish_date);
			prepstat.setInt(5, con_id);
			prepstat.setFloat(6, order_price);
			prepstat.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}
		return flag;
	}

	// //根据订单ID“删除”，返回布尔值
	@Override
	public boolean delete(String orderid) {
		String sql = "update orders set flag=0 where order_id = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setString(1, orderid);
			prepstat.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}
		return flag;
	}

	// 修改，返回布尔值
	@Override
	public boolean update(Orders o) {
		String sql = "update orders set order_date = ?,deliver_date = ?,finish_date = ?,con_id = ?,order_price = ?,state = ? where order_id = ? ";
		String order_date = o.getOrder_date();
		String deliver_date = o.getDeliver_date();
		String finish_date = o.getFinish_date();
		int con_id = o.getCon_id();
		float order_price = o.getOrder_price();
		int state = o.getState();
		String order_id = o.getOrder_id();
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setString(1, order_date);
			prepstat.setString(2, deliver_date);
			prepstat.setString(3, finish_date);
			prepstat.setInt(4, con_id);
			prepstat.setFloat(5, order_price);
			prepstat.setInt(6, state);
			prepstat.setString(7, order_id);
			prepstat.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}
		return flag;
	}

	// 根据id查找
	@Override
	public Orders selectorderbyid(String orderid) {
		String sql = "select * from orders where order_id = ? and flag = 1";
		Orders o = new Orders();
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setString(1, orderid);
			rs = prepstat.executeQuery();
			if (rs.next()) {
				o.setOrder_id(orderid);
				o.setOrder_date(rs.getString("order_date"));
				o.setDeliver_date(rs.getString("deliver_date"));
				o.setFinish_date(rs.getString("finish_date"));
				o.setCon_id(rs.getInt("con_id"));
				o.setOrder_price(rs.getFloat("order_price"));
				o.setState(rs.getInt("state"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}
		return o;
	}

	// 根据下单日期返回订单
	public List<Orders> selectByDate(String startDate, String endDate) {
		List<Orders> l = new ArrayList<Orders>();
		String sql = "select * from orders where order_date between ? and ?";
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setString(1, startDate);
			prepstat.setString(2, endDate);
			rs = prepstat.executeQuery();
			while (rs.next()) {
				Orders o = new Orders(rs.getString("order_id"),
						rs.getString("order_date"),
						rs.getString("deliver_date"),
						rs.getString("finish_date"), rs.getInt("con_id"),
						rs.getFloat("order_price"), rs.getInt("state"),
						rs.getInt("flag"));
				l.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}
		return l;
	}

	// 修改订单状态
	public boolean updateState(Orders o) {
		boolean flag = false;
		String sql = "update orders set state = ? where order_id = ?";
		Connection conn = null;
		PreparedStatement prepstat = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setInt(1, o.getState());
			prepstat.setString(2, o.getOrder_id());
			prepstat.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(prepstat, conn);
		}
		return flag;
	}

	// 根据订单状态返回信息
	public List<Orders> orders(int state) {
		List<Orders> l = new ArrayList<Orders>();
		String sql = "select * from orders where state = ? and flag = 1";
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setInt(1, state);
			rs = prepstat.executeQuery();
			while (rs.next()) {
				Orders o = new Orders(rs.getString("order_id"),
						rs.getString("order_date"),
						rs.getString("deliver_date"),
						rs.getString("finish_date"), rs.getInt("con_id"),
						rs.getFloat("order_price"), rs.getInt("state"),
						rs.getInt("flag"));
				l.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}
		return l;

	}
}
