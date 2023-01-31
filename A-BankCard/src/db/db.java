package db;

import java.sql.*;

public class db {
	private Connection dbConn;
	private Statement stateMent;
	public db(){
		//SQL Server 2005(����) JDBC����
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//���ݿ�SQL Server 2005(������) URL
		String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Bank";
		String userName = "sa";
		String userPwd = "123456";//����
		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			//������ӳɹ� ����̨���Connection Successful��
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
