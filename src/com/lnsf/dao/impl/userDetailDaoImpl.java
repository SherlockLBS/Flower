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
	
	//����ID���Ҹ�����¼�Ƿ����
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

	// �������м�¼�����ؽ������List
	public List<UserDetail> all() {
		String sql = "select * from userDetail";
		List<UserDetail> l = new ArrayList<UserDetail>();// �½��������飬��ŵõ��Ľ����
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			prepstat = conn.prepareStatement(sql);// SQL���
			rs = prepstat.executeQuery();// ִ��SQL��䣬�õ������
			while (rs.next()) {
				// �½����󣬲�ͨ�����췽������������е�ÿһ����¼��װ��һ������
				UserDetail ud = new UserDetail(rs.getInt("userDetail_id"),
						rs.getString("user_id"),rs.getString("user_tel"),
						rs.getString("user_sex"), rs.getInt("user_point"),
						rs.getString("register_time"), rs.getInt("login_count"),
						rs.getString("login_time"),rs.getInt("flag"));
				// ���õ��Ķ�����ӵ���������
				l.add(ud);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// �ر�����
		}
		return l;// �������յõ��Ķ�������

	}

	// ���ӣ����ز���ֵ
	public boolean insert(UserDetail ud) {
		String sql = "insert into userDetail(user_id, user_tel, user_sex, register_time, "
				+ "user_point, login_count, login_time) "
				+ "values (?,?,?,?,?,?,?)";
		// �õ������е�����
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
			conn = DataAccess.getConnection();// �������ݿ�
			prepstat = conn.prepareStatement(sql);// SQL���
			prepstat.setString(1, user_id);
			prepstat.setString(2, user_tel);
			prepstat.setString(3, user_sex);
			prepstat.setString(4, register_time);
			prepstat.setInt(5, user_ponit);
			prepstat.setInt(6, login_count);
			prepstat.setString(7, login_time);
			prepstat.executeUpdate();// ִ��SQL���
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataAccess.closeConnection(rs, prepstat, conn);// �ر�����
		}
		return flag;// SQL���ִ�гɹ�����true��ʧ�ܷ���false

	}

	// �����û�ID��ɾ���������ز���ֵ
	public boolean delete(String userId) {
		String sql = "update userDetail set flag = 0 where user_id = ?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prepstat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();// �������ݿ�
			// ����user_idȷ����¼
			prepstat = conn.prepareStatement(sql);// SQL���
			prepstat.setString(1, userId);
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
	public boolean update(UserDetail ud) {
		String sql = "update userDetail set user_id = ?, user_tel = ?,user_sex = ?,register_time = ?, "
				+ "user_point = ?, login_count = ?, login_time = ?  where userDetail_id = ?";
		// �õ������е�����
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
			conn = DataAccess.getConnection();// �������ݿ�
			// ����user_idȷ����¼
			prepstat = conn.prepareStatement(sql);// SQL���
			prepstat.setString(1, user_id);
			prepstat.setString(2, user_tel);
			prepstat.setString(3, user_sex);
			prepstat.setString(4, register_time);
			prepstat.setInt(5, user_ponit);
			prepstat.setInt(6, login_count);
			prepstat.setString(7, login_time);
			prepstat.setInt(8, userDetail_id);
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
