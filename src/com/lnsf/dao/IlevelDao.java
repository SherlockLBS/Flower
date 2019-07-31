package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Level;

public interface IlevelDao {

	// 查找所有记录，返回结果集至List
	public List<Level> all();

	// 增加，返回布尔值
	public boolean insert(Level level);

	// 根据ID“删除”，返回布尔值
	public boolean delete(int lid);

	// 修改，返回布尔值
	public boolean update(Level level);
	
	// 根据id查找
	public Level selectlevelbyid(int lid);

}
