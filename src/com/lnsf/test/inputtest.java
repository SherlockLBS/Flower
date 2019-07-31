package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.inputDaoImpl;
import com.lnsf.model.Input;

public class inputtest {

	public static void main(String[] args) {
		// 查找测试
		 List<Input> l = new ArrayList<Input>();
		 inputDaoImpl id = new inputDaoImpl();
		 l = id.all();
		 for (Input i : l)
		 System.out.println(i.toString());

		// 插入测试（时间类型无法插入）
		// Input i = new Input();
		// inputDaoImpl id = new inputDaoImpl();
		// Scanner sc = new Scanner(System.in);
		// System.out.println("请输入插入的库存编号：");
		// int flower_id = sc.nextInt();
		// i.setFlower_id(flower_id);
		// System.out.println("请输入进货数量:");
		// int input_num = sc.nextInt();
		// i.setInput_num(input_num);
		// System.out.println("请输入进货总价：");
		// float intput_price = sc.nextFloat();
		// i.setInput_price(intput_price);
		// System.out.println("请输入进货日期：");
		// String input_date = sc.next();
		// i.setInput_date(input_date);
		// System.out.println(id.insert(i));

		// 删除测试
		// inputDaoImpl id = new inputDaoImpl();
		// System.out.println(id.delete(50));

		// 修改测试
		// inputDaoImpl id=new inputDaoImpl();
		// Input i=new Input();
		// i.setFlower_id(50);
		// i.setInput_num(100);
		// i.setInput_date("20190931");
		// System.out.println(id.update(i));

		// 按id查找
		// inputDaoImpl id=new inputDaoImpl();
		// System.out.println(id.selectinputbyid(1));
	}
}
