package org.great.biz;


import java.util.ArrayList;
import org.great.bean.PageQueryBean;
import org.great.bean.UserBean;
import org.great.daoFactory.DaoFactory;
import dbDao.UserDao;


public class UserBizImpl implements UsreBiz {

	@Override
	public int QueryUserListAllPage(StringBuffer conditionSql, ArrayList<Object> conditionList,
			ArrayList<UserBean> userList, int allPage, int currentPage, int dataCount) {
		// ��ѯ��ҳ��
		UserDao userDaoX = (UserDao) DaoFactory.getInstance("dbDao.UserDao");
		userList = userDaoX.ConditionQueryUser(conditionSql, conditionList);
		// ��ҳ��
		allPage = (userList.size()) / dataCount;
		if (0 == allPage) {
			allPage = 1;
		} else if ((userList.size()) % dataCount == 0) {

		} else {
			allPage++;
		}

		System.out.println("�û�������" + userList.size());
		System.out.println("��ҳ����" + allPage);
		return allPage;
	}

	@Override
	public PageQueryBean UserListPageQuery(ArrayList<String> conditionData, StringBuffer conditionSql,
			ArrayList<Object> conditionList, int uId, boolean pageQueryFlag, boolean deleteFlag, boolean updateFlag,
			ArrayList<UserBean> userList, int allPage, int currentPage, int dataCount, String elsePageQuery,String pageNo) {
		

		System.out.println("&&&&---"+conditionSql);
		System.out.println("&&&&---"+conditionList.size());
		//��һҳ�����һҳ����һҳ����һҳ���в�ѯ�û�
		if("firstpagequery".equals(elsePageQuery)){
			
			pageQueryFlag = true;
			UserDao userDao3 = (UserDao) DaoFactory.getInstance("dbDao.UserDao");
			userList = userDao3.ConditionPageQueryUser(conditionSql,conditionList,1, dataCount);
			currentPage = 1;
			
		}else if("endpagequery".equals(elsePageQuery)){
			
			pageQueryFlag = true;
			UserDao userDao3 = (UserDao) DaoFactory.getInstance("dbDao.UserDao");
			userList = userDao3.ConditionPageQueryUser(conditionSql,conditionList,allPage, dataCount);
			currentPage = allPage;
			
		}else if("lastpagequery".equals(elsePageQuery)){
			
			pageQueryFlag = true;
			if(1<currentPage){
				UserDao userDao3 = (UserDao) DaoFactory.getInstance("dbDao.UserDao");
				currentPage--;
				userList = userDao3.ConditionPageQueryUser(conditionSql,conditionList,currentPage, dataCount);
			}else if(1==currentPage){
				System.out.println("��ǰҳ---"+currentPage);
				UserDao userDao3 = (UserDao) DaoFactory.getInstance("dbDao.UserDao");
				userList = userDao3.ConditionPageQueryUser(conditionSql,conditionList,currentPage, dataCount);
				currentPage=1;
			}
			
		}else if("nextpagequery".equals(elsePageQuery)){
			System.out.println("Jinru^^^");
			pageQueryFlag = true;
			if(allPage>currentPage){
				System.out.println("��ǰҳ---"+currentPage);
				UserDao userDao3 = (UserDao) DaoFactory.getInstance("dbDao.UserDao");
				currentPage++;
				userList = userDao3.ConditionPageQueryUser(conditionSql,conditionList,currentPage, dataCount);
			}else if(allPage==currentPage){
				System.out.println("��ǰҳ---"+currentPage);
				//pageQueryFlag = true;
				UserDao userDao3 = (UserDao) DaoFactory.getInstance("dbDao.UserDao");
				userList = userDao3.ConditionPageQueryUser(conditionSql,conditionList,currentPage, dataCount);
				currentPage=allPage;
			}
		}
		
		//��ѯ�����ҳ���������в�ѯ�û�����
		if(!"".equals(pageNo) && null!=pageNo){
			System.out.println("---"+pageNo+"---");
			System.out.println("输入页数");
			int inputPageNo= Integer.valueOf(pageNo).intValue();
			pageQueryFlag = true;
			currentPage = inputPageNo;
			UserDao userDao3 = (UserDao) DaoFactory.getInstance("dbDao.UserDao");
			System.out.println("��תҳ��---" + inputPageNo);
			userList = userDao3.ConditionPageQueryUser(conditionSql,conditionList,inputPageNo, dataCount);

		}
		System.out.println("===="+conditionData.size());
		System.out.println("(((((("+userList.size());
		
		PageQueryBean pageQueryBean=Reflash(conditionData,conditionSql,conditionList,uId, pageQueryFlag, deleteFlag, updateFlag, userList, allPage, currentPage, dataCount, elsePageQuery);
		
		return pageQueryBean;
	}

