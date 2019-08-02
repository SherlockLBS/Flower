package com.lnsf.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lnsf.dao.IuserDao;
import com.lnsf.dao.IuserDetailDao;
import com.lnsf.dao.impl.userDaoImpl;
import com.lnsf.model.User;
import com.lnsf.service.IuserService;
import com.lnsf.utils.DataAccess;

public class userServiceImpl implements IuserService {

	private IuserDao IuserDao = new userDaoImpl();

	// ��½
	public void login(String username, String password) {
		if (IuserDao.login(username, password) == -1)
			System.out.println("������û�������ȷ����¼ʧ�ܣ�");
		else
			System.out.println("��¼�ɹ�����ӭ�������¶໨�꣡");
	}

	// ע��
	public void insert(User user) {
		String user_id = user.getUser_id();
		String user_Name = user.getUser_name();
		// �ж�ID�Ƿ����
		boolean exitId = IuserDao.selectUserById(user_id);
		// �ж�Name�Ƿ����
		boolean exitName = IuserDao.selectUserByName(user_Name);
		// �Բ�����
		if (!exitId && !exitName) {
			IuserDao.insert(user);
			System.out.println("ע��ɹ���");
		} else if (exitId) {
			System.out.println("Id�Ѵ��ڣ�");
		} else if (exitName) {
			System.out.println("�û����Ѵ��ڣ�");
		}
	}

	// ����id�޸�����
	public void updatePassword(User u) {
		String user_id = u.getUser_id();
		// �ж�ID�Ƿ����
		boolean exitId = IuserDao.selectUserById(user_id);
		if (exitId) {
			if (IuserDao.updatePassword(u) == true)
				System.out.println("�޸ĳɹ���");
			else
				System.out.println("�޸�ʧ�ܣ�");
		} else
			System.out.println("Id�����ڣ��޷��޸����룡");

	}

	// �����û����޸�����
	public void updatePasswordByName(User u) {
		int flag = 0;// flag=0�޸�ʧ��
		String user_Name = u.getUser_name();
		boolean exitName = IuserDao.selectUserByName(user_Name);
		if (exitName) {
			if (IuserDao.updatePasswordByName(u) == true)
				System.out.println("�޸ĳɹ���");
			else
				System.out.println("�޸�ʧ�ܣ�");
		} else
			System.out.println("�û��������ڣ������޸ģ�");
	}

	// �һ�����

	// �޸��û���
	public void updateusername(User u) {
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
				System.out.println("�޸ĳɹ�!");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("�޸�ʧ�ܣ�");
			} finally {
				DataAccess.closeConnection(rs, prepstat, conn);
			}
		} else
			System.out.println("�û����Ѵ��ڣ����������룡");
	}

}
