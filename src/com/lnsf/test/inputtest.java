package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.inputDaoImpl;
import com.lnsf.model.Input;

public class inputtest {

	public static void main(String[] args) {
		// ���Ҳ���
		 List<Input> l = new ArrayList<Input>();
		 inputDaoImpl id = new inputDaoImpl();
		 l = id.all();
		 for (Input i : l)
		 System.out.println(i.toString());

		// ������ԣ�ʱ�������޷����룩
		// Input i = new Input();
		// inputDaoImpl id = new inputDaoImpl();
		// Scanner sc = new Scanner(System.in);
		// System.out.println("���������Ŀ���ţ�");
		// int flower_id = sc.nextInt();
		// i.setFlower_id(flower_id);
		// System.out.println("�������������:");
		// int input_num = sc.nextInt();
		// i.setInput_num(input_num);
		// System.out.println("����������ܼۣ�");
		// float intput_price = sc.nextFloat();
		// i.setInput_price(intput_price);
		// System.out.println("������������ڣ�");
		// String input_date = sc.next();
		// i.setInput_date(input_date);
		// System.out.println(id.insert(i));

		// ɾ������
		// inputDaoImpl id = new inputDaoImpl();
		// System.out.println(id.delete(50));

		// �޸Ĳ���
		// inputDaoImpl id=new inputDaoImpl();
		// Input i=new Input();
		// i.setFlower_id(50);
		// i.setInput_num(100);
		// i.setInput_date("20190931");
		// System.out.println(id.update(i));

		// ��id����
		// inputDaoImpl id=new inputDaoImpl();
		// System.out.println(id.selectinputbyid(1));
	}
}
