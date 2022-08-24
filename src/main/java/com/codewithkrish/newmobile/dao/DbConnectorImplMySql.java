package com.codewithkrish.newmobile.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectorImplMySql implements DbConnector {

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
       
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/mobileDb";
		String userName ="root";
		String password ="krish";
		return DriverManager.getConnection(url, userName, password);
	}

	
}
