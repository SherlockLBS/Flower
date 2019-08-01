package com.lnsf.service.impl;

import java.util.List;

import com.lnsf.dao.IconsigneeDao;
import com.lnsf.model.Consignee;
import com.lnsf.service.IconsigneeService;

public class consigneeServiceImpl implements IconsigneeService {
	private IconsigneeDao IconsigneeDao; 
	//会员添加地址
	public void insert(Consignee con){
		if(IconsigneeDao.insert(con)==true)
		System.out.println("插入新地址成功！");
	}
	
	//会员修改地址
	public void update(Consignee con){
		if(IconsigneeDao.update(con)==true)
		System.out.println("修改地址成功！");
	}
	
	//会员删除地址
	public void delete(int conid){
		if(IconsigneeDao.delete(conid)==true)
			System.out.println("删除成功！");
	}
	
	//会员根据用户id查看地址
	public List<Consignee> selectaddrbyid(String userid){
		return IconsigneeDao.selectaddrbyid(userid);
	}
	
}
