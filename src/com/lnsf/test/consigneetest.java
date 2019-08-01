package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.consigneeDaoImpl;
import com.lnsf.model.Consignee;

public class consigneetest {
	public static void main(String[] args) {
		// 查找测试
		// List<Consignee> l = new ArrayList<Consignee>();
		// consigneeDaoImpl cd = new consigneeDaoImpl();
		// l = cd.all();
		// for (Consignee c : l)
		// System.out.println(c.toString());

		// 插入测试
		// consigneeDaoImpl cd=new consigneeDaoImpl();
		// Consignee c=new Consignee();
		// c.setCon_name("亮亮");
		// c.setCon_tel("13825758369");
		// c.setCon_addr("广州");
		// c.setUser_id("2017764525");
		// System.out.println(cd.insert(c));

		// 删除测试
		// consigneeDaoImpl cd=new consigneeDaoImpl();
		// System.out.println(cd.delete(11));

		// 修改测试
		// consigneeDaoImpl cd=new consigneeDaoImpl();
		// Consignee c=new Consignee();
		// c.setCon_name("亮亮");
		// c.setCon_tel("12345678923");
		// c.setUser_id("2017764525");
		// c.setCon_addr("广州");
		// c.setCon_id(11);
		// System.out.println(cd.update(c));

		// 根据id查找
		// consigneeDaoImpl cd = new consigneeDaoImpl();
		// System.out.println(cd.selectconsigneebyid(1));

		// 根据id查找地址
		List<Consignee> l = new ArrayList<Consignee>();
		consigneeDaoImpl cd = new consigneeDaoImpl();
		l = cd.selectaddrbyid("2017764509");
		for (Consignee c : l)
			System.out.println(c.getCon_addr());

	}

}
