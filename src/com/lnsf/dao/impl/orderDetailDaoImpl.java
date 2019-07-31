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

	// ����һ����¼
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

	// �������м�¼�����ؽ������List
	public List<OrderDetail> all() {
		String sql = "select * from orderDetail";
		List<OrderDetail> l = new ArrayList<OrderDetail>();// �½��������飬��ŵõ��Ľ����
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			prepstat = conn.prepareStatement(sql);// SQL���
			rs = prepstat.executeQuery();// ִ��SQL��䣬�õ������
			while (rs.next()) {
				// �½����󣬲�ͨ�����췽������������е�ÿһ����¼��װ��һ������
				OrderDetail od = new OrderDetail(rs.getInt("orderDetail_id"),
						rs.getString("order_id"), rs.getInt("product_id"), 
						rs.getInt("product_count"), rs.getInt("flag"));
				// ���õ��Ķ�����ӵ���������
				l.add(od);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// �ر�����
		}
		return l;// �������յõ��Ķ�������

	}

	// ���ӣ����ز���ֵ
	public boolean insert(OrderDetail od) {
		String sql = "insert into orderDetail(order_id, product_id, product_count) "
				+ "values (?,?,?)";
		// �õ������е�����
		String order_id = od.getOrder_id();
		int product_id = od.getProduct_id();
		int product_count = od.getProduct_count();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			prepstat = conn.prepareStatement(sql);// SQL���
			prepstat.setString(1, order_id);
			prepstat.setInt(2, product_id);
			prepstat.setInt(3, product_count);
			prepstat.executeUpdate();// ִ��SQL���
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// �ر�����
		}
		return flag;// SQL���ִ�гɹ�����true��ʧ�ܷ���false

	}

	// ���ݶ�����ϸID��ɾ���������ز���ֵ
	public boolean delete(int orderDetailId) {
		String sql = "update orderDetail set flag = 0 where orderDetail_id = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			// ����product_idȷ����¼
			prepstat = conn.prepareStatement(sql);// SQL���
			prepstat.setInt(1, orderDetailId);
			prepstat.executeUpdate();// ִ��SQL���
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// �ر�����
		}
		return flag;// SQL���ִ�гɹ�����true��ʧ�ܷ���false

	}

	// �޸ģ����ز���ֵ
	public boolean update(OrderDetail od) {
		String sql = "update orderDetail set order_id = ?, product_id = ?, product_count = ?  where orderDetail_id = ?";
		// �õ������е�����
		int orderDetail_id = od.getOrderDetail_id();
		String order_id = od.getOrder_id();
		int product_id = od.getProduct_id();
		int product_count = od.getProduct_count();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			prepstat = conn.prepareStatement(sql);// SQL���
			// ����product_idȷ����¼
			prepstat.setString(1, order_id);
			prepstat.setInt(2, product_id);
			prepstat.setInt(3, product_count);
			prepstat.setInt(4, orderDetail_id);
			prepstat.executeUpdate();// ִ��SQL���
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// �ر�����
		}
		return flag;// SQL���ִ�гɹ�����true��ʧ�ܷ���false

	}

}
