package org.great.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;
import org.great.bean.DocBean;
import org.great.daoFactory.DaoFactory;
import org.great.util.MybatisTool;

import com.opensymphony.xwork2.ActionSupport;

import dbDao.DocDao;
import dbDao.DocInterface;
import dbDao.UserDao;

@SuppressWarnings("serial")
public class UploadAction extends ActionSupport {
	
//	�����ļ��ϴ��͹̶������ļ��ϴ���ֻ����action�����в�ͬ��������
//
//	����file,filename,filecontenttype���ǵ�ֵ�����̶������ļ���������ֵ��Ϊ
//
//	��ֵ�����ɲ���list������ķ�ʽ�����գ�Ȼ��������ϻ���������ļ��˶�д
//
//	�������ɣ���ҳ���ϵļ���file�ؼ���nameҪ��ͬ

	private String username;

	private String password;

	private List<File> myfile; // ��Ӧҳ���file�ؼ���name

	private List<String> myfileFileName; // ��Ӧ�ϴ����ļ�����������ʽ��myfile(��Ӧҳ���ϵ�file�ؼ���name)+FileName���̶���

	private List<String> myfileContentType;// ��Ӧ�ϴ����ļ����ͣ�������ʽ��myfile(��Ӧҳ���ϵ�file�ؼ���name)+ContentType���̶���

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<File> getMyfile() {
		return myfile;
	}

	public void setMyfile(List<File> myfile) {
		this.myfile = myfile;
	}

	public List<String> getMyfileFileName() {
		return myfileFileName;
	}

	public void setMyfileFileName(List<String> myfileFileName) {
		this.myfileFileName = myfileFileName;
	}

	public List<String> getMyfileContentType() {
		return myfileContentType;
	}

	public void setMyfileContentType(List<String> myfileContentType) {
		this.myfileContentType = myfileContentType;
	}

	public String execute() throws Exception {
		
		System.out.println("jinru");
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		for (int i = 0; i < this.getMyfile().size(); i++) {
			
			String docTitle=System.currentTimeMillis()+"@"+this.getMyfileFileName().get(i);

			String docClass=this.getMyfileFileName().get(i).split("\\.")[1];
			
			String docUrl=System.currentTimeMillis()+"@"+this.getMyfileFileName().get(i);
			
			String uploadTime=df.format(day);
			
			InputStream is = new FileInputStream(this.getMyfile().get(i)); // ����������
			
			System.out.println("文件名---"+this.getMyfileFileName().get(i));
			
			System.out.println("路径-111--"+this.getMyfile().get(i));
			
			String root = ServletActionContext.getRequest().getRealPath("/upload"); // �����ļ��ϴ���·��
			
			System.out.println("路径-222--"+root);
			
			File destFile = new File(root, docTitle);// �����ļ�
			// root:�ϴ�·����this.getMyfileFileName():�ϴ������ɵ��ļ���
			
			System.out.println("路径-222--"+destFile.getPath());
			
			OutputStream os = new FileOutputStream(destFile); // ���������

			byte[] buffer = new byte[400]; // ����Ϊ��д�ļ�����

			int length = 0;

			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();

//			private int docId;
//			private int userId;
//			private String docTitle;
//			private String docInfo;
//			private String docClass;
//			private String uploadTime;
//			private int downloadCount;
//			private int downIntegral;
//			private String docUrl;
			//docId, userId, docTitle, docInfo, docClass, uploadTime, downloadCount, downIntegral, docUrl 
			
			//今天的
//			SqlSession session = MybatisTool.getSession();
//			DocInterface docInterface=session.getMapper(DocInterface.class);
//			docInterface.AddDoc(docBean);
			
			DocDao docDao = (DocDao) DaoFactory.getInstance("dbDao.DocDao");
			DocBean docBean= new DocBean(1,docTitle,"info",docClass,uploadTime,0,100,docUrl);
			docDao.AddDoc(docBean);
			
		}

		return "result";
	}
}
