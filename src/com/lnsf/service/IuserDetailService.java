package com.lnsf.service;

import java.util.List;

import com.lnsf.model.UserDetail;

public interface IuserDetailService {

	// �鿴���м�¼
	public List<UserDetail> all();

	// �û�ע��ɹ�����д�û���ϸ��
	public void insert(UserDetail ud);

	// �޸ļ�¼
	public void update(UserDetail ud);

	// ��Ա�鿴��������
	public UserDetail selectUserDetailById(int userDetailId);
}
