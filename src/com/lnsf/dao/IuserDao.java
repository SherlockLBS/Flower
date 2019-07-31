package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.User;

public interface IuserDao {
	// 通过用户名和密码，查找某一user，若存在，则返回role，否则返回-1
	public int login(String username, String password);

	// 根据主键判断该用户是否存在
	public boolean selectUserById(String userId);

	// 通过用户名判断是否存在
	public boolean selectUserByName(String userName);

	// 查找所有user，返回结果集至List
	public List<User> all();

	// 增加，返回布尔值
	public boolean insert(User u);

	// 根据用户名“删除”，返回布尔值
	public boolean delete(String username);

	// 修改，返回布尔值
	public boolean update(User u);
	
	// 更新密码
	public boolean updatePassword(User u);

	//根据用户名改密码
	public boolean updatePasswordByName(User u);

}
