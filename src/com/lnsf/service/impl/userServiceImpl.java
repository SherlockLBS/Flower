package com.lnsf.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lnsf.dao.IuserDao;
import com.lnsf.dao.IuserDetailDao;
import com.lnsf.model.User;
import com.lnsf.service.IuserService;
import com.lnsf.utils.DataAccess;

public class userServiceImpl implements IuserService {

	private IuserDao IuserDao;

	// ��½
	public int login(String username, String password) {
		return IuserDao.login(username, password);
	}

	// ע��
	public int insert(User user) {
		String user_id = user.getUser_id();
		String user_Name = user.getUser_name();
		int flag = 0;
		// �ж�ID�Ƿ����
		boolean exitId = IuserDao.selectUserById(user_id);
		// �ж�Name�Ƿ����
		boolean exitName = IuserDao.selectUserByName(user_Name);
		// �Բ�����
		if (!exitId && !exitName) {
			IuserDao.insert(user);
			flag = 1; // ע��ɹ�
		} else if (exitId) {
			flag = 2;// Id�Ѵ���
		} else if (exitName) {
			flag = 3;// �û����Ѵ���
		}
		return flag;
	}

	// ����id�޸�����
	public int updatePassword(User u) {
		int flag = 0;// flag=0�޸�ʧ��
		if (IuserDao.updatePassword(u) == true)
			flag = 1;// �޸ĳɹ�
		return flag;
	}

	// �����û����޸�����
	public int updatePasswordByName(User u) {
		int flag = 0;// flag=0�޸�ʧ��
		if (IuserDao.updatePasswordByName(u) == true)
			flag = 1;// �޸ĳɹ�
		return flag;
	}

	// �һ�����

	// �޸��û���
	public int updateusername(User u) {
		int flag = 0;
		String user_name = u.getUser_name();
		String user_id = u.getUser_id();
		boolean exituser_name = IuserDao.selectUserByName(user_name);// �жϸ��û����Ƿ����
		if (!exituser_name) {// �û�������
			String sql = "update user set user_name = ? where user_id = ?";
			Connection conn = null;
			PreparedStatement prepstat = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				prepstat = conn.prepareStatement(sql);
				prepstat.setString(1, user_name);
				prepstat.setString(2, user_id);
				prepstat.executeUpdate();
				flag = 1;// �޸ĳɹ�
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataAccess.closeConnection(rs, prepstat, conn);
			}
		}
		return flag;
	}
	
}
