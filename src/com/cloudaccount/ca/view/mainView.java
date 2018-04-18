package com.cloudaccount.ca.view;

import java.util.List;
import java.util.Scanner;

import com.cloudaccount.ca.controller.caController;
import com.cloudaccount.ca.domain.caZhangwu;
/*
 * 显示层，将菜单打印出来
 * 并且传递需要的参数，调用其方法。
 * 打印结果。
 */
public class mainView {
	private static caController controller = new caController();
	
	public static void run() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("---------------云记账企业记账软件---------------");
			System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
			System.out.println("请输入要操作的功能序号[1-5]:");
			int choose = sc.nextInt();
			//根据用户选择提供功能
			switch (choose) {
			case 1:
				//添加账务
				insertZhangwu();
				break;
			case 2:
				//编辑账务
				editZhangwu();
				break;
			case 3:
				//删除账务
				deleteZhangwu();
				break;
			case 4:
				//查询账务
				selectZhangwu();
				break;
			case 5:
				System.out.println("退出系统");
				System.exit(0);

			default:
				System.out.println("输入选项有误，请重新输入");
			}
		}
	}

	//1.添加功能
	public static void insertZhangwu() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//输入数据
		System.out.print("请输入类别：");
		String flname = sc.nextLine();
		System.out.print("请输入账户：");
		String zhanghu = sc.nextLine();
		System.out.print("请输入金额：");
		String money = sc.nextLine();
		System.out.print("请输入时间：");
		String date = sc.nextLine();
		System.out.print("请输入说明：");
		String desc = sc.nextLine();
		//接收成功执行了几条语句
		int add = controller.insertZhangwu(flname,zhanghu,money,date,desc);
		System.out.println("添加账务成功！");
	}
	
	//2.编辑账务
	public static void editZhangwu() {
		Scanner sc = new Scanner(System.in);
		//输入数据
		System.out.print("请输入需要编辑ID：");
		int id = sc.nextInt();
		System.out.print("请输入新类别：");
		String flname = sc.next();
		System.out.print("请输入新账户：");
		String zhanghu = sc.next();
		System.out.print("请输入新金额：");
		String money = sc.next();
		System.out.print("请输入新时间：");
		String date = sc.next();
		System.out.print("请输入说明：");
		String desc = sc.next();
		//把输入的数据封装到对象中
		caZhangwu newzw = new caZhangwu(id, flname,Double.parseDouble(money), zhanghu, date, desc);
		//接收成功执行了几条语句
		int edit = controller.editZhangwu(newzw);
		//判断是否成功
		if(edit!=0)
			System.out.println("编辑账务成功");
	}
	
	//3.删除账务
	public static void deleteZhangwu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入需要删除账务的ID：");
		int id = sc.nextInt();
		//获取成功执行了几条语句
		int delete = controller.deleteZhangwu(id);
		//判断是否删除成功
		if(delete!=0)
			System.out.println("删除账务成功");
	}
	
	//4.查询功能
	public static void selectZhangwu() {
		System.out.println("1. 查询所有     2. 快条件查询");
		Scanner sc= new Scanner(System.in);
		int schoose = sc.nextInt();
		//根据用户选择提供功能
		switch (schoose) {
		case 1:
			selectAll();
			break;
		
		case 2:
			select();
			break;
			
		default:
			System.out.println("输入选项有误，请重新输入");
		}
		
	}

	//按日期范围查询
	public static void select() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("查询日期格式：XXXX-XX-XX");
		System.out.print("请输入查询开始日期：");
		String startdate = sc.nextLine();
		System.out.print("请输入查询截止日期：");
		String enddate = sc.nextLine();
		List<caZhangwu> list = controller.select(startdate,enddate);
		if(list.isEmpty()){
			System.out.println("该日期范围没有结果");
		}else {
			print(list);
		}
	}
	
	//查询所有数据
	public static void selectAll() {
		// TODO Auto-generated method stub
		List<caZhangwu> list = controller.selectAll();
		print(list);
	}
	
	public static void print(List<caZhangwu> list) {
		System.out.println("ID\t类别\t账户\t金额\t时间\t\t说明");
		for(caZhangwu zw : list) {
			System.out.println(zw.getAid()+"\t"+zw.getAflname()+"\t"+zw.getAzhanghu()+"\t"+
						zw.getAmoney()+"\t"+zw.getAcreatetime()+"\t"+zw.getAdesc());
		}
	}
}
