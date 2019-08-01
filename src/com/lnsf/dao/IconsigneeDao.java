package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Consignee;

public interface IconsigneeDao {

	// �������м�¼�����ؽ������List
	public List<Consignee> all();

	// ���ӣ����ز���ֵ
	public boolean insert(Consignee con);

	// ����ID��ɾ���������ز���ֵ
	public boolean delete(int conid);

	// �޸ģ����ز���ֵ
	public boolean update(Consignee con);

	//����id����
	public Consignee selectconsigneebyid(int conid);
	
	//���ݻ�Աid���ҵ�ַ
	public List<Consignee> selectaddrbyid(String userid);
}
