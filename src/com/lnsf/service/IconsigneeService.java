package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Consignee;

public interface IconsigneeService {

	//��Ա��ӵ�ַ
	public void insert(Consignee con);
	
	//��Ա�޸ĵ�ַ
	public void update(Consignee con);
	
	//��Աɾ����ַ
	public void delete(int conid);
	
	//��Ա�����û�id�鿴��ַ
	public List<Consignee> selectaddrbyid(String userid);
}
