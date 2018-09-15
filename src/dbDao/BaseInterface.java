
package dbDao;

import java.util.ArrayList;


public interface BaseInterface {
//444444444444444
	public boolean Insert(String sql, Object[] arr);

	public boolean Delete(String sql, Object[] arr);

	public boolean Update(String sql, Object[] arr);

	public ArrayList<Object> Query(String sql, Object[] arr);

}
