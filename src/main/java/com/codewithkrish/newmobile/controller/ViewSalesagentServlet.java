package com.codewithkrish.newmobile.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.codewithkrish.newmobile.controller.ViewSalesagentServlet;
import com.codewithkrish.newmobile.model.Salesagents;
import com.codewithkrish.newmobile.model.User;
import com.codewithkrish.newmobile.service.SalesagentService;
import com.codewithkrish.newmobile.service.UserService;

/**
 * Servlet implementation class ViewSalesagentServlet
 */
public class ViewSalesagentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String action = request.getParameter("action");
		
		if(action.equals("all")) {
			getAllSalesagent(request,response);
		}
		else {
			getSpecificSalesagent(request,response);
		}
	
	}

	private void getSpecificSalesagent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		  String message = "";
		   UserService service = new UserService();
		   int sId= Integer.parseInt(request.getParameter("sId"));
		   
		   User user= new User();
		   try {
			    user = service.getSpecifiUserByUserId(sId);
			    if(user.getUserName().isEmpty() ) {
			    	message = "There is no any user under s Id:" +sId;
			    }
		   } catch (ClassNotFoundException | SQLException e) {
			   message = e.getMessage();
		   }
		   
		    request.setAttribute("message", message);
		    request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("update-salesagent.jsp");
			rd.forward(request, response);
		
	}

	private void getAllSalesagent(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		String message ="";
		SalesagentService service = new SalesagentService();
		try {
			List<Salesagents> salesagents = service.getAllSalesagent();
			
			if(salesagents.isEmpty()){
				message = "There is no any user to show";
			}
			
			request.setAttribute("salesagentList", salesagents);
		    
		} catch (ClassNotFoundException | SQLException e) {
			message =e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("get-salesagent.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
