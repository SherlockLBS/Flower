package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.userDaoImpl;
import com.lnsf.model.User;

public class userTest {

	public static void main(String[] args) {

		// 查找
//		userDaoImpl user = new userDaoImpl();
//		List<User> list = new ArrayList<User>();
//		list = user.all();
//		for (User l : list)
//			System.out.println(l);

		// 插入
//		userDaoImpl user = new userDaoImpl();
//		User u = new User();
//		u.setUser_id("2017764999");
//		u.setUser_name("小美丽");
//		u.setPassword("217764999");
//		boolean flag = user.insert(u);
//		System.out.println(flag);

		// 删除
		// userDaoImpl user = new userDaoImpl();
		// boolean flag = user.delete("小可爱");
		// System.out.println(flag);

		// 更改
		// userDaoImpl user = new userDaoImpl();
		// User u = new User();
		// u.setUser_id("2017764509");
		// u.setUser_name("梁诗欣");
		// u.setPassword("2017764509");
		// u.setRole(1);
		// boolean flag = user.update(u);
		// System.out.println(flag);

		// 更改密码
		// userDaoImpl user = new userDaoImpl();
		// User u = new User();
		// u.setUser_id("2017764509");
		// u.setPassword("2017764599");
		// boolean flag = user.updatePassword(u);
		// System.out.println(flag);

		// 根据ID更改密码
		// userDaoImpl user = new userDaoImpl();
		// User u = new User();
		// u.setUser_name("小可爱");
		// u.setPassword("2017764599");
		// boolean flag = user.updatePasswordByName(u);
		// System.out.println(flag);

		// 根据ID查找用户
		// userDaoImpl user = new userDaoImpl();
		// boolean flag = user.selectUserById("2017764509");
		// System.out.println(flag);

		// 根据用户名查找用户
		// userDaoImpl user = new userDaoImpl();
		// boolean flag = user.selectUserByName("梁诗欣");
		// System.out.println(flag);

	}

}
