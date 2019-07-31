package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Flower;

public interface IflowerDao {

	// 查找所有记录，返回结果集至List
	public List<Flower> all();

	// 增加，返回布尔值
	public boolean insert(Flower flower);

	// 根据ID“删除”，返回布尔值
	public boolean delete(int fid);

	// 修改，返回布尔值
	public boolean update(Flower Flower);
	
	//判断id是否存在，若存在可进行删/改，若不存在可进行插入
	public Flower selectflowerbyid(int fid);

}
