package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Type;

public interface ItypeDao {
	// �������м�¼�����ؽ������List
	public List<Type> all();

	// ���ӣ����ز���ֵ
	public boolean insert(Type t);

	// �������ID��ɾ���������ز���ֵ
	public boolean delete(int typeid);

	// �޸ģ����ز���ֵ
	public boolean update(Type t);
	
	//����id����
	public Type selecttypebyid(int typeid);
}
