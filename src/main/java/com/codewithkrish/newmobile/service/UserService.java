package com.codewithkrish.newmobile.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithkrish.newmobile.dao.UserManager;
import com.codewithkrish.newmobile.model.User;



public class UserService {

	public  User getSpecifiUserByUserId(int userID) throws ClassNotFoundException, SQLException {
		
		return UserManager.getTheUserByUserId(userID);
	}
	
	public  List<User> getAllUsers() throws ClassNotFoundException, SQLException{
		
		return UserManager.getAllUsers();
	}
	
	public  boolean addUser(User user) throws ClassNotFoundException, SQLException {
		
		return UserManager.addUser(user);
	}
	
	public  boolean updateUser(User user) throws ClassNotFoundException, SQLException {
		
		return UserManager.updateUser(user);
	}
	
	public  boolean deleteUser(int userID) throws ClassNotFoundException, SQLException {
		
		return UserManager.deleteUser(userID);
	}
}
