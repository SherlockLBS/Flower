package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.consigneeDaoImpl;
import com.lnsf.model.Consignee;

public class consigneetest {
	public static void main(String[] args) {
		// ���Ҳ���
		// List<Consignee> l = new ArrayList<Consignee>();
		// consigneeDaoImpl cd = new consigneeDaoImpl();
		// l = cd.all();
		// for (Consignee c : l)
		// System.out.println(c.toString());

		// �������
		// consigneeDaoImpl cd=new consigneeDaoImpl();
		// Consignee c=new Consignee();
		// c.setCon_name("����");
		// c.setCon_tel("13825758369");
		// c.setCon_addr("����");
		// c.setUser_id("2017764525");
		// System.out.println(cd.insert(c));

		// ɾ������
		// consigneeDaoImpl cd=new consigneeDaoImpl();
		// System.out.println(cd.delete(11));

		// �޸Ĳ���
		// consigneeDaoImpl cd=new consigneeDaoImpl();
		// Consignee c=new Consignee();
		// c.setCon_name("����");
		// c.setCon_tel("12345678923");
		// c.setUser_id("2017764525");
		// c.setCon_addr("����");
		// c.setCon_id(11);
		// System.out.println(cd.update(c));

		// ����id����
		// consigneeDaoImpl cd = new consigneeDaoImpl();
		// System.out.println(cd.selectconsigneebyid(1));

		// ����id���ҵ�ַ
		List<Consignee> l = new ArrayList<Consignee>();
		consigneeDaoImpl cd = new consigneeDaoImpl();
		l = cd.selectaddrbyid("2017764509");
		for (Consignee c : l)
			System.out.println(c.getCon_addr());

	}

}
