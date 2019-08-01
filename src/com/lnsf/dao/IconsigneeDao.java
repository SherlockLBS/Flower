package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Consignee;

public interface IconsigneeDao {

	// 查找所有记录，返回结果集至List
	public List<Consignee> all();

	// 增加，返回布尔值
	public boolean insert(Consignee con);

	// 根据ID“删除”，返回布尔值
	public boolean delete(int conid);

	// 修改，返回布尔值
	public boolean update(Consignee con);

	//根据id查找
	public Consignee selectconsigneebyid(int conid);
	
	//根据会员id查找地址
	public List<Consignee> selectaddrbyid(String userid);
}
