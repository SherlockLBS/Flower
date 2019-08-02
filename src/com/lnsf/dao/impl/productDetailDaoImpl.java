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

	// 查询一条记录是否存在
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

	// 查找所有记录，返回结果集至List
	public List<ProductDetail> all() {
		String sql = "select * from productDetail";
		List<ProductDetail> l = new ArrayList<ProductDetail>();// 新建对象数组，存放得到的结果集
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			prepstat = conn.prepareStatement(sql);// SQL语句
			rs = prepstat.executeQuery();// 执行SQL语句，得到结果集
			while (rs.next()) {
				// 新建对象，并通过构造方法，将结果集中的每一条记录封装成一个对象
				ProductDetail pd = new ProductDetail(
						rs.getInt("productDetail_id"), rs.getInt("product_id"),
						rs.getInt("flower_id"), rs.getInt("flower_num"),
						rs.getInt("flag"));
				// 将得到的对象添加到对象数组
				l.add(pd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// 关闭连接
		}
		return l;// 返回最终得到的对象数组

	}

	// 增加，返回布尔值
	public boolean insert(ProductDetail pd) {
		String sql = "insert into ProductDetail(product_id, flower_id, flower_num ) "
				+ "values (?,?,?)";
		// 得到对象中的内容
		int product_id = pd.getProduct_id();
		int flower_id = pd.getFlower_id();
		int flower_num = pd.getFlower_num();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			conn.setAutoCommit(false);// 设置非自动提交
			prepstat = conn.prepareStatement(sql);// SQL语句
			prepstat.setInt(1, product_id);
			prepstat.setInt(2, flower_id);
			prepstat.setInt(3, flower_num);
			prepstat.executeUpdate();// 执行SQL语句
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
			DataAccess.closeConnection(rs, prepstat, conn);// 关闭连接
		}
		return flag;// SQL语句执行成功返回true，失败返回false

	}

	// 根据商品明细ID“删除”，返回布尔值
	public boolean delete(int productDetailId) {
		String sql = "update productDetail set flag = 0 where productDetail_id = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			// 根据product_id确定记录
			prepstat = conn.prepareStatement(sql);// SQL语句
			prepstat.setInt(1, productDetailId);
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
	public boolean update(ProductDetail pd) {
		String sql = "update productDetail set product_id = ?, flower_id = ?, flower_num = ? "
				+ "where productDetail_id = ?";
		// 得到对象中的内容
		int productDetail_id = pd.getProductDetail_id();
		int product_id = pd.getProduct_id();
		int flower_id = pd.getFlower_id();
		int flower_num = pd.getFlower_num();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			prepstat = conn.prepareStatement(sql);// SQL语句
			// 根据productDetail_id确定记录
			prepstat.setInt(1, product_id);
			prepstat.setInt(2, flower_id);
			prepstat.setInt(3, flower_num);
			prepstat.setInt(4, productDetail_id);
			prepstat.executeUpdate();// 执行SQL语句
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// 关闭连接
		}
		return flag;// SQL语句执行成功返回true，失败返回false
	}

	// 根据商品id删除，返回布尔值
	public boolean deletebyproductid(int productId) {
		String sql = "update productDetail set flag = 0 where product_id = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			// 根据product_id确定记录
			prepstat = conn.prepareStatement(sql);// SQL语句
			prepstat.setInt(1, productId);
			prepstat.executeUpdate();// 执行SQL语句
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// 关闭连接
		}
		return flag;
	}

}
