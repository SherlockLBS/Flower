package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.levelDaoImpl;
import com.lnsf.model.Level;

public class leveltest {
	public static void main(String[] args) {
		// ²é¿´²âÊÔ
		 List<Level> l = new ArrayList<Level>();
		 levelDaoImpl ld = new levelDaoImpl();
		 l = ld.all();
		 for (Level Le : l)
		 System.out.println(Le.toString());

		// Ôö¼Ó²âÊÔ
		// levelDaoImpl ld=new levelDaoImpl();
		// Level l=new Level();
		// l.setLevel_name("ÐÇÒ«");
		// l.setLow_point(5000);
		// l.setHigh_point(9999);
		// System.out.println(ld.insert(l));

		// É¾³ý²âÊÔ
		// levelDaoImpl ld=new levelDaoImpl();
		// System.out.println(ld.delete(5));

		// ÐÞ¸Ä²âÊÔ
		// levelDaoImpl ld=new levelDaoImpl();
		// Level l=new Level();
		// l.setLevel_name("ÐÇÒ«");
		// l.setLow_point(5000);
		// l.setHigh_point(9999);
		// l.setLevel_id(5);
		// System.out.println(ld.update(l));

		// ¸ù¾Ýid²éÕÒ²âÊÔ
		// levelDaoImpl ld=new levelDaoImpl();
		// System.out.println(ld.selectlevelbyid(1));
	}

}
