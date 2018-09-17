
package dbDao;

import java.util.ArrayList;


public interface BaseInterface {
// 正式测试 新新新新新 111111111111111
	public boolean Insert(String sql, Object[] arr);

	public boolean Delete(String sql, Object[] arr);

	public boolean Update(String sql, Object[] arr);

	public ArrayList<Object> Query(String sql, Object[] arr);

}
