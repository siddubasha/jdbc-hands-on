package com.jdbcdemo.com.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	private static Connection connection=null;
	public static Connection getDBConnection() {
		if(connection==null) {
		try {
			 connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/softech","root","Siddu@123");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return connection;
	}
}
