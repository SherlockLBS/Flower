package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IproductDao;
import com.lnsf.model.Product;
import com.lnsf.utils.DataAccess;

public class productDaoImpl implements IproductDao {

	// ���Ҽ�¼�Ƿ����
	public boolean selectProductById(int productId) {
		String sql = "select * from product where product_id = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setInt(1, productId);
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
	public List<Product> all() {
		String sql = "select * from product";
		List<Product> l = new ArrayList<Product>();// �½��������飬��ŵõ��Ľ����
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			prepstat = conn.prepareStatement(sql);// SQL���
			rs = prepstat.executeQuery();// ִ��SQL��䣬�õ������
			while (rs.next()) {
				// �½����󣬲�ͨ�����췽������������е�ÿһ����¼��װ��һ������
				Product p = new Product(rs.getInt("product_id"),
						rs.getString("product_name"),
						rs.getInt("product_price"), rs.getString("remark"),
						rs.getInt("use_id"), rs.getInt("object_id"),
						rs.getInt("festival_id"), rs.getInt("som_id"),
						rs.getInt("flag"));
				// ���õ��Ķ�����ӵ���������
				l.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// �ر�����
		}
		return l;// �������յõ��Ķ�������

	}

	// ���ӣ����ز���ֵ
	public boolean insert(Product p) {
		String sql = "insert into product(product_name, product_price, remark, "
				+ "use_id, object_id, festival_id, som_id ) "
				+ "values (?,?,?,?,?,?,?)";
		// �õ������е�����
		String product_name = p.getProduct_name();
		float product_price = p.getProduct_price();
		String remark = p.getRemark();
		int use_id = p.getUse_id();
		int object_id = p.getObject_id();
		int festival_id = p.getFestival_id();
		int som_id = p.getSom_id();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			prepstat = conn.prepareStatement(sql);// SQL���
			prepstat.setString(1, product_name);
			prepstat.setFloat(2, product_price);
			prepstat.setString(3, remark);
			prepstat.setInt(4, use_id);
			prepstat.setInt(5, object_id);
			prepstat.setInt(6, festival_id);
			prepstat.setInt(7, som_id);
			prepstat.executeUpdate();// ִ��SQL���
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// �ر�����
		}
		return flag;// SQL���ִ�гɹ�����true��ʧ�ܷ���false

	}

	// ������ƷID��ɾ���������ز���ֵ
	public boolean delete(int productId) {
		String sql = "update product set flag = 0 where product_id = ?";
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
		return flag;// SQL���ִ�гɹ�����true��ʧ�ܷ���false
	}

	// �޸ģ����ز���ֵ
	public boolean update(Product p) {
		String sql = "update product set product_name = ?, product_price = ?, remark = ?, "
				+ "use_id = ?, object_id = ?, festival_id = ?, som_id = ? where product_id = ?";
		// �õ������е�����
		int product_id = p.getProduct_id();
		String product_name = p.getProduct_name();
		float product_price = p.getProduct_price();
		String remark = p.getRemark();
		int use_id = p.getUse_id();
		int object_id = p.getObject_id();
		int festival_id = p.getFestival_id();
		int som_id = p.getSom_id();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			prepstat = conn.prepareStatement(sql);// SQL���
			// ����product_idȷ����¼
			prepstat.setString(1, product_name);
			prepstat.setFloat(2, product_price);
			prepstat.setString(3, remark);
			prepstat.setInt(4, use_id);
			prepstat.setInt(5, object_id);
			prepstat.setInt(6, festival_id);
			prepstat.setInt(7, som_id);
			prepstat.setInt(8, product_id);
			prepstat.executeUpdate();// ִ��SQL���
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// �ر�����
		}
		return flag;// SQL���ִ�гɹ�����true��ʧ�ܷ���false

	}
	
	//������Ʒ���Ʋ��Ҽ�¼
		public Product selectProductByName(String productname ){
			String sql="select * from product where product_name = ?";
			Product p=new Product();
			Connection conn = null;
			PreparedStatement prepstat = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				prepstat = conn.prepareStatement(sql);
				prepstat.setString(1, productname);
				rs=prepstat.executeQuery();
				while(rs.next()){
					p.setProduct_id(rs.getInt("product_id"));
					p.setProduct_name(rs.getString("product_name"));
					p.setProduct_price(rs.getFloat("product_price"));
					p.setRemark(rs.getString("remark"));
					p.setUse_id(rs.getInt("use_id"));
					p.setObject_id(rs.getInt("object_id"));
					p.setFestival_id(rs.getInt("festival_id"));
					p.setSom_id(rs.getInt("som_id"));
					p.setFlag(rs.getInt("flag"));
					}
				}catch(SQLException e){
					e.printStackTrace();
				}finally{
					DataAccess.closeConnection(rs, prepstat, conn);
				}
			return p;
			
		}

}
