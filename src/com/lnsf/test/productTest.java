package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.productDaoImpl;
import com.lnsf.model.Product;

public class productTest {
	
	public static void main(String[] args) {
		
		//����ȫ��
		productDaoImpl product = new productDaoImpl();
		List<Product> list = new ArrayList<Product>();
		list = product.all();
		for(Product l:list)
			System.out.println(l);
		
		//���
//		productDaoImpl p = new productDaoImpl();
//		Product product = new Product(); 
//		product.setProduct_name("������Ů");
//		product.setProduct_price(599);
//		product.setRemark("99֧��õ��");
//		product.setUse_id(1);
//		product.setObject_id(1);
//		product.setFestival_id(1);
//		product.setSom_id(1);
//		boolean flag = p.insert(product);
//		System.out.println(flag);
		
		//����
//		productDaoImpl p = new productDaoImpl();
//		Product product = new Product(); 
//		product.setProduct_id(67);
//		product.setProduct_name("������Ů");
//		product.setProduct_price(599);
//		product.setRemark("99֧��õ��");
//		product.setUse_id(12);
//		product.setObject_id(5);
//		product.setFestival_id(8);
//		product.setSom_id(2);
//		boolean flag = p.update(product);
//		System.out.println(flag);
		
		//ɾ��
//		productDaoImpl p = new productDaoImpl();
//		boolean flag = p.delete(67);
//		System.out.println(flag);
		
		//��ѯһ����¼
//		productDaoImpl p = new productDaoImpl();
//		boolean flag = p.selectProductById(67);
//		System.out.println(flag);
		
		
		
		
		
	}

}
