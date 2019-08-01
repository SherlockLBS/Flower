package com.lnsf.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IflowerDao;
import com.lnsf.dao.IproductDetailDao;
import com.lnsf.dao.impl.flowerDaoImpl;
import com.lnsf.dao.impl.productDetailDaoImpl;
import com.lnsf.model.Flower;
import com.lnsf.model.ProductDetail;

public class Cart {
	private static List<CartProduct> l = new ArrayList<CartProduct>();
	
	//添加商品
	public static void add(CartProduct cp){
		//获取商品库存
		//根据product_id获取产品明细表
		//根据产品明细表的flower_id获取库存表
		//根据库存表获取相应库存
		boolean isEnough = true;
		for (ProductDetail pd : new productDetailDaoImpl().all()) {
			if(pd.getProduct_id() == cp.getProduct_id()){
				Flower f = new flowerDaoImpl().selectflowerbyid(pd.getFlower_id());
				if(pd.getFlower_num() > f.getStock()){
					isEnough = false;
				}
			}
		}	
 		if(isEnough){
 			//如果购物车为空，则直接添加商品
 			if(l.isEmpty()){
 				l.add(cp);
 			}
 			else{
 				int n = 0;//利用n存储已存在商品的数量
 				//否则，先判断该商品是否已存在
 				boolean AddorNot = true;//建立标记
 				for (CartProduct product : l) {
 					if(product.equals(cp)){
 						AddorNot = false;//当为false，表示该商品已存在
 						n = product.getNum();//获取当前购物车里已存在商品的数量
 					}
 				}
 				if(AddorNot){//当为true，表示该商品不存在
 					l.add(cp);			
 				}
 				else{//若商品已存在，则添加数量
 					l.get(l.indexOf(cp)).setNum(n+cp.getNum());
 				}
 			}
 		}
 		else{//测试用，可按需求更改
 			System.out.println("测试用:无库存");
 		}
	}
	
	//删除商品
	public static void remove(CartProduct cp){
		l.remove(cp);
	}
	
	//结算
	public static float bill(){
		Connection conn = DataAccess.getConnection();
		//计算金额
		float paynum = 0;
		for (CartProduct cartProduct : l) {
			paynum += cartProduct.getNum()*cartProduct.getProduct_price();
		}
		//减库存
		//遍历购物车所有商品的产品明细，找出原材料的编号，利用库存表计算库存，并新建对象存储
		List<Flower> fl = new ArrayList<Flower>();
		IflowerDao fd = new flowerDaoImpl(); 
		for (ProductDetail pd : new productDetailDaoImpl().all()) {
			for (CartProduct cartProduct : l) {
				if(pd.getProduct_id() == cartProduct.getProduct_id()){
					Flower f = fd.selectflowerbyid(pd.getFlower_id());
					f.setStock(f.getStock()-pd.getFlower_num());
					fl.add(f);
				}
			}
		}
		try{
			conn.setAutoCommit(false);
			//利用得到的对象数组更新库存表
			for (Flower flower : fl) {
				fd.update(flower);
			}
			//提交订单
			//插入订单表
			
			//插入订单明细表
			
			conn.setAutoCommit(true);
			conn.commit();
		}catch(SQLException e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return paynum;
	}
	
	//清空
	public static void removeAll(){
		l.clear();
	}
}
