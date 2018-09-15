package org.great.util;

import java.beans.Statement;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConUtil {
	
	public static Connection connection;
	public static Properties properties;
	public static JDBCConUtil connectionutil;
	private static String url;
	private static String user;
	private static String psw;
	
	static{
		properties=new Properties();
	}
	
	private JDBCConUtil(){
			
		try {
			
			properties.load(new FileReader("D:/Eclipse/eclipse/Workspace/AunctionSystemServe/src/database/config.properties"));
			Class.forName(properties.getProperty("ClassName"));
			
			url=properties.getProperty("Url");
			user=properties.getProperty("User");
			psw=properties.getProperty("Psw");
			
			connection=DriverManager.getConnection(url,user,psw);
			
		}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}catch (SQLException e) {
				e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	//����ʽ����
	public static JDBCConUtil getInstance(){
		
		if(connectionutil==null){
			connectionutil=new JDBCConUtil();
		}else{
			try {
				
				connection=DriverManager.getConnection(url,user,psw);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connectionutil;
		
	}

	public static void connClose(ResultSet rs,PreparedStatement preparedStatement,Connection connection){
		try {
			
			if(rs!=null){
				rs.close();
				rs=null;
			}
			if(preparedStatement!=null){
				preparedStatement.close();
				preparedStatement=null;
			}
			if(connection!=null){
				connection.close();
				connection=null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
}
