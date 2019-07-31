package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.productDaoImpl;
import com.lnsf.model.Product;

public class productTest {
	
	public static void main(String[] args) {
		
		//查找全部
		productDaoImpl product = new productDaoImpl();
		List<Product> list = new ArrayList<Product>();
		list = product.all();
		for(Product l:list)
			System.out.println(l);
		
		//添加
//		productDaoImpl p = new productDaoImpl();
//		Product product = new Product(); 
//		product.setProduct_name("快乐仙女");
//		product.setProduct_price(599);
//		product.setRemark("99支粉玫瑰");
//		product.setUse_id(1);
//		product.setObject_id(1);
//		product.setFestival_id(1);
//		product.setSom_id(1);
//		boolean flag = p.insert(product);
//		System.out.println(flag);
		
		//更新
//		productDaoImpl p = new productDaoImpl();
//		Product product = new Product(); 
//		product.setProduct_id(67);
//		product.setProduct_name("快乐仙女");
//		product.setProduct_price(599);
//		product.setRemark("99支粉玫瑰");
//		product.setUse_id(12);
//		product.setObject_id(5);
//		product.setFestival_id(8);
//		product.setSom_id(2);
//		boolean flag = p.update(product);
//		System.out.println(flag);
		
		//删除
//		productDaoImpl p = new productDaoImpl();
//		boolean flag = p.delete(67);
//		System.out.println(flag);
		
		//查询一条记录
//		productDaoImpl p = new productDaoImpl();
//		boolean flag = p.selectProductById(67);
//		System.out.println(flag);
		
		
		
		
		
	}

}
