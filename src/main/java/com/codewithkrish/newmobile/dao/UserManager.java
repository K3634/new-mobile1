package com.codewithkrish.newmobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithkrish.newmobile.model.User;



public class UserManager {

	public static User getTheUserByUserId(int userID) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection =connector.getConnection();
		
		//String query ="Select * from users where userID = " + userID ;
		//Statement st = connection.createStatement();
		//ResultSet rs = st.executeQuery(query);
		
		String query ="Select * from users where userID = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, userID);
		
		ResultSet rs = ps.executeQuery();
		
		User user = new User();;
		if(rs.next()) {
			 
			user.setUserID(rs.getInt("userID"));
			user.setUserName(rs.getString("userName"));
			user.setAddress(rs.getString("address"));
			user.setContactNo(rs.getString("contactNo"));
			user.setBranchNo(rs.getString("branchNo"));
			user.setUserPassword(rs.getString("userPassword"));
			user.setRoleID(rs.getInt("roleID"));
		}
		
		ps.close();
		connection.close();
		return user;
	}
	
	public static List<User> getAllUsers() throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection =connector.getConnection();
		
		String query = "Select * from users";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<User> users = new ArrayList();
		
		while(rs.next()) {
			User user = new User(rs.getInt("userID"), rs.getString("userName"),rs.getString("address"),rs.getString("contactNo"),rs.getString("branchNo"),rs.getString("userPassword"),rs.getInt("roleID"));
			users.add(user);
		}
		
		st.close();
		connection.close();
		return users;
	}
	
	public static boolean addUser(User user) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection =connector.getConnection();
		
		String query = "Insert into users (userName,address,contactNo,branchNo,userPassword,roleID) values (?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getAddress());
		ps.setString(3, user.getContactNo());
		ps.setString(4, user.getBranchNo());
		ps.setString(5, user.getUserPassword());
		ps.setInt(6, user.getRoleID());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	} 
	
	public static boolean updateUser(User user) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection =connector.getConnection();
		
		String query = "Update users set userName=?, address=?, contactNo=?, branchNo=?, userPassword=?, roleID=? where userID=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getAddress());
		ps.setString(3, user.getContactNo());
		ps.setString(4, user.getBranchNo());
		ps.setString(5, user.getUserPassword());
		ps.setInt(6, user.getRoleID());
		ps.setInt(7, user.getUserID());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}
	
	public static boolean deleteUser(int userID) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection =connector.getConnection();
		
	    String query ="Delete from users where userID=?";
		PreparedStatement ps = connection.prepareStatement(query);
	    ps.setInt(1, userID);
	    
	    boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		return result;
	}
	
	
}
