package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IuserDetailDao;
import com.lnsf.model.UserDetail;
import com.lnsf.utils.DataAccess;

public class userDetailDaoImpl implements IuserDetailDao {
	
	//根据ID查找该条记录是否存在
	public boolean selectUserDetailById(int userDetailId){
		String sql = "select * from userDetail where userDetail_id = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setInt(1, userDetailId);
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
	public List<UserDetail> all() {
		String sql = "select * from userDetail";
		List<UserDetail> l = new ArrayList<UserDetail>();// 新建对象数组，存放得到的结果集
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			prepstat = conn.prepareStatement(sql);// SQL语句
			rs = prepstat.executeQuery();// 执行SQL语句，得到结果集
			while (rs.next()) {
				// 新建对象，并通过构造方法，将结果集中的每一条记录封装成一个对象
				UserDetail ud = new UserDetail(rs.getInt("userDetail_id"),
						rs.getString("user_id"),rs.getString("user_tel"),
						rs.getString("user_sex"), rs.getInt("user_point"),
						rs.getString("register_time"), rs.getInt("login_count"),
						rs.getString("login_time"),rs.getInt("flag"));
				// 将得到的对象添加到对象数组
				l.add(ud);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// 关闭连接
		}
		return l;// 返回最终得到的对象数组

	}

	// 增加，返回布尔值
	public boolean insert(UserDetail ud) {
		String sql = "insert into userDetail(user_id, user_tel, user_sex, register_time, "
				+ "user_point, login_count, login_time) "
				+ "values (?,?,?,?,?,?,?)";
		// 得到对象中的内容
		String user_id  = ud.getUser_id();
		String user_tel = ud.getUser_tel();
		String user_sex = ud.getUser_sex();
		String register_time = ud.getRegister_time();
		int user_ponit = ud.getUser_point();
		int login_count = ud.getLogin_count();
		String login_time = ud.getLogin_time();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			prepstat = conn.prepareStatement(sql);// SQL语句
			prepstat.setString(1, user_id);
			prepstat.setString(2, user_tel);
			prepstat.setString(3, user_sex);
			prepstat.setString(4, register_time);
			prepstat.setInt(5, user_ponit);
			prepstat.setInt(6, login_count);
			prepstat.setString(7, login_time);
			prepstat.executeUpdate();// 执行SQL语句
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// 关闭连接
		}
		return flag;// SQL语句执行成功返回true，失败返回false

	}

	// 根据用户ID“删除”，返回布尔值
	public boolean delete(String userId) {
		String sql = "update userDetail set flag = 0 where user_id = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			// 根据user_id确定记录
			prepstat = conn.prepareStatement(sql);// SQL语句
			prepstat.setString(1, userId);
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
	public boolean update(UserDetail ud) {
		String sql = "update userDetail set user_id = ?, user_tel = ?,user_sex = ?,register_time = ?, "
				+ "user_point = ?, login_count = ?, login_time = ?  where userDetail_id = ?";
		// 得到对象中的内容
		int userDetail_id = ud.getUserDetail_id();
		String user_id  = ud.getUser_id();
		String user_tel = ud.getUser_tel();
		String user_sex = ud.getUser_sex();
		String register_time = ud.getRegister_time();
		int user_ponit = ud.getUser_point();
		int login_count = ud.getLogin_count();
		String login_time = ud.getLogin_time();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			// 根据user_id确定记录
			prepstat = conn.prepareStatement(sql);// SQL语句
			prepstat.setString(1, user_id);
			prepstat.setString(2, user_tel);
			prepstat.setString(3, user_sex);
			prepstat.setString(4, register_time);
			prepstat.setInt(5, user_ponit);
			prepstat.setInt(6, login_count);
			prepstat.setString(7, login_time);
			prepstat.setInt(8, userDetail_id);
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
