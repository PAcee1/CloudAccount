package com.cloudaccount.ca.controller;

import java.util.List;

import com.cloudaccount.ca.domain.caZhangwu;
import com.cloudaccount.ca.service.caService;

/*
 * 控制层
 * 接收视图层数据，传递给service层
 */
public class caController {
	private static caService service = new caService();

	//查询全部数据
	public List<caZhangwu> selectAll() {
		return service.selectAll();
	}
	
	//查询日期范围数据
	public List<caZhangwu> select(String startdate, String enddate) {
		return service.select(startdate,enddate);
	}

	//添加数据
	public int insertZhangwu(String flname, String zhanghu, String money, String date, String desc) {
		// TODO Auto-generated method stub
		return service.insertZhangwu(flname,zhanghu,money,date,desc);
	}
	
	//编辑数据
	public int editZhangwu(caZhangwu zw) {
		return service.editZhangwu(zw);
	}

	public int deleteZhangwu(int id) {
		// TODO Auto-generated method stub
		return service.deleteZhangwu(id);
	}
}
