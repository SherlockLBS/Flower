package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Flower;

public interface IflowerDao {

	// �������м�¼�����ؽ������List
	public List<Flower> all();

	// ���ӣ����ز���ֵ
	public boolean insert(Flower flower);

	// ����ID��ɾ���������ز���ֵ
	public boolean delete(int fid);

	// �޸ģ����ز���ֵ
	public boolean update(Flower Flower);
	
	//�ж�id�Ƿ���ڣ������ڿɽ���ɾ/�ģ��������ڿɽ��в���
	public Flower selectflowerbyid(int fid);

}
