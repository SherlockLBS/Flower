package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IproductDetailDao;
import com.lnsf.model.ProductDetail;
import com.lnsf.utils.DataAccess;

public class productDetailDaoImpl implements IproductDetailDao {

	// ��ѯһ����¼�Ƿ����
	public boolean selectProductDetailById(int productDetailId) {
		String sql = "select * from productDetail where productDetail_id = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setInt(1, productDetailId);
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
	public List<ProductDetail> all() {
		String sql = "select * from productDetail";
		List<ProductDetail> l = new ArrayList<ProductDetail>();// �½��������飬��ŵõ��Ľ����
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			prepstat = conn.prepareStatement(sql);// SQL���
			rs = prepstat.executeQuery();// ִ��SQL��䣬�õ������
			while (rs.next()) {
				// �½����󣬲�ͨ�����췽������������е�ÿһ����¼��װ��һ������
				ProductDetail pd = new ProductDetail(
						rs.getInt("productDetail_id"), rs.getInt("product_id"),
						rs.getInt("flower_id"), rs.getInt("flower_num"),
						rs.getInt("flag"));
				// ���õ��Ķ�����ӵ���������
				l.add(pd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// �ر�����
		}
		return l;// �������յõ��Ķ�������

	}

	// ���ӣ����ز���ֵ
	public boolean insert(ProductDetail pd) {
		String sql = "insert into ProductDetail(product_id, flower_id, flower_num ) "
				+ "values (?,?,?)";
		// �õ������е�����
		int product_id = pd.getProduct_id();
		int flower_id = pd.getFlower_id();
		int flower_num = pd.getFlower_num();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			conn.setAutoCommit(false);// ���÷��Զ��ύ
			prepstat = conn.prepareStatement(sql);// SQL���
			prepstat.setInt(1, product_id);
			prepstat.setInt(2, flower_id);
			prepstat.setInt(3, flower_num);
			prepstat.executeUpdate();// ִ��SQL���
			conn.commit();
			flag = true;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// �ر�����
		}
		return flag;// SQL���ִ�гɹ�����true��ʧ�ܷ���false

	}

	// ������Ʒ��ϸID��ɾ���������ز���ֵ
	public boolean delete(int productDetailId) {
		String sql = "update productDetail set flag = 0 where productDetail_id = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			// ����product_idȷ����¼
			prepstat = conn.prepareStatement(sql);// SQL���
			prepstat.setInt(1, productDetailId);
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
	public boolean update(ProductDetail pd) {
		String sql = "update productDetail set product_id = ?, flower_id = ?, flower_num = ? "
				+ "where productDetail_id = ?";
		// �õ������е�����
		int productDetail_id = pd.getProductDetail_id();
		int product_id = pd.getProduct_id();
		int flower_id = pd.getFlower_id();
		int flower_num = pd.getFlower_num();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			prepstat = conn.prepareStatement(sql);// SQL���
			// ����productDetail_idȷ����¼
			prepstat.setInt(1, product_id);
			prepstat.setInt(2, flower_id);
			prepstat.setInt(3, flower_num);
			prepstat.setInt(4, productDetail_id);
			prepstat.executeUpdate();// ִ��SQL���
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// �ر�����
		}
		return flag;// SQL���ִ�гɹ�����true��ʧ�ܷ���false
	}

	// ������Ʒidɾ�������ز���ֵ
	public boolean deletebyproductid(int productId) {
		String sql = "update productDetail set flag = 0 where product_id = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			// ����product_idȷ����¼
			prepstat = conn.prepareStatement(sql);// SQL���
			prepstat.setInt(1, productId);
			prepstat.executeUpdate();// ִ��SQL���
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// �ر�����
		}
		return flag;
	}

}
