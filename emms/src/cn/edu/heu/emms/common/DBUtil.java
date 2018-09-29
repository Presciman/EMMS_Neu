package cn.edu.heu.emms.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	
	private static String  driverClass =null;
	private static String  dbUrl =null;
	private static String  userName=null;
	private static String  userPwd = null;
       
	static {
		Properties p = new Properties();
		try {
			p.load(DBUtil.class.getResourceAsStream("db.properties"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		driverClass = p.getProperty("driver");
		dbUrl  = p.getProperty("url");
		userName = p.getProperty("username");
		userPwd = p.getProperty("password");
		
		//加载驱动
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	
	//获取链接
	public static Connection getConnection(){
		Connection con = null;
		try {
			con  = DriverManager.getConnection(dbUrl,userName,userPwd);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
	}
	
	//关闭资源
	
	public static void closeResource(ResultSet rs, Statement st, Connection con){
		
		try {
			rs.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		try {
			st.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public static void closeResource( Statement st, Connection con){
		
		
		try {
			st.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
}
