package com.lnsf.service.impl;

import com.lnsf.dao.IuserDao;
import com.lnsf.model.User;
import com.lnsf.service.IuserService;

public class userServiceImpl implements IuserService {

	private IuserDao IuserDao;

	// 登陆
	public int login(String username, String password) {
		return IuserDao.login(username, password);
	}

	//注册
	public void insert(User user) {
		String user_id = user.getUser_id();
		String user_Name = user.getUser_name();
		// 判断ID是否存在
		boolean exitId = IuserDao.selectUserById(user_id);
		// 判断Name是否存在
		boolean exitName = IuserDao.selectUserByName(user_Name);
		// 皆不存在
		if (!exitId && !exitName) {
			IuserDao.insert(user);
			System.out.println("注册成功！");
		} else if (exitId) {
			System.out.println("该编号已存在！");
		} else if (exitName) {
			System.out.println("该用户名已存在！");
		}
		
	}

}
