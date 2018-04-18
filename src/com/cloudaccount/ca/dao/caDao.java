package com.cloudaccount.ca.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cloudaccount.ca.domain.caZhangwu;
import com.cloudaccount.ca.tools.JDBCUtils;
/*
 * Dao层，实现所需功能
 */
public class caDao {
	private static QueryRunner qr = new QueryRunner(JDBCUtils.getDataSourse());
	
	//查询全部数据
	public List<caZhangwu> selectAll() {
		String sql = "select * from account";
		try {
			List<caZhangwu> result = qr.query(sql, new BeanListHandler<caZhangwu>(caZhangwu.class));
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			throw new RuntimeException("查询失败");
		}
	}
	
	//查询日期范围数据
	public List<caZhangwu> select(String startdate, String enddate) {
		String sql = "select * from account where acreatetime between ? and ?";
		Object[] params = {startdate,enddate};
		List<caZhangwu> result;
		try {
			result = qr.query(sql, new BeanListHandler<caZhangwu>(caZhangwu.class), params);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			throw new RuntimeException("添加失败");
		}
		
	}

	//添加数据
	public int insertZhangwu(String flname, String zhanghu, String money, String date, String desc) {
		// TODO Auto-generated method stub
		String sql = "insert into account (aflname,azhanghu,amoney,acreatetime,adesc) value (?,?,?,?,?)";
		Object[] params = {flname,zhanghu,money,date,desc};
		//执行update方法，传入sql语句和params占位符参数
		try {
			int add = qr.update(sql, params);
			return add;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			throw new RuntimeException("添加失败");
		}
		
	}
	
	//编辑账务
	public int editZhangwu(caZhangwu zw) {
		String sql = "update account set aflname=?,azhanghu=?,amoney=?,acreatetime=?,adesc=? where aid=?";
		Object[] params = {zw.getAflname(),zw.getAzhanghu(),zw.getAmoney(),zw.getAcreatetime(),zw.getAdesc(),zw.getAid()};
		//执行update方法，传入sql语句和params占位符参数
		try {
			int edit = qr.update(sql, params);
			return edit;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			throw new RuntimeException("编辑失败");
		}

	}

	public int deleteZhangwu(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from account where aid=?";
		Object[] params = {id};
		//执行update方法，传入sql语句和params占位符参数
		try {
			int delete = qr.update(sql, params);
			return 0;
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("删除失败");
		}
	}
}
