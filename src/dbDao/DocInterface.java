package dbDao;

import java.util.List;

import org.great.bean.DocBean;
import org.great.bean.UserBean;
import org.springframework.stereotype.Repository;

@Repository
public interface DocInterface extends BaseInterface{
	public List<DocBean> QueryDoc();
	public void AddDoc(DocBean docBean);
	
	public UserBean QueryDocX(UserBean userBean);
	
}
