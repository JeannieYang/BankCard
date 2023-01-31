package db;

import java.sql.*;

public class db {
	private Connection dbConn;
	private Statement stateMent;
	public db(){
		//SQL Server 2005(以上) JDBC驱动
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//数据库SQL Server 2005(及以上) URL
		String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Bank";
		String userName = "sa";
		String userPwd = "123456";//密码
		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			//如果连接成功 控制台输出Connection Successful！
			System.out.println("Connection Successful!");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}                                                                                                                                                   	
	}
	
	public int executeUpdate(String sql) throws SQLException{
		stateMent = dbConn.createStatement();
		return stateMent.executeUpdate(sql);
	}
	public ResultSet executeQuery(String sql) throws SQLException{
		stateMent = dbConn.createStatement();
		return stateMent.executeQuery(sql);
	}
	public void closeConn() throws SQLException{
		stateMent.close();
		dbConn.close();
	}
	public PreparedStatement PreparedStatement(String sql) throws SQLException{
		return dbConn.prepareStatement(sql);
	}
} 
