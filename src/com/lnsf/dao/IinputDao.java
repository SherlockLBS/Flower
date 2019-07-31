package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Input;

public interface IinputDao {

	// 查找所有记录，返回结果集至List
	public List<Input> all();

	// 增加，返回布尔值
	public boolean insert(Input input);

	// 根据ID“删除”，返回布尔值
	public boolean delete(int inid);

	// 修改，返回布尔值
	public boolean update(Input input);
	
	//按Id查找记录
	public Input selectinputbyid(int inid);
}
