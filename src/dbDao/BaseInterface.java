
package dbDao;

import java.util.ArrayList;


public interface BaseInterface {
// 正式测试 3333
// 分支X测试  添加 1111
	public boolean Insert(String sql, Object[] arr);

	public boolean Delete(String sql, Object[] arr);

	public boolean Update(String sql, Object[] arr);

	public ArrayList<Object> Query(String sql, Object[] arr);

}
