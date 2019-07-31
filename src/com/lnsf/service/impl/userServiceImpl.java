package com.lnsf.service.impl;

import com.lnsf.dao.IuserDao;
import com.lnsf.model.User;
import com.lnsf.service.IuserService;

public class userServiceImpl implements IuserService {

	private IuserDao IuserDao;

	// ��½
	public int login(String username, String password) {
		return IuserDao.login(username, password);
	}

	//ע��
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
			System.out.println("�ñ���Ѵ��ڣ�");
		} else if (exitName) {
			System.out.println("���û����Ѵ��ڣ�");
		}
		
	}

}
