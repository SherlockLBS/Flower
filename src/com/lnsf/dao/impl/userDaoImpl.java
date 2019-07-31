package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IuserDao;
import com.lnsf.model.User;
import com.lnsf.utils.DataAccess;

public class userDaoImpl implements IuserDao {

	// 根据用户名和密码查找用户，若用户存在且密码正确，返回role，否则返回-1
	@Override
	public int login(String username, String password) {
		String sql = "select * from user where user_name = ? and password = ?";
		int flag = 0;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setString(1, username);
			prepstat.setString(2, password);
			rs = prepstat.executeQuery();
			if (rs.next()) {
				flag = rs.getInt("role");
			} else {
				flag = -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);
		}
		return flag;
	}

	// 查找所有记录，返回结果集至List
	@Override
	public List<User> all() {
		String sql = "select * from user";
		List<User> l = new ArrayList<User>();// 新建对象数组，存放得到的结果集
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			prepstat = conn.prepareStatement(sql);// SQL语句
			rs = prepstat.executeQuery();// 执行SQL语句，得到结果集
			while (rs.next()) {
				// 新建对象，并通过构造方法，将结果集中的每一条记录封装成一个对象
				User u = new User(rs.getString("user_id"),
						rs.getString("user_name"), rs.getString("password"),
						rs.getInt("role"), rs.getInt("flag"));
				// 将得到的对象添加到对象数组
				l.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// 关闭连接
		}
		return l;// 返回最终得到的对象数组
	}

	@Override
	public boolean insert(User u) {
		String sql = "insert into user(user_id,user_name,password) values (?,?,?)";
		// 得到对象中的内容
		String user_id = u.getUser_id();
		String user_name = u.getUser_name();
		String password = u.getPassword();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			prepstat = conn.prepareStatement(sql);// SQL语句
			prepstat.setString(1, user_id);
			prepstat.setString(2, user_name);
			prepstat.setString(3, password);
			prepstat.executeUpdate();// 执行SQL语句
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// 关闭连接
		}
		return flag;// SQL语句执行成功返回true，失败返回false
	}

	//删除
	@Override
	public boolean delete(String username) {
		String sql = "update user set flag = 0 where user_name = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			// 根据user_name确定记录
			prepstat = conn.prepareStatement(sql);// SQL语句
			prepstat.setString(1, username);
			prepstat.executeUpdate();// 执行SQL语句
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// 关闭连接
		}
		return flag;// SQL语句执行成功返回true，失败返回false
	}

	@Override
	public boolean update(User u) {
		String sql = "update user set user_name = ?,password = ?,role = ? where user_id = ?";
		// 得到对象中的内容
		String user_id = u.getUser_id();
		String user_name = u.getUser_name();
		String password = u.getPassword();
		int role = u.getRole();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			// 根据user_id确定记录
			prepstat = conn.prepareStatement(sql);// SQL语句
			prepstat.setString(1, user_name);
			prepstat.setString(2, password);
			prepstat.setInt(3, role);
			prepstat.setString(4, user_id);
			prepstat.executeUpdate();// 执行SQL语句
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// 关闭连接
		}
		return flag;// SQL语句执行成功返回true，失败返回false
	}

	//通过ID查找用户是否存在
	@Override
	public boolean selectUserById(String userId) {
		String sql = "select * from user where user_id = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			prepstat = conn.prepareStatement(sql);
			prepstat.setString(1, userId);
			rs = prepstat.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// 关闭连接
		}
		return flag;// SQL语句执行成功返回true，失败返回false
	}

	//通过用户名查找用户是否存在
	@Override
	public boolean selectUserByName(String userName) {
		String sql = "select * from user where user_name = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			// 根据user_name确定记录
			prepstat = conn.prepareStatement(sql);// SQL语句
			prepstat.setString(1, userName);
			rs = prepstat.executeQuery();// 执行SQL语句
			while(rs.next()){
				flag = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// 关闭连接
		}
		return flag;
	}

	// 根据ID修改密码
	@Override
	public boolean updatePassword(User u) {
		String sql = "update user set password = ? where user_id = ?";
		// 得到对象中的内容
		String user_id = u.getUser_id();
		String password = u.getPassword();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			// 根据user_id确定记录
			prepstat = conn.prepareStatement(sql);// SQL语句
			prepstat.setString(1, password);
			prepstat.setString(2, user_id);
			prepstat.executeUpdate();// 执行SQL语句
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// 关闭连接
		}
		return flag;// SQL语句执行成功返回true，失败返回false
	}

	// 根据用户名修改密码
	@Override
	public boolean updatePasswordByName(User u) {
		String sql = "update user set password = ? where user_name = ?";
		// 得到对象中的内容
		String user_name = u.getUser_name();
		String password = u.getPassword();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// 连接数据库
			// 根据user_id确定记录
			prepstat = conn.prepareStatement(sql);// SQL语句
			prepstat.setString(1, password);
			prepstat.setString(2, user_name);
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
