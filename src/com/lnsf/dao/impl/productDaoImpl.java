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

	// 查找记录是否存在
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

	// 查找所有记录，返回结果集至List
	public List<Product> all() {
		String sql = "select * from product";
		List<Product> l = new ArrayList<Product>();// 新建对象数组，存放得到的结果集
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			prepstat = conn.prepareStatement(sql);// SQL语句
			rs = prepstat.executeQuery();// 执行SQL语句，得到结果集
			while (rs.next()) {
				// 新建对象，并通过构造方法，将结果集中的每一条记录封装成一个对象
				Product p = new Product(rs.getInt("product_id"),
						rs.getString("product_name"),
						rs.getInt("product_price"), rs.getString("remark"),
						rs.getInt("use_id"), rs.getInt("object_id"),
						rs.getInt("festival_id"), rs.getInt("som_id"),
						rs.getInt("flag"));
				// 将得到的对象添加到对象数组
				l.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// 关闭连接
		}
		return l;// 返回最终得到的对象数组

	}

	// 增加，返回布尔值
	public boolean insert(Product p) {
		String sql = "insert into product(product_name, product_price, remark, "
				+ "use_id, object_id, festival_id, som_id ) "
				+ "values (?,?,?,?,?,?,?)";
		// 得到对象中的内容
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
			conn = DataAccess.getConnection();// 连接数据库
			prepstat = conn.prepareStatement(sql);// SQL语句
			prepstat.setString(1, product_name);
			prepstat.setFloat(2, product_price);
			prepstat.setString(3, remark);
			prepstat.setInt(4, use_id);
			prepstat.setInt(5, object_id);
			prepstat.setInt(6, festival_id);
			prepstat.setInt(7, som_id);
			prepstat.executeUpdate();// 执行SQL语句
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// 关闭连接
		}
		return flag;// SQL语句执行成功返回true，失败返回false

	}

	// 根据商品ID“删除”，返回布尔值
	public boolean delete(int productId) {
		String sql = "update product set flag = 0 where product_id = ?";
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
		return flag;// SQL语句执行成功返回true，失败返回false
	}

	// 修改，返回布尔值
	public boolean update(Product p) {
		String sql = "update product set product_name = ?, product_price = ?, remark = ?, "
				+ "use_id = ?, object_id = ?, festival_id = ?, som_id = ? where product_id = ?";
		// 得到对象中的内容
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
			conn = DataAccess.getConnection();// 连接数据库
			prepstat = conn.prepareStatement(sql);// SQL语句
			// 根据product_id确定记录
			prepstat.setString(1, product_name);
			prepstat.setFloat(2, product_price);
			prepstat.setString(3, remark);
			prepstat.setInt(4, use_id);
			prepstat.setInt(5, object_id);
			prepstat.setInt(6, festival_id);
			prepstat.setInt(7, som_id);
			prepstat.setInt(8, product_id);
			prepstat.executeUpdate();// 执行SQL语句
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// 关闭连接
		}
		return flag;// SQL语句执行成功返回true，失败返回false

	}
	
	//根据商品名称查找记录
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
