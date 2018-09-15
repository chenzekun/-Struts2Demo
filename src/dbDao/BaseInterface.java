
package dbDao;

import java.util.ArrayList;


public interface BaseInterface {
	//测试3333333333333333  git
	public boolean Insert(String sql, Object[] arr);

	public boolean Delete(String sql, Object[] arr);

	public boolean Update(String sql, Object[] arr);

	public ArrayList<Object> Query(String sql, Object[] arr);

}
