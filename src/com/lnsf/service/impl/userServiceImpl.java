package com.lnsf.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lnsf.dao.IuserDao;
import com.lnsf.dao.IuserDetailDao;
import com.lnsf.dao.impl.userDaoImpl;
import com.lnsf.model.User;
import com.lnsf.service.IuserService;
import com.lnsf.utils.DataAccess;

public class userServiceImpl implements IuserService {

	private IuserDao IuserDao = new userDaoImpl();

	// 登陆
	public void login(String username, String password) {
		if (IuserDao.login(username, password) == -1)
			System.out.println("密码或用户名不正确，登录失败！");
		else
			System.out.println("登录成功！欢迎来到破事多花店！");
	}

	// 注册
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
			System.out.println("Id已存在！");
		} else if (exitName) {
			System.out.println("用户名已存在！");
		}
	}

	// 根据id修改密码
	public void updatePassword(User u) {
		String user_id = u.getUser_id();
		// 判断ID是否存在
		boolean exitId = IuserDao.selectUserById(user_id);
		if (exitId) {
			if (IuserDao.updatePassword(u) == true)
				System.out.println("修改成功！");
			else
				System.out.println("修改失败！");
		} else
			System.out.println("Id不存在，无法修改密码！");

	}

	// 根据用户名修改密码
	public void updatePasswordByName(User u) {
		int flag = 0;// flag=0修改失败
		String user_Name = u.getUser_name();
		boolean exitName = IuserDao.selectUserByName(user_Name);
		if (exitName) {
			if (IuserDao.updatePasswordByName(u) == true)
				System.out.println("修改成功！");
			else
				System.out.println("修改失败！");
		} else
			System.out.println("用户名不存在，不能修改！");
	}

	// 找回密码

	// 修改用户名
	public void updateusername(User u) {
		String user_name = u.getUser_name();
		String user_id = u.getUser_id();
		boolean exituser_name = IuserDao.selectUserByName(user_name);// 判断该用户名是否存在
		if (!exituser_name) {// 用户不存在
			String sql = "update user set user_name = ? where user_id = ?";
			Connection conn = null;
			PreparedStatement prepstat = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				prepstat = conn.prepareStatement(sql);
				prepstat.setString(1, user_name);
				prepstat.setString(2, user_id);
				prepstat.executeUpdate();
				System.out.println("修改成功!");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("修改失败！");
			} finally {
				DataAccess.closeConnection(rs, prepstat, conn);
			}
		} else
			System.out.println("用户名已存在！请重新输入！");
	}

}
