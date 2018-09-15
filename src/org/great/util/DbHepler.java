package org.great.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbHepler {
	
	private static Connection connection;
	private static ComboPooledDataSource source;
	
	static{
		source = new ComboPooledDataSource("myc3p0");
	}
	
	public static synchronized Connection getConn(){
		try {
			
			connection = source.getConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void closeConnection(Connection conn){
		try {
			if(null != conn ){
				conn.close();
				//���ӷ��ص���
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public static QueryRunner getQueryRunner() {
		
		return new QueryRunner(source);
	}
}
