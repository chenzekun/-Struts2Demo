
package dbDao;

import java.util.ArrayList;


public interface BaseInterface {
<<<<<<< HEAD
	//测试5555555555  git
=======
	//测试3333333333333333  git
>>>>>>> branch 'master' of https://github.com/chenzekun/-Struts2Demo
	public boolean Insert(String sql, Object[] arr);

	public boolean Delete(String sql, Object[] arr);

	public boolean Update(String sql, Object[] arr);

	public ArrayList<Object> Query(String sql, Object[] arr);

}
