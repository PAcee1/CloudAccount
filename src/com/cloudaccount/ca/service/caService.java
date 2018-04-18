package com.cloudaccount.ca.service;

import java.util.List;

import com.cloudaccount.ca.dao.caDao;
import com.cloudaccount.ca.domain.caZhangwu;

/*
 * ҵ���
 * ���տ��Ʋ�controller����
 * �������ݼ����ٴ���dao��
 */
public class caService {
	private static caDao dao = new caDao();
	
	//��ѯȫ������
	public List<caZhangwu> selectAll() {
		return dao.selectAll();
	}
	
	//��ѯ���ڷ�Χ����
	public List<caZhangwu> select(String startdate, String enddate) {
		return dao.select(startdate,enddate);
	}
	
	//�������
	public int insertZhangwu(String flname, String zhanghu, String money, String date, String desc) {
		// TODO Auto-generated method stub
		return dao.insertZhangwu(flname,zhanghu,money,date,desc);
	}
	
	//�༭����
	public int editZhangwu(caZhangwu zw) {
		return dao.editZhangwu(zw);
	}

	public int deleteZhangwu(int id) {
		// TODO Auto-generated method stub
		return dao.deleteZhangwu(id);
	}
}
