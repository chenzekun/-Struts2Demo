
package dbDao;

import java.util.ArrayList;


public interface BaseInterface {
	//测试4444444444444  git
	public boolean Insert(String sql, Object[] arr);

	public boolean Delete(String sql, Object[] arr);

	public boolean Update(String sql, Object[] arr);

	public ArrayList<Object> Query(String sql, Object[] arr);

}
