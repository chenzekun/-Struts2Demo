
package dbDao;

import java.util.ArrayList;


public interface BaseInterface {
	//测试22222222  git
	public boolean Insert(String sql, Object[] arr);

	public boolean Delete(String sql, Object[] arr);

	public boolean Update(String sql, Object[] arr);

	public ArrayList<Object> Query(String sql, Object[] arr);

}
