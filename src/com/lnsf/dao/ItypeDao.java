package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Type;

public interface ItypeDao {
	// 查找所有记录，返回结果集至List
	public List<Type> all();

	// 增加，返回布尔值
	public boolean insert(Type t);

	// 根据类别ID“删除”，返回布尔值
	public boolean delete(int typeid);

	// 修改，返回布尔值
	public boolean update(Type t);
	
	//根据id查找
	public Type selecttypebyid(int typeid);
}