	@Override
	public PageQueryBean Reflash(ArrayList<String> conditionData, StringBuffer conditionSql, ArrayList<Object> conditionList,
			int uId, boolean pageQueryFlag, boolean deleteFlag, boolean updateFlag, ArrayList<UserBean> userList,
			int allPage, int currentPage, int dataCount, String elsePageQuery) {
		// TODO Auto-generated method stub
		if(pageQueryFlag){
			
		}else{
			//��ѯ��ҳ��
			allPage=QueryUserListAllPage(conditionSql,conditionList,userList, allPage,currentPage, dataCount);
			//��������ˣ�ɾ�����޸Ĳ�����ҳ���ı仯
			//����ɾ��������ҳ����ʾ�ڵ�ǰ����ҳ�����պ����һҳɾ���û�ˣ���ҳ���ı� -1��
			if(deleteFlag){

				UserDao userDao = (UserDao) DaoFactory.getInstance("dbDao.UserDao");
				
				if(currentPage>allPage && allPage>=1){
					currentPage--;
					userList = userDao.ConditionPageQueryUser(conditionSql,conditionList,currentPage, dataCount);
				}else if(1==allPage && 1==currentPage){
					userList = userDao.ConditionPageQueryUser(conditionSql,conditionList,1, dataCount);
				}else{
					userList = userDao.ConditionPageQueryUser(conditionSql,conditionList,currentPage, dataCount);
				}
			//�������޸Ĳ�����ҳ����ʾ�ڵ�ǰ����ҳ
			}else if(updateFlag){
				
				UserDao userDao = (UserDao) DaoFactory.getInstance("dbDao.UserDao");
				userList = userDao.ConditionPageQueryUser(conditionSql,conditionList,currentPage, dataCount);
				
			}else{
				// �����з�ҳ�����Լ���ɾ�����޸Ĳ�����Ĭ����ʾ��һҳ������һ��ʼ���롰ά����Ա��Ϣ�б���
				UserDao userDao = (UserDao) DaoFactory.getInstance("dbDao.UserDao");
				userList = userDao.ConditionPageQueryUser(conditionSql,conditionList,1, dataCount);
				currentPage=1;
			}
		}
		
		//����ҳ��ġ���š����� ����uid����number ��ת����ҳ��
		int number = (currentPage-1)*dataCount+1;
		
		//将状态的名称加入到 user中 ，为了列表状态名称的显示
		//int cunrrentPage, int number, int allPage, ArrayList<UserBean> userList
		PageQueryBean pageQueryBean = new PageQueryBean(currentPage,number,allPage,userList);

		System.out.println("list)))--"+userList.size());
		
		return pageQueryBean;
	}

//	@Override
//	public List getUserAll(int pageNo) {
//		// TODO Auto-generated method stub
//		//(int userId, String userName, String userPsw, String uSex, String education) {
//		List ulist = new ArrayList<UserBean>();
////		UserBean u1 = new UserBean(1,"aaa123","123","男","本科");
////		UserBean u2 = new UserBean(2,"bbb123","123","女","高中");
////		UserBean u3 = new UserBean(3,"ccc123","123","男","硕士");
////		UserBean u4 = new UserBean(4,"ddd123","123","女 ","本科");
////		ulist.add(u1);
////		ulist.add(u2);
////		ulist.add(u3);
////		ulist.add(u4);
//		
//		return ulist;
//	}

}
