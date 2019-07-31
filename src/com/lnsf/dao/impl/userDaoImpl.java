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

	// �����û�������������û������û�������������ȷ������role�����򷵻�-1
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

	// �������м�¼�����ؽ������List
	@Override
	public List<User> all() {
		String sql = "select * from user";
		List<User> l = new ArrayList<User>();// �½��������飬��ŵõ��Ľ����
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			prepstat = conn.prepareStatement(sql);// SQL���
			rs = prepstat.executeQuery();// ִ��SQL��䣬�õ������
			while (rs.next()) {
				// �½����󣬲�ͨ�����췽������������е�ÿһ����¼��װ��һ������
				User u = new User(rs.getString("user_id"),
						rs.getString("user_name"), rs.getString("password"),
						rs.getInt("role"), rs.getInt("flag"));
				// ���õ��Ķ�����ӵ���������
				l.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// �ر�����
		}
		return l;// �������յõ��Ķ�������
	}

	@Override
	public boolean insert(User u) {
		String sql = "insert into user(user_id,user_name,password) values (?,?,?)";
		// �õ������е�����
		String user_id = u.getUser_id();
		String user_name = u.getUser_name();
		String password = u.getPassword();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			prepstat = conn.prepareStatement(sql);// SQL���
			prepstat.setString(1, user_id);
			prepstat.setString(2, user_name);
			prepstat.setString(3, password);
			prepstat.executeUpdate();// ִ��SQL���
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// �ر�����
		}
		return flag;// SQL���ִ�гɹ�����true��ʧ�ܷ���false
	}

	//ɾ��
	@Override
	public boolean delete(String username) {
		String sql = "update user set flag = 0 where user_name = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			// ����user_nameȷ����¼
			prepstat = conn.prepareStatement(sql);// SQL���
			prepstat.setString(1, username);
			prepstat.executeUpdate();// ִ��SQL���
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// �ر�����
		}
		return flag;// SQL���ִ�гɹ�����true��ʧ�ܷ���false
	}

	@Override
	public boolean update(User u) {
		String sql = "update user set user_name = ?,password = ?,role = ? where user_id = ?";
		// �õ������е�����
		String user_id = u.getUser_id();
		String user_name = u.getUser_name();
		String password = u.getPassword();
		int role = u.getRole();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			// ����user_idȷ����¼
			prepstat = conn.prepareStatement(sql);// SQL���
			prepstat.setString(1, user_name);
			prepstat.setString(2, password);
			prepstat.setInt(3, role);
			prepstat.setString(4, user_id);
			prepstat.executeUpdate();// ִ��SQL���
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// �ر�����
		}
		return flag;// SQL���ִ�гɹ�����true��ʧ�ܷ���false
	}

	//ͨ��ID�����û��Ƿ����
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
			DataAccess.closeConnection(rs, prepstat, conn);// �ر�����
		}
		return flag;// SQL���ִ�гɹ�����true��ʧ�ܷ���false
	}

	//ͨ���û��������û��Ƿ����
	@Override
	public boolean selectUserByName(String userName) {
		String sql = "select * from user where user_name = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			// ����user_nameȷ����¼
			prepstat = conn.prepareStatement(sql);// SQL���
			prepstat.setString(1, userName);
			rs = prepstat.executeQuery();// ִ��SQL���
			while(rs.next()){
				flag = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// �ر�����
		}
		return flag;
	}

	// ����ID�޸�����
	@Override
	public boolean updatePassword(User u) {
		String sql = "update user set password = ? where user_id = ?";
		// �õ������е�����
		String user_id = u.getUser_id();
		String password = u.getPassword();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			// ����user_idȷ����¼
			prepstat = conn.prepareStatement(sql);// SQL���
			prepstat.setString(1, password);
			prepstat.setString(2, user_id);
			prepstat.executeUpdate();// ִ��SQL���
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// �ر�����
		}
		return flag;// SQL���ִ�гɹ�����true��ʧ�ܷ���false
	}

	// �����û����޸�����
	@Override
	public boolean updatePasswordByName(User u) {
		String sql = "update user set password = ? where user_name = ?";
		// �õ������е�����
		String user_name = u.getUser_name();
		String password = u.getPassword();

		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			// ����user_idȷ����¼
			prepstat = conn.prepareStatement(sql);// SQL���
			prepstat.setString(1, password);
			prepstat.setString(2, user_name);
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
