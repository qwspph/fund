package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	
	private static final String DRIVICE = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/fund?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PWD = "root";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DRIVICE);
			connection = DriverManager.getConnection(URL,USER,PWD);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeALL(Connection connection,Statement statement) {
		if(null != statement) {
			try {
				statement.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(null != connection) {
			try{
				connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection c = getConnection();
		System.out.println(c);
	}

}
