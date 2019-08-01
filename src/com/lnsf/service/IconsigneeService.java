package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Consignee;

public interface IconsigneeService {

	//会员添加地址
	public void insert(Consignee con);
	
	//会员修改地址
	public void update(Consignee con);
	
	//会员删除地址
	public void delete(int conid);
	
	//会员根据用户id查看地址
	public List<Consignee> selectaddrbyid(String userid);
}
