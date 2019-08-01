package com.lnsf.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lnsf.dao.IuserDao;
import com.lnsf.dao.IuserDetailDao;
import com.lnsf.model.User;
import com.lnsf.service.IuserService;
import com.lnsf.utils.DataAccess;

public class userServiceImpl implements IuserService {

	private IuserDao IuserDao;

	// 登陆
	public int login(String username, String password) {
		return IuserDao.login(username, password);
	}

	// 注册
	public int insert(User user) {
		String user_id = user.getUser_id();
		String user_Name = user.getUser_name();
		int flag = 0;
		// 判断ID是否存在
		boolean exitId = IuserDao.selectUserById(user_id);
		// 判断Name是否存在
		boolean exitName = IuserDao.selectUserByName(user_Name);
		// 皆不存在
		if (!exitId && !exitName) {
			IuserDao.insert(user);
			flag = 1; // 注册成功
		} else if (exitId) {
			flag = 2;// Id已存在
		} else if (exitName) {
			flag = 3;// 用户名已存在
		}
		return flag;
	}

	// 根据id修改密码
	public int updatePassword(User u) {
		int flag = 0;// flag=0修改失败
		if (IuserDao.updatePassword(u) == true)
			flag = 1;// 修改成功
		return flag;
	}

	// 根据用户名修改密码
	public int updatePasswordByName(User u) {
		int flag = 0;// flag=0修改失败
		if (IuserDao.updatePasswordByName(u) == true)
			flag = 1;// 修改成功
		return flag;
	}

	// 找回密码

	// 修改用户名
	public int updateusername(User u) {
		int flag = 0;
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
				flag = 1;// 修改成功
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataAccess.closeConnection(rs, prepstat, conn);
			}
		}
		return flag;
	}
	
}
