package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.flowerDaoImpl;
import com.lnsf.model.Flower;

public class flowertest {
	public static void main(String[] args) {
		// 查找测试
		List<Flower> l=new ArrayList<Flower>(); flowerDaoImpl fd=new
		flowerDaoImpl(); l=fd.all(); for(Flower f:l)
		System.out.println(f.toString());

		// 插入测试
		/*
		 * Flower f=new Flower(); Scanner sc=new Scanner(System.in);
		 * System.out.println("请输入要插入的name："); String Flower_name=sc.next();
		 * f.setFlower_name(Flower_name); System.out.println("请输入要插入的stock：");
		 * int Stock=sc.nextInt(); f.setStock(Stock);
		 * System.out.println("请输入要插入的price："); int Flower_price=sc.nextInt();
		 * f.setFlower_price(Flower_price); flowerDaoImpl fd=newflowerDaoImpl();
		 * if(fd.insert(f)==true){ System.out.println("插入成功！"); } else{
		 * System.out.println("插入失败！"); }
		 */

		// 删除测试

		// flowerDaoImpl fd=new flowerDaoImpl();
		// Flower f=new Flower(); Scanner sc=new Scanner(System.in);
		// System.out.println("请输入要删除的id：");
		// int flower_id=sc.nextInt();
		// f=fd.selectflowerbyid(flower_id);
		// if(f.getFlower_id()!=0&&f.getFlag()!=0){
		// System.out.println("该条记录存在，可以删除！");
		// if(fd.delete(flower_id)==true){
		// System.out.println("删除成功！"); }
		// else
		// System.out.println("删除失败！"); }
		// else { System.out.println("该条记录不存在，不能删除！"); }
		//

		// 修改测试
		// flowerDaoImpl fd = new flowerDaoImpl();
		// Flower f = new Flower();
		// Scanner sc = new Scanner(System.in);
		// System.out.println("请输入要修改的id：");
		// int flower_id = sc.nextInt();
		// f = fd.selectflowerbyid(flower_id);
		// if (f.getFlower_id() != 0 && f.getFlag() != 0) {
		// System.out.println("该条记录存在，可以修改！");
		// System.out.println("请输入要修改的名字：");
		// String flower_name = sc.next();
		// f.setFlower_name(flower_name);
		// System.out.println("请输入要修改的库存量：");
		// int stock = sc.nextInt();
		// f.setStock(stock);
		// System.out.println("请输入要修改的鲜花价格：");
		// float price = sc.nextInt();
		// f.setFlower_price(price);
		// if (fd.update(f) == true) {
		// System.out.println("修改成功！");
		// } else
		// System.out.println("修改失败！");
		// } else {
		// System.out.println("该条记录不存在，不能修改！");
		// }
		//
	}
}
