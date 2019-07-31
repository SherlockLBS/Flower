package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Level;

public interface IlevelDao {

	// �������м�¼�����ؽ������List
	public List<Level> all();

	// ���ӣ����ز���ֵ
	public boolean insert(Level level);

	// ����ID��ɾ���������ز���ֵ
	public boolean delete(int lid);

	// �޸ģ����ز���ֵ
	public boolean update(Level level);
	
	// ����id����
	public Level selectlevelbyid(int lid);

}
