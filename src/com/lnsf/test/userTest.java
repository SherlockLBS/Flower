package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.userDaoImpl;
import com.lnsf.model.User;
import com.lnsf.service.impl.userDetailServiceImpl;
import com.lnsf.service.impl.userServiceImpl;

public class userTest {

	public static void main(String[] args) {

		// ����
//		userDaoImpl user = new userDaoImpl();
//		List<User> list = new ArrayList<User>();
//		list = user.all();
//		for (User l : list)
//			System.out.println(l);

		// ����
//		userDaoImpl user = new userDaoImpl();
//		User u = new User();
//		u.setUser_id("2017764999");
//		u.setUser_name("С����");
//		u.setPassword("217764999");
//		boolean flag = user.insert(u);
//		System.out.println(flag);

		// ɾ��
		// userDaoImpl user = new userDaoImpl();
		// boolean flag = user.delete("С�ɰ�");
		// System.out.println(flag);

		// ����
		// userDaoImpl user = new userDaoImpl();
		// User u = new User();
		// u.setUser_id("2017764509");
		// u.setUser_name("��ʫ��");
		// u.setPassword("2017764509");
		// u.setRole(1);
		// boolean flag = user.update(u);
		// System.out.println(flag);

		// ��������
		// userDaoImpl user = new userDaoImpl();
		// User u = new User();
		// u.setUser_id("2017764509");
		// u.setPassword("2017764599");
		// boolean flag = user.updatePassword(u);
		// System.out.println(flag);

		// ����ID��������
		// userDaoImpl user = new userDaoImpl();
		// User u = new User();
		// u.setUser_name("С�ɰ�");
		// u.setPassword("2017764599");
		// boolean flag = user.updatePasswordByName(u);
		// System.out.println(flag);

		// ����ID�����û�
		// userDaoImpl user = new userDaoImpl();
		// boolean flag = user.selectUserById("2017764509");
		// System.out.println(flag);

		// �����û��������û�
		// userDaoImpl user = new userDaoImpl();
		// boolean flag = user.selectUserByName("��ʫ��");
		// System.out.println(flag);

//----------------------userService����-----------------------------
		//��¼����
//		userServiceImpl ud=new userServiceImpl();
//		ud.login("����", "2017764527");
		
		//ע��
//		userServiceImpl ud=new userServiceImpl();
//		User u=new User();
//		u.setUser_id("2017764546");
//		u.setUser_name("������");
//		u.setPassword("2017764525");
//		ud.insert(u);
		
		// ����id�޸�����
//		userServiceImpl ud=new userServiceImpl();
//		User u=new User();
//		u.setUser_id("2017764550");
//		u.setPassword("2017764526");
//		ud.updatePassword(u);
		
		//�����û����޸�����
//		userServiceImpl ud=new userServiceImpl();
//		User u=new User();
//		u.setUser_name("С��");
//		u.setPassword("2017764525");
//		ud.updatePasswordByName(u);
		
		//�޸��û���
		// userServiceImpl ud=new userServiceImpl();
		// User u=new User();
		// u.setUser_name("nihao");
		// u.setUser_id("2017764546");
		// ud.updateusername(u);
	}

}
