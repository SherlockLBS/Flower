package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.typeDaoImpl;
import com.lnsf.model.Type;

public class typetest {
	public static void main(String[] args) {
		// 查找全部
		 List<Type> l = new ArrayList<Type>();
		 typeDaoImpl td=new typeDaoImpl();
		 l=td.all();
		 for(Type t:l)
		 System.out.println(t.toString());

		// 根据id查找
		// typeDaoImpl td=new typeDaoImpl();
		// System.out.println(td.selecttypebyid(1));

		// 插入测试
		// typeDaoImpl td=new typeDaoImpl();
		// Type t=new Type();
		// t.setType_name("鲜花");
		// System.out.println(td.insert(t));

		// 修改测试
		// typeDaoImpl td=new typeDaoImpl();
		// Type t=new Type();
		// t.setType_name("花花");
		// t.setType_id(21);
		// System.out.println(td.update(t));
		//
		// 删除测试
		// typeDaoImpl td=new typeDaoImpl();
		// Type t=new Type();
		// System.out.println(td.delete(21));zs

	}

}
