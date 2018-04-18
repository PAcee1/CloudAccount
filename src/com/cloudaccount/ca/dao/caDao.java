package com.cloudaccount.ca.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cloudaccount.ca.domain.caZhangwu;
import com.cloudaccount.ca.tools.JDBCUtils;
/*
 * Dao�㣬ʵ�����蹦��
 */
public class caDao {
	private static QueryRunner qr = new QueryRunner(JDBCUtils.getDataSourse());
	
	//��ѯȫ������
	public List<caZhangwu> selectAll() {
		String sql = "select * from account";
		try {
			List<caZhangwu> result = qr.query(sql, new BeanListHandler<caZhangwu>(caZhangwu.class));
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			throw new RuntimeException("��ѯʧ��");
		}
	}
	
	//��ѯ���ڷ�Χ����
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
			throw new RuntimeException("���ʧ��");
		}
		
	}

	//�������
	public int insertZhangwu(String flname, String zhanghu, String money, String date, String desc) {
		// TODO Auto-generated method stub
		String sql = "insert into account (aflname,azhanghu,amoney,acreatetime,adesc) value (?,?,?,?,?)";
		Object[] params = {flname,zhanghu,money,date,desc};
		//ִ��update����������sql����paramsռλ������
		try {
			int add = qr.update(sql, params);
			return add;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			throw new RuntimeException("���ʧ��");
		}
		
	}
	
	//�༭����
	public int editZhangwu(caZhangwu zw) {
		String sql = "update account set aflname=?,azhanghu=?,amoney=?,acreatetime=?,adesc=? where aid=?";
		Object[] params = {zw.getAflname(),zw.getAzhanghu(),zw.getAmoney(),zw.getAcreatetime(),zw.getAdesc(),zw.getAid()};
		//ִ��update����������sql����paramsռλ������
		try {
			int edit = qr.update(sql, params);
			return edit;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			throw new RuntimeException("�༭ʧ��");
		}

	}

	public int deleteZhangwu(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from account where aid=?";
		Object[] params = {id};
		//ִ��update����������sql����paramsռλ������
		try {
			int delete = qr.update(sql, params);
			return 0;
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("ɾ��ʧ��");
		}
	}
}
