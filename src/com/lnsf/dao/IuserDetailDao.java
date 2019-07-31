package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.UserDetail;

public interface IuserDetailDao {
	//查找所有记录，返回结果集至List
	public List<UserDetail> all();
	
	//增加，返回布尔值
	public boolean insert(UserDetail ud);
	
	//根据用户ID“删除”，返回布尔值
	public boolean delete(String userid);
		
	//修改，返回布尔值
	public boolean update(UserDetail ud);

}
