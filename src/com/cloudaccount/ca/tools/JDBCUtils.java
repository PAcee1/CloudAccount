package com.cloudaccount.ca.tools;
/*
 * 数据库连接工具类
 */

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
	private static BasicDataSource dataSourse = new BasicDataSource();
	private JDBCUtils() {
	}
	
	static {
		dataSourse.setDriverClassName("com.mysql.jdbc.Driver");
		dataSourse.setUrl("jdbc:mysql://localhost:3306/cloudaccount");
		dataSourse.setUsername("root");
		dataSourse.setPassword("root");
		dataSourse.setInitialSize(10);
		dataSourse.setMaxActive(8);
		dataSourse.setMaxIdle(5);
		dataSourse.setMinIdle(2);
	}
	
	public static BasicDataSource getDataSourse() {
		return dataSourse;
	}
}
