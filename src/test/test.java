package test;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;

import org.apache.ibatis.session.SqlSession;
import org.great.aop.Sleepable;
import org.great.bean.ConditionBean;
import org.great.bean.DocBean;
import org.great.bean.UserBean;
import org.great.daoFactory.DaoFactory;
import org.great.util.MybatisTool;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dbDao.DocInterface;
import dbDao.UserDao;
import dbDao.UserInterface;


public class test {
	
	
	//private 
	@Test
	public void ConditionQueryUser() {
		
		//UserDao userDao = (UserDao) DaoFactory.getInstance("dbDao.UserDao");

		//ArrayList<UserBean> userList=new ArrayList<UserBean>();
		//conditionData=new ArrayList<String>();
		StringBuffer conditionSql=new StringBuffer("SELECT * FROM TBLUSER WHERE 1=1 ");
		ArrayList<Object> conditionList=new ArrayList<Object>();
		String conditionName = "123";
		
		if (null != conditionName && !"".equals(conditionName)) {

//			StringBuffer condition = new StringBuffer(" AND NAME like ?");
//			conditionSql.append(condition);
//			conditionList.add("%" + conditionName + "%");
			StringBuffer condition = new StringBuffer(" AND NAME like '%" + conditionName + "%'");
			conditionSql.append(condition);
			//conditionList.add("%" + conditionName + "%");
		}
		
		Integer pageNo=1;
		Integer dataCount=3;
		
		System.out.println("sql---"+conditionSql.toString());
		
		SqlSession session = MybatisTool.getSession();
		UserInterface userInterface=session.getMapper(UserInterface.class);
		
		ConditionBean conditionBean =new ConditionBean();
		conditionBean.setConditionSql("%123%");
		conditionBean.setPageNo(pageNo);
		conditionBean.setDataCount(dataCount);
		
		String sqlTest=conditionSql.toString();//" AND NAME like '%" + conditionName + "%'";
		System.out.println("test---"+sqlTest);
		String conditionSqlX=sqlTest;
		ArrayList<UserBean> userList=userInterface.ConditionPageQueryUserX(conditionSqlX,pageNo,dataCount);
		
		System.out.println("****//"+userList.size());
		
		//ArrayList<UserBean> userList = userDao.ConditionPageQueryUser(conditionSql, conditionList, 2, 3);
		for(int i=0;i<userList.size();i++){
			System.out.println("***/"+(i+1)+"/---"+userList.get(i).getName());
		}
	}
	
//	@Test
//	public void test1() {
//		StringBuffer conditionSql=new StringBuffer("SELECT * FROM TBLUSER WHERE 1=1 ");
//		String conditionName = "123";
//		
//		if (null != conditionName && !"".equals(conditionName)) {
//
////			StringBuffer condition = new StringBuffer(" AND NAME like ?");
////			conditionSql.append(condition);
////			conditionList.add("%" + conditionName + "%");
//			StringBuffer condition = new StringBuffer(" AND NAME like '%" + conditionName + "%'");
//			conditionSql.append(condition);
//			//conditionList.add("%" + conditionName + "%");
//		}
//		
//		SqlSession session = MybatisTool.getSession();
//		UserInterface userInterface=session.getMapper(UserInterface.class);
//		String conditionSqlX = conditionSql.toString();
//		ArrayList<UserBean> userList=userInterface.ConditionQueryUserX(conditionSqlX);
//		
//		
//		
//		for(int i=0;i<userList.size();i++){
//			System.out.println("***/"+(i+1)+"/---"+userList.get(i).getName());
//		}
//	}
	
//	@Test
//	public void LianBiao() {
//		
//		SqlSession session = MybatisTool.getSession();
//		DocInterface docInterface=session.getMapper(DocInterface.class);
//		UserBean userBean = new UserBean();
//		userBean.setUserId(1);
//		UserBean u = docInterface.QueryDocX(userBean);
//		for(int i=0;i<u.getDocList().size();i++){
//			System.out.println(u.getDocList().get(i).getDocTitle());
//		}
//		
//	}
	
	
//	@Test
//	public void ParamTest() {
//		String s = "applicationContext.xml";
//		ApplicationContext conf = new ClassPathXmlApplicationContext(s);
//		System.out.println(conf);//初始化容器
//		DocBean e1 = conf.getBean( DocBean.class);
//		System.out.println(e1.getDocUrl());//初始化容器
////		Example e2 = conf.getBean("e", Example.class);// bean别名
////		Example e3 = conf.getBean("e2", Example.class);// bean别名
//	}
	
//	@Test
//	public void AopTest() {
//		
//		ApplicationContext ct = new ClassPathXmlApplicationContext("applicationContext_aop01.xml");
//
//		Sleepable sleeper = (Sleepable) ct.getBean("linaProxy");
//
//		sleeper.sleep();
//	}
	
//	@Test
//	public void StuckPointTest() {
//		int a = 5;
//		int b=10;
//		a=b;
//		System.out.println("---//"+a);
//	}
}
