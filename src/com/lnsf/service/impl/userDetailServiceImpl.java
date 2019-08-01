package com.lnsf.service.impl;

import java.util.List;

import com.lnsf.dao.IuserDetailDao;
import com.lnsf.model.UserDetail;
import com.lnsf.service.IuserDetailService;

public class userDetailServiceImpl implements IuserDetailService {
	private IuserDetailDao IuserDetailDao;

	// �鿴���м�¼
	public List<UserDetail> all() {
		return IuserDetailDao.all();
	}
	
	//�û�ע��ɹ�����д�û���ϸ��
	public void insert(UserDetail ud){
		if(IuserDetailDao.insert(ud)==true)
			System.out.println("����������д�ɹ���");
		else
			System.out.println("����������дʧ�ܣ�");
	}
	
	//�޸ļ�¼
	public void update(UserDetail ud){
		if(IuserDetailDao.update(ud)==true)
			System.out.println("���������޸ĳɹ���");
		else
			System.out.println("���������޸�ʧ�ܣ�");
	}
	
	//��Ա�鿴��������
	public UserDetail selectUserDetailById(int userDetailId){
		return IuserDetailDao.selectUserDetailById(userDetailId);
				}
}
