package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.typeDaoImpl;
import com.lnsf.model.Type;

public class typetest {
	public static void main(String[] args) {
		// ����ȫ��
		 List<Type> l = new ArrayList<Type>();
		 typeDaoImpl td=new typeDaoImpl();
		 l=td.all();
		 for(Type t:l)
		 System.out.println(t.toString());

		// ����id����
		// typeDaoImpl td=new typeDaoImpl();
		// System.out.println(td.selecttypebyid(1));

		// �������
		// typeDaoImpl td=new typeDaoImpl();
		// Type t=new Type();
		// t.setType_name("�ʻ�");
		// System.out.println(td.insert(t));

		// �޸Ĳ���
		// typeDaoImpl td=new typeDaoImpl();
		// Type t=new Type();
		// t.setType_name("����");
		// t.setType_id(21);
		// System.out.println(td.update(t));
		//
		// ɾ������
		// typeDaoImpl td=new typeDaoImpl();
		// Type t=new Type();
		// System.out.println(td.delete(21));zs

	}

}
