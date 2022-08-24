package com.codewithkrish.newmobile.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codewithkrish.newmobile.model.User;
import com.codewithkrish.newmobile.service.UserService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("all")) {
			getAllUsers(request,response);
		}
		else {
			getSpecificUsers(request,response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		String action = request.getParameter("action");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa"+action);
		if(action.equals("add")) {
			addUser(request,response);
		}
		else if(action.equals("update")) 
		{
			updateUser(request,response);
		}
		else if(action.equals("delete")) 
		{
			deleteUser(request,response);
		}
	}
	
	private void getAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		String message ="";
		UserService service = new UserService();
		try {
			List<User> users = service.getAllUsers();
			
			if(users.isEmpty()){
				message = "There is no any user to show";
			}
			
			request.setAttribute("userList", users);
		    
		} catch (ClassNotFoundException | SQLException e) {
			message =e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("mobile-user-jstl.jsp");
		rd.forward(request, response);
	}
	
   private void getSpecificUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   String message = "";
	   UserService service = new UserService();
	   int userID = Integer.parseInt(request.getParameter("userID"));
	   
	   User user= new User();
	   try {
		    user = service.getSpecifiUserByUserId(userID);
		    if(user.getUserName().isEmpty() ) {
		    	message = "There is no any user under User Id:" +userID;
		    }
	   } catch (ClassNotFoundException | SQLException e) {
		   message = e.getMessage();
	   }
	   
	    request.setAttribute("message", message);
	    request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("search-edit.jsp");
		rd.forward(request, response);
	   
	}

   private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	   String message = "";
	   UserService service = new UserService();
	   
	   User user= new User();
	   user.setUserName(request.getParameter("name"));
	   user.setAddress(request.getParameter("address"));
	   user.setContactNo(request.getParameter("contactNo"));
	   user.setBranchNo(request.getParameter("branchNo"));
	   user.setUserPassword(request.getParameter("userPassword"));
	   user.setRoleID(Integer.parseInt(request.getParameter("roleID")));
	   try {
		boolean result = service.addUser(user);
		 if(result) {
			message = "This user has been added successfully! User Name:" + user.getUserName();
		 }
		 else {
			 message = "Failed to add the user! User Name:" + user.getUserName();
		 }
	   } catch (ClassNotFoundException | SQLException e) {
		   message = e.getMessage();
	   }
	   
	   request.setAttribute("message", message);	
		RequestDispatcher rd = request.getRequestDispatcher("add-user.jsp");
		rd.forward(request, response);
	   
   }
   
   private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	   String message = "";
	   UserService service = new UserService();
	   
	   User user= new User();
	   user.setUserID(Integer.parseInt(request.getParameter("userID")));
	   user.setUserName(request.getParameter("userName"));
	   user.setAddress(request.getParameter("address"));
	   user.setContactNo(request.getParameter("contactNo"));
	   user.setBranchNo(request.getParameter("branchNo"));
	   user.setUserPassword(request.getParameter("userPassword"));
	   user.setRoleID(Integer.parseInt(request.getParameter("roleID")));
	   
	   try {
		 boolean result = service.updateUser(user);
	     if(result) {
			message = "The user has been updated successfully! User ID:" + user.getUserID();
		 }
	     else {
	    	 message = "Failed to update the user! User ID:" + user.getUserID(); 
	     }
	   } 
	   catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
	   }
		   
	   request.setAttribute("message", message);	
	   RequestDispatcher rd = request.getRequestDispatcher("search-edit.jsp");
	   rd.forward(request, response);
   }
   
   private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
	   
	   String message = "";
	   int userID =Integer.parseInt(request.getParameter("userID"));
	   UserService service = new UserService();
	   try {
		service.deleteUser(userID);
	   } catch (ClassNotFoundException | SQLException e) {
		   message = e.getMessage();
	   }
	   
	   HttpSession session = request.getSession();
	   session.setAttribute("deleteMessage", message);
	   
	   response.sendRedirect("/new-mobile/getUsers?action=all");
   }
   
   
   
}
