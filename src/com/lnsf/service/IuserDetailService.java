package com.lnsf.service;

import java.util.List;

import com.lnsf.model.UserDetail;

public interface IuserDetailService {

	// 查看所有记录
	public List<UserDetail> all();

	// 用户注册成功后，填写用户明细表
	public void insert(UserDetail ud);

	// 修改记录
	public void update(UserDetail ud);

	// 会员查看个人资料
	public UserDetail selectUserDetailById(int userDetailId);
}
