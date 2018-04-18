package com.cloudaccount.ca.view;

import java.util.List;
import java.util.Scanner;

import com.cloudaccount.ca.controller.caController;
import com.cloudaccount.ca.domain.caZhangwu;
/*
 * ��ʾ�㣬���˵���ӡ����
 * ���Ҵ�����Ҫ�Ĳ����������䷽����
 * ��ӡ�����
 */
public class mainView {
	private static caController controller = new caController();
	
	public static void run() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("---------------�Ƽ�����ҵ�������---------------");
			System.out.println("1.�������2.�༭����3.ɾ������4.��ѯ����5.�˳�ϵͳ");
			System.out.println("������Ҫ�����Ĺ������[1-5]:");
			int choose = sc.nextInt();
			//�����û�ѡ���ṩ����
			switch (choose) {
			case 1:
				//�������
				insertZhangwu();
				break;
			case 2:
				//�༭����
				editZhangwu();
				break;
			case 3:
				//ɾ������
				deleteZhangwu();
				break;
			case 4:
				//��ѯ����
				selectZhangwu();
				break;
			case 5:
				System.out.println("�˳�ϵͳ");
				System.exit(0);

			default:
				System.out.println("����ѡ����������������");
			}
		}
	}

	//1.��ӹ���
	public static void insertZhangwu() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//��������
		System.out.print("���������");
		String flname = sc.nextLine();
		System.out.print("�������˻���");
		String zhanghu = sc.nextLine();
		System.out.print("�������");
		String money = sc.nextLine();
		System.out.print("������ʱ�䣺");
		String date = sc.nextLine();
		System.out.print("������˵����");
		String desc = sc.nextLine();
		//���ճɹ�ִ���˼������
		int add = controller.insertZhangwu(flname,zhanghu,money,date,desc);
		System.out.println("�������ɹ���");
	}
	
	//2.�༭����
	public static void editZhangwu() {
		Scanner sc = new Scanner(System.in);
		//��������
		System.out.print("��������Ҫ�༭ID��");
		int id = sc.nextInt();
		System.out.print("�����������");
		String flname = sc.next();
		System.out.print("���������˻���");
		String zhanghu = sc.next();
		System.out.print("�������½�");
		String money = sc.next();
		System.out.print("��������ʱ�䣺");
		String date = sc.next();
		System.out.print("������˵����");
		String desc = sc.next();
		//����������ݷ�װ��������
		caZhangwu newzw = new caZhangwu(id, flname,Double.parseDouble(money), zhanghu, date, desc);
		//���ճɹ�ִ���˼������
		int edit = controller.editZhangwu(newzw);
		//�ж��Ƿ�ɹ�
		if(edit!=0)
			System.out.println("�༭����ɹ�");
	}
	
	//3.ɾ������
	public static void deleteZhangwu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ҫɾ�������ID��");
		int id = sc.nextInt();
		//��ȡ�ɹ�ִ���˼������
		int delete = controller.deleteZhangwu(id);
		//�ж��Ƿ�ɾ���ɹ�
		if(delete!=0)
			System.out.println("ɾ������ɹ�");
	}
	
	//4.��ѯ����
	public static void selectZhangwu() {
		System.out.println("1. ��ѯ����     2. ��������ѯ");
		Scanner sc= new Scanner(System.in);
		int schoose = sc.nextInt();
		//�����û�ѡ���ṩ����
		switch (schoose) {
		case 1:
			selectAll();
			break;
		
		case 2:
			select();
			break;
			
		default:
			System.out.println("����ѡ����������������");
		}
		
	}

	//�����ڷ�Χ��ѯ
	public static void select() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("��ѯ���ڸ�ʽ��XXXX-XX-XX");
		System.out.print("�������ѯ��ʼ���ڣ�");
		String startdate = sc.nextLine();
		System.out.print("�������ѯ��ֹ���ڣ�");
		String enddate = sc.nextLine();
		List<caZhangwu> list = controller.select(startdate,enddate);
		if(list.isEmpty()){
			System.out.println("�����ڷ�Χû�н��");
		}else {
			print(list);
		}
	}
	
	//��ѯ��������
	public static void selectAll() {
		// TODO Auto-generated method stub
		List<caZhangwu> list = controller.selectAll();
		print(list);
	}
	
	public static void print(List<caZhangwu> list) {
		System.out.println("ID\t���\t�˻�\t���\tʱ��\t\t˵��");
		for(caZhangwu zw : list) {
			System.out.println(zw.getAid()+"\t"+zw.getAflname()+"\t"+zw.getAzhanghu()+"\t"+
						zw.getAmoney()+"\t"+zw.getAcreatetime()+"\t"+zw.getAdesc());
		}
	}
}
