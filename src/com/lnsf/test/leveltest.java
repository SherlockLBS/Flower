package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.levelDaoImpl;
import com.lnsf.model.Level;

public class leveltest {
	public static void main(String[] args) {
		// �鿴����
		 List<Level> l = new ArrayList<Level>();
		 levelDaoImpl ld = new levelDaoImpl();
		 l = ld.all();
		 for (Level Le : l)
		 System.out.println(Le.toString());

		// ���Ӳ���
		// levelDaoImpl ld=new levelDaoImpl();
		// Level l=new Level();
		// l.setLevel_name("��ҫ");
		// l.setLow_point(5000);
		// l.setHigh_point(9999);
		// System.out.println(ld.insert(l));

		// ɾ������
		// levelDaoImpl ld=new levelDaoImpl();
		// System.out.println(ld.delete(5));

		// �޸Ĳ���
		// levelDaoImpl ld=new levelDaoImpl();
		// Level l=new Level();
		// l.setLevel_name("��ҫ");
		// l.setLow_point(5000);
		// l.setHigh_point(9999);
		// l.setLevel_id(5);
		// System.out.println(ld.update(l));

		// ����id���Ҳ���
		// levelDaoImpl ld=new levelDaoImpl();
		// System.out.println(ld.selectlevelbyid(1));
	}

}
