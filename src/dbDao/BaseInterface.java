
package dbDao;

import java.util.ArrayList;


public interface BaseInterface {
// 分支333333333333333333333333333333333
	public boolean Insert(String sql, Object[] arr);

	public boolean Delete(String sql, Object[] arr);

	public boolean Update(String sql, Object[] arr);

	public ArrayList<Object> Query(String sql, Object[] arr);

}
