package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.productDetailDaoImpl;
import com.lnsf.model.ProductDetail;

public class productDetailTest {
	
	public static void main(String[] args) {
		
		//查找全部
		productDetailDaoImpl pd = new productDetailDaoImpl();
		List<ProductDetail> list = new ArrayList<ProductDetail>();
		list = pd.all();
		for(ProductDetail l:list)
			System.out.println(l);
		
		//添加
//		productDetailDaoImpl pd = new productDetailDaoImpl();
//		ProductDetail pro = new ProductDetail(); 
//		pro.setProduct_id(67);
//		pro.setFlower_id(2);
//		pro.setFlower_num(99);
//		boolean flag = pd.insert(pro);
//		System.out.println(flag);
		
		//更新
//		productDetailDaoImpl pd = new productDetailDaoImpl();
//		ProductDetail pro = new ProductDetail(); 
//		pro.setProductDetail_id(56);
//		pro.setProduct_id(67);
//		pro.setFlower_id(5);
//		pro.setFlower_num(99);
//		boolean flag = pd.update(pro);
//		System.out.println(flag);
		
		//删除
//		productDetailDaoImpl pd = new productDetailDaoImpl();
//		boolean flag = pd.delete(56);
//		System.out.println(flag);
		
		//查询一条记录
//		productDetailDaoImpl pd = new productDetailDaoImpl();
//		boolean flag = pd.selectProductDetailById(56);
//		System.out.println(flag);
		
	}

}
