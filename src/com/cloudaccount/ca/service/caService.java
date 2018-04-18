package com.cloudaccount.ca.service;

import java.util.List;

import com.cloudaccount.ca.dao.caDao;
import com.cloudaccount.ca.domain.caZhangwu;

/*
 * 业务层
 * 接收控制层controller数据
 * 进行数据计算再传给dao层
 */
public class caService {
	private static caDao dao = new caDao();
	
	//查询全部数据
	public List<caZhangwu> selectAll() {
		return dao.selectAll();
	}
	
	//查询日期范围数据
	public List<caZhangwu> select(String startdate, String enddate) {
		return dao.select(startdate,enddate);
	}
	
	//添加账务
	public int insertZhangwu(String flname, String zhanghu, String money, String date, String desc) {
		// TODO Auto-generated method stub
		return dao.insertZhangwu(flname,zhanghu,money,date,desc);
	}
	
	//编辑账务
	public int editZhangwu(caZhangwu zw) {
		return dao.editZhangwu(zw);
	}

	public int deleteZhangwu(int id) {
		// TODO Auto-generated method stub
		return dao.deleteZhangwu(id);
	}
}
