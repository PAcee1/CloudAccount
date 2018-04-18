package com.cloudaccount.ca.app;
/**
 *  本项目为JAVASE基础综合项目，包含了若干个知识点，达到将SE所学知识综合使用，提高了我们对项目的理解与知识点的运用。
 *	熟练View层、Service层、Dao层之间的方法相互调用操作、
 *	熟练dbutils操作数据库表完成增删改查
 *	通过本项目，让我们了解公司项目开发的流程，充分的掌握项目需求分析、设计与功能的代码实现。提高同学们独立分析需求与功能实现的能力。
 * @author ZhaoYuJie(Pace)
 */
import com.cloudaccount.ca.view.mainView;

/*
 * 主程序类，开启软件程序
 */
public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new mainView().run();
	}

}
