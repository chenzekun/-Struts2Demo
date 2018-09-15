package dbDao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.great.bean.ConditionBean;
import org.great.bean.UserBean;


public interface UserInterface extends BaseInterface{
	
	public boolean AddUser(UserBean addUser);
	
//	public boolean DeleteUser(UserConditionBean deleteUser);
//	
//	public boolean ResetUserPsw(UserConditionBean resetUser);
//	
//	public void ChangeSum(UserConditionBean user);
	
//	public int QueryUserStatistic(String sDate,String eDate);
	
//	public boolean UpdateUserLockState(UserConditionBean updateUser);
	
	//public boolean UpdateMoreUser(UserBean updateUser);
	
//	public UserBean QueryUserByName(UserConditionBean UserBeanOfName);
//	
//	public UserBean QueryUserById(UserConditionBean UserBeanOfId);
	
	public ArrayList<UserBean> QueryUser();
	
	public ArrayList<UserBean> ConditionPageQueryUser(StringBuffer conditionSql,ArrayList<Object> arr,int pageNo,int dataCount);
	
	public ArrayList<UserBean> ConditionPageQueryUserX(@Param("conditionSql")String conditionSqlX,@Param("pageNo")Integer pageNo,@Param("dataCount")Integer dataCount); 
	 //@Param("conditionSql")StringBuffer conditionSql,@Param("pageNo")Integer pageNo,@Param("dataCount")Integer dataCount
	public ArrayList<UserBean> ConditionQueryUser(StringBuffer sql,ArrayList<Object> arr); 
	
	public ArrayList<UserBean> ConditionQueryUserX(@Param("conditionSql")String conditionSqlX);
	
	public ArrayList<UserBean> PageQuery(int pageNo,int dataCount);
}
