package com.lnsf.service.impl;

import java.util.List;

import com.lnsf.dao.IconsigneeDao;
import com.lnsf.model.Consignee;
import com.lnsf.service.IconsigneeService;

public class consigneeServiceImpl implements IconsigneeService {
	private IconsigneeDao IconsigneeDao; 
	//��Ա��ӵ�ַ
	public void insert(Consignee con){
		if(IconsigneeDao.insert(con)==true)
		System.out.println("�����µ�ַ�ɹ���");
	}
	
	//��Ա�޸ĵ�ַ
	public void update(Consignee con){
		if(IconsigneeDao.update(con)==true)
		System.out.println("�޸ĵ�ַ�ɹ���");
	}
	
	//��Աɾ����ַ
	public void delete(int conid){
		if(IconsigneeDao.delete(conid)==true)
			System.out.println("ɾ���ɹ���");
	}
	
	//��Ա�����û�id�鿴��ַ
	public List<Consignee> selectaddrbyid(String userid){
		return IconsigneeDao.selectaddrbyid(userid);
	}
	
}
