package com.lnsf.service.impl;

import java.util.List;

import com.lnsf.dao.IuserDetailDao;
import com.lnsf.model.UserDetail;
import com.lnsf.service.IuserDetailService;

public class userDetailServiceImpl implements IuserDetailService {
	private IuserDetailDao IuserDetailDao;

	// 查看所有记录
	public List<UserDetail> all() {
		return IuserDetailDao.all();
	}
	
	//用户注册成功后，填写用户明细表
	public void insert(UserDetail ud){
		if(IuserDetailDao.insert(ud)==true)
			System.out.println("个人资料填写成功！");
		else
			System.out.println("个人资料填写失败！");
	}
	
	//修改记录
	public void update(UserDetail ud){
		if(IuserDetailDao.update(ud)==true)
			System.out.println("个人资料修改成功！");
		else
			System.out.println("个人资料修改失败！");
	}
	
	//会员查看个人资料
	public UserDetail selectUserDetailById(int userDetailId){
		return IuserDetailDao.selectUserDetailById(userDetailId);
				}
}
