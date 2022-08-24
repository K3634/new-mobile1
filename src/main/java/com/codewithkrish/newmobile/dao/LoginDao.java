package com.codewithkrish.newmobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.codewithkrish.newmobile.model.User;


public class LoginDao {

 public static User authenticateUser(User user) throws ClassNotFoundException, SQLException {
	    String userName = user.getUserName();
		String password = user.getUserPassword();
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection =connector.getConnection();
//		PreparedStatement pp=null;
		String query ="select userName,userPassword,roleID from users where userPassword = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, password);
		
//		statement = connection.createStatement();
//		resultSet = statement.executeQuery("select userName,userPassword,roleID from users where userPassword = " + password);
		
		ResultSet rs = ps.executeQuery();
		User user1 = new User();

		if(rs.next()) {
			 
			user1.setUserName(rs.getString("userName"));
			user1.setUserPassword(rs.getString("userPassword"));
			user1.setRoleID(rs.getInt("roleID"));
			
		}
		ps.close();
		connection.close();
		return user1;
	}
}