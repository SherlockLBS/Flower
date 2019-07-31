package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.User;

public interface IuserDao {
	// ͨ���û��������룬����ĳһuser�������ڣ��򷵻�role�����򷵻�-1
	public int login(String username, String password);

	// ���������жϸ��û��Ƿ����
	public boolean selectUserById(String userId);

	// ͨ���û����ж��Ƿ����
	public boolean selectUserByName(String userName);

	// ��������user�����ؽ������List
	public List<User> all();

	// ���ӣ����ز���ֵ
	public boolean insert(User u);

	// �����û�����ɾ���������ز���ֵ
	public boolean delete(String username);

	// �޸ģ����ز���ֵ
	public boolean update(User u);
	
	// ��������
	public boolean updatePassword(User u);

	//�����û���������
	public boolean updatePasswordByName(User u);

}
