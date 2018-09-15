package dbDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.ibatis.annotations.Param;
import org.great.bean.ConditionBean;
import org.great.bean.UserBean;
import org.great.util.DbHepler;


public class UserDao implements UserInterface {
	
	private ArrayList<UserBean> arrayList;//��ѯ ���صļ���
	private UserBean userBean;
	//private ResultSet rs;
	//private PreparedStatement pps;
	//private Connection connection;
	private String sql;
	
	public UserDao(){
		
		arrayList = new ArrayList<>();
		userBean=null;
		//rs=null;
		//pps=null;
		//connection =  JDBCConUtil.getInstance().connection;
		sql="";
		
	}
	
	@Override
	public boolean AddUser(UserBean addUser) {
//		   USERID               NUMBER               NOT NULL,
//		   STATEID              NUMBER,
//		   UNAME                VARCHAR2(20),
//		   UPSW                 VARCHAR2(20),
//		   USEX                 VARCHAR2(2),
//		   UAGE                 NUMBER,
//		   UPHONE               NUMBER(11),
//		   UADDRESS             VARCHAR2(400),
//		   USURPLUSMONEY        NUMBER,
//		   UREGISTDATE          VARCHAR2(200),
//		   ULASTLOGINDATE       VARCHAR2(200),
		sql = "INSERT INTO tblUser (USERID, STATEID, UNAME, UPSW, USEX, UAGE,UPHONE,UADDRESS, USURPLUSMONEY, UREGISTDATE, ULASTLOGINDATE) VALUES (SEQID.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
		
		try {
			
			Object params[] = 
				{
//					addUser.getStateId(),
//					addUser.getuName(),
//					addUser.getuPsw(),
//					addUser.getuSex(),
//					addUser.getuAge(),
//					addUser.getuPhone(),
//					addUser.getuAddress(),
//					addUser.getuSurplusMoney(),
//					addUser.getuRegistDate(),
//					addUser.getuLastLoginDate()
				};
			
			DbHepler.getQueryRunner().update(sql, params);
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return true;
	}

//	@Override
//	public boolean DeleteUser(UserConditionBean deleteUser) {
//		
//		sql = "UPDATE tblUser SET STATEID = 9 WHERE USERID = ? ";
//		
//		try {
//			
//			Object params[] = 
//				{
//					deleteUser.getUserId()
//				};
//			
//			DbHepler.getQueryRunner().update(sql, params);
//		
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		return true;
//	}
//
//	@Override
//	public boolean ResetUserPsw(UserConditionBean resetUser) {
//		
//		sql = "UPDATE tblUser SET UPSW = ? WHERE USERID = ?";
//		
//		try {
//			
//			Object params[] = 
//				{
//					resetUser.getuPsw(),
//					resetUser.getUserId()
//				};
//			
//			DbHepler.getQueryRunner().update(sql, params);
//		
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		return true;
//	}
//	
//	@Override
//	public boolean UpdateUserLockState(UserConditionBean updateUser) {
//		
//		sql = "UPDATE tblUser SET STATEID = ? WHERE USERID = ?";
//		//修改后的状态
//		int afterUpdateUState=0;
//		//用户为启用状态
//		if(7==updateUser.getStateId()){
//			afterUpdateUState=8;
//		//用户为禁用状态
//		}else if(8==updateUser.getStateId()){
//			afterUpdateUState=7;
//		}
//		
//		try {
//			
//			Object params[] = 
//				{
//					afterUpdateUState,
//					updateUser.getUserId()
//				};
//			
//			DbHepler.getQueryRunner().update(sql, params);
//		
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		return true;
//	}
//	
//	@SuppressWarnings("deprecation")
//	@Override
//	 public UserBean QueryUserByName(UserConditionBean UserBeanOfName) {
//		
//		sql = "SELECT * FROM tblUser where UNAME= ?";
//		
//		try {
//			
//			Object params[] = 
//				{
//						
//				UserBeanOfName.getuName()
//				
//				};
//			
//			BeanHandler<UserBean> rsh = new BeanHandler<UserBean>(UserBean.class);
//			
//			userBean=DbHepler.getQueryRunner().query(sql, params, rsh);
//			
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		return userBean;
//	}
//	
//	@Override
//	public UserBean QueryUserById(UserConditionBean UserBeanOfId) {
//		
//		sql = "SELECT * FROM tblUser where USERID= ?";
//		
//		try {
//			
//			Object params[] = 
//				{
//					
//				UserBeanOfId.getUserId()
//				
//				};
//			
//			BeanHandler<UserBean> rsh = new BeanHandler<UserBean>(UserBean.class);
//			
//			userBean=DbHepler.getQueryRunner().query(sql, params, rsh);
//			
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		return userBean;
//	}
	
	@Override
	 public ArrayList<UserBean> QueryUser() {
		
		sql = "SELECT * FROM tblUser";
		
		ArrayList<UserBean> arrayList = new ArrayList<>();
		
		try {
			
			BeanListHandler<UserBean> rsh = new BeanListHandler<UserBean>(UserBean.class);
			//DbHepler.getQueryRunner().q
			arrayList=(ArrayList<UserBean>) DbHepler.getQueryRunner().query(sql, rsh);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return arrayList;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public ArrayList<UserBean> ConditionPageQueryUser(StringBuffer conditionSql, ArrayList<Object> arr,int pageNo,int dataCount) {
		
		String finalSql = " SELECT * FROM  (  SELECT A.*, ROWNUM RN  FROM (SELECT * FROM ("+conditionSql+")) A WHERE ROWNUM <= "+pageNo*dataCount+")WHERE RN >= "+((pageNo-1)*dataCount+1) ;
		
		Object[] params=new Object[arr.size()];

		ArrayList<UserBean> arrayList = new ArrayList<>();

		try {
			
			for(int i=0;i<arr.size();i++){
				
				params[i]=arr.get(i);	

			}

			BeanListHandler<UserBean> rsh = new BeanListHandler<UserBean>(UserBean.class);
			
			arrayList=(ArrayList<UserBean>) DbHepler.getQueryRunner().query(finalSql, params, rsh);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return arrayList;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public ArrayList<UserBean> ConditionQueryUser(StringBuffer conditionSql, ArrayList<Object> arr) {
		
		String sql =  conditionSql.toString() ;
		
		Object[] params=new Object[arr.size()];

		ArrayList<UserBean> arrayList = new ArrayList<>();

		try {
			
			for(int i=0;i<arr.size();i++){
				
				params[i]=arr.get(i);	

			}

			BeanListHandler<UserBean> rsh = new BeanListHandler<UserBean>(UserBean.class);
			
			arrayList=(ArrayList<UserBean>) DbHepler.getQueryRunner().query(sql, params, rsh);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return arrayList;
	}

	@Override
	public ArrayList<UserBean> PageQuery(int pageNo,int dataCount) {
		
		sql = " SELECT * FROM  (  SELECT A.*, ROWNUM RN  FROM (SELECT * FROM tblUser) A WHERE ROWNUM <= "+pageNo*dataCount+")WHERE RN >= "+((pageNo-1)*dataCount+1) ;

		ArrayList<UserBean> arrayList = new ArrayList<>();//pageNo*3 (pageNo-1)*3+1
		
		try {
			
			BeanListHandler<UserBean> rsh = new BeanListHandler<UserBean>(UserBean.class);
			//DbHepler.getQueryRunner().q
			arrayList=(ArrayList<UserBean>) DbHepler.getQueryRunner().query(sql, rsh);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return arrayList;
	}

	@Override
	public boolean Insert(String sql, Object[] arr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(String sql, Object[] arr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(String sql, Object[] arr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Object> Query(String sql, Object[] arr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserBean> ConditionPageQueryUserX(String conditionSqlX,Integer pageNo,Integer dataCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserBean> ConditionQueryUserX(String conditionSqlX) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public void ChangeSum(UserConditionBean user) {
//		// TODO Auto-generated method stub
//		
//		sql = "UPDATE tblUser SET USURPLUSMONEY = ? WHERE USERID = ? ";
//		
//		try {
//			
//			Object params[] = 
//				{
//					user.getuSurplusMoney(),
//					user.getUserId()
//				};
//			
//			DbHepler.getQueryRunner().update(sql, params);
//		
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//	}

//	@Override
//	public int QueryUserStatistic(String sDate, String eDate) {
//		
//		sql = "SELECT * FROM tblUser where UREGISTDATE >= ? AND UREGISTDATE <= ?";
//		
//		try {
//			
//			Object params[] = 
//				{
//						sDate,
//						eDate
//				};
//			
//			BeanListHandler<UserBean> rsh = new BeanListHandler<UserBean>(UserBean.class);
//			
//			arrayList=(ArrayList<UserBean>) DbHepler.getQueryRunner().query(sql, params, rsh);
//			
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		return arrayList.size();
//	}








}

