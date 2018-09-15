package org.great.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseHepler {

	public static Connection connection = null;
	public static Properties properties;
	private static String url;
	private static String user;
	private static String psw;
	
	static{
		properties=new Properties();
	}
	
	// ���ݿ�����
	public static Connection getConn() {
		
		try {
			
			properties.load(new FileReader("D:/Eclipse/eclipse/Workspace/AunctionSystemServe/src/database/config.properties"));
			Class.forName(properties.getProperty("ClassName"));
			
			url=properties.getProperty("Url");
			user=properties.getProperty("User");
			psw=properties.getProperty("Psw");
			
			connection = DriverManager.getConnection(url, user, psw);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;

	}

	// �ر���Դ
	public static void closeConn(ResultSet rs, PreparedStatement pstm, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("���ӳ�&&&---"+DataBaseHepler.getConn());
	}
}
