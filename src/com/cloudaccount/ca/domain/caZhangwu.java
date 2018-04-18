package com.cloudaccount.ca.domain;
/*
 * 一个JavaBean包，把表中属性以类形式保存
 */
public class caZhangwu {
	private int aid;
	private String aflname;
	private double amoney;
	private String azhanghu;
	private String acreatetime;
	private String adesc;
	public caZhangwu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public caZhangwu(int aid, String aflname, double amoney, String azhanghu, String acreatetime, String adesc) {
		super();
		this.aid = aid;
		this.aflname = aflname;
		this.amoney = amoney;
		this.azhanghu = azhanghu;
		this.acreatetime = acreatetime;
		this.adesc = adesc;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAflname() {
		return aflname;
	}
	public void setAflname(String aflname) {
		this.aflname = aflname;
	}
	public double getAmoney() {
		return amoney;
	}
	public void setAmoney(double amoney) {
		this.amoney = amoney;
	}
	public String getAzhanghu() {
		return azhanghu;
	}
	public void setAzhanghu(String azhanghu) {
		this.azhanghu = azhanghu;
	}
	public String getAcreatetime() {
		return acreatetime;
	}
	public void setAcreatetime(String acreatetime) {
		this.acreatetime = acreatetime;
	}
	public String getAdesc() {
		return adesc;
	}
	public void setAdesc(String adesc) {
		this.adesc = adesc;
	}
	@Override
	public String toString() {
		return "caZhangwu [aid=" + aid + ", aflname=" + aflname + ", amoney=" + amoney + ", azhanghu=" + azhanghu
				+ ", acreatetime=" + acreatetime + ", adesc=" + adesc + "]";
	}

	
}
