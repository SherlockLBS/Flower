package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Input;

public interface IinputDao {

	// �������м�¼�����ؽ������List
	public List<Input> all();

	// ���ӣ����ز���ֵ
	public boolean insert(Input input);

	// ����ID��ɾ���������ز���ֵ
	public boolean delete(int inid);

	// �޸ģ����ز���ֵ
	public boolean update(Input input);
	
	//��Id���Ҽ�¼
	public Input selectinputbyid(int inid);
}
