package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.flowerDaoImpl;
import com.lnsf.model.Flower;

public class flowertest {
	public static void main(String[] args) {
		// ���Ҳ���
		List<Flower> l=new ArrayList<Flower>(); flowerDaoImpl fd=new
		flowerDaoImpl(); l=fd.all(); for(Flower f:l)
		System.out.println(f.toString());

		// �������
		/*
		 * Flower f=new Flower(); Scanner sc=new Scanner(System.in);
		 * System.out.println("������Ҫ�����name��"); String Flower_name=sc.next();
		 * f.setFlower_name(Flower_name); System.out.println("������Ҫ�����stock��");
		 * int Stock=sc.nextInt(); f.setStock(Stock);
		 * System.out.println("������Ҫ�����price��"); int Flower_price=sc.nextInt();
		 * f.setFlower_price(Flower_price); flowerDaoImpl fd=newflowerDaoImpl();
		 * if(fd.insert(f)==true){ System.out.println("����ɹ���"); } else{
		 * System.out.println("����ʧ�ܣ�"); }
		 */

		// ɾ������

		// flowerDaoImpl fd=new flowerDaoImpl();
		// Flower f=new Flower(); Scanner sc=new Scanner(System.in);
		// System.out.println("������Ҫɾ����id��");
		// int flower_id=sc.nextInt();
		// f=fd.selectflowerbyid(flower_id);
		// if(f.getFlower_id()!=0&&f.getFlag()!=0){
		// System.out.println("������¼���ڣ�����ɾ����");
		// if(fd.delete(flower_id)==true){
		// System.out.println("ɾ���ɹ���"); }
		// else
		// System.out.println("ɾ��ʧ�ܣ�"); }
		// else { System.out.println("������¼�����ڣ�����ɾ����"); }
		//

		// �޸Ĳ���
		// flowerDaoImpl fd = new flowerDaoImpl();
		// Flower f = new Flower();
		// Scanner sc = new Scanner(System.in);
		// System.out.println("������Ҫ�޸ĵ�id��");
		// int flower_id = sc.nextInt();
		// f = fd.selectflowerbyid(flower_id);
		// if (f.getFlower_id() != 0 && f.getFlag() != 0) {
		// System.out.println("������¼���ڣ������޸ģ�");
		// System.out.println("������Ҫ�޸ĵ����֣�");
		// String flower_name = sc.next();
		// f.setFlower_name(flower_name);
		// System.out.println("������Ҫ�޸ĵĿ������");
		// int stock = sc.nextInt();
		// f.setStock(stock);
		// System.out.println("������Ҫ�޸ĵ��ʻ��۸�");
		// float price = sc.nextInt();
		// f.setFlower_price(price);
		// if (fd.update(f) == true) {
		// System.out.println("�޸ĳɹ���");
		// } else
		// System.out.println("�޸�ʧ�ܣ�");
		// } else {
		// System.out.println("������¼�����ڣ������޸ģ�");
		// }
		//
	}
}
