package com.cloudaccount.ca.controller;

import java.util.List;

import com.cloudaccount.ca.domain.caZhangwu;
import com.cloudaccount.ca.service.caService;

/*
 * ���Ʋ�
 * ������ͼ�����ݣ����ݸ�service��
 */
public class caController {
	private static caService service = new caService();

	//��ѯȫ������
	public List<caZhangwu> selectAll() {
		return service.selectAll();
	}
	
	//��ѯ���ڷ�Χ����
	public List<caZhangwu> select(String startdate, String enddate) {
		return service.select(startdate,enddate);
	}

	//�������
	public int insertZhangwu(String flname, String zhanghu, String money, String date, String desc) {
		// TODO Auto-generated method stub
		return service.insertZhangwu(flname,zhanghu,money,date,desc);
	}
	
	//�༭����
	public int editZhangwu(caZhangwu zw) {
		return service.editZhangwu(zw);
	}

	public int deleteZhangwu(int id) {
		// TODO Auto-generated method stub
		return service.deleteZhangwu(id);
	}
}
