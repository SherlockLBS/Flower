package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.UserDetail;

public interface IuserDetailDao {
	//�������м�¼�����ؽ������List
	public List<UserDetail> all();
	
	//���ӣ����ز���ֵ
	public boolean insert(UserDetail ud);
	
	//�����û�ID��ɾ���������ز���ֵ
	public boolean delete(String userid);
		
	//�޸ģ����ز���ֵ
	public boolean update(UserDetail ud);

}
