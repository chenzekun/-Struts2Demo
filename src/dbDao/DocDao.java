package dbDao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.great.bean.DocBean;
import org.great.bean.UserBean;
import org.great.util.MybatisTool;


public class DocDao implements DocInterface{
	private SqlSession session = null;
	@Override
	
	public List<DocBean> QueryDoc() {
		// TODO Auto-generated method stub
//		session = MybatisTool.getSession();
//		//条件
//		
//		//分页
//		//RowBounds rb = new RowBounds(0, 3);
//		
//		List<DocBean> docList = session.selectList("queryAllDoc");
//		
//		session.close();
		
		return null;
	}

	@Override
	public void AddDoc(DocBean docBean) {
		// TODO Auto-generated method stub
		session = MybatisTool.getSession();
		session.insert("addDoc", docBean);
		session.commit();
		session.close();
		System.out.println("插入成功——————");
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
	public UserBean QueryDocX(UserBean userBean) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
