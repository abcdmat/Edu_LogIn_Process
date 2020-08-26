package com.edu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Casino_DB {
	public Casino_DB() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "sqld";
		String pw = "sqld";
	
		conn = DriverManager.getConnection(url, user, pw);
		
		return conn;
	}
	
	public void closed(Connection conn, PreparedStatement stmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}if(stmt != null) {
				stmt.close();
			}if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
