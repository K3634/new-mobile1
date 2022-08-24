package com.codewithkrish.newmobile.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.codewithkrish.newmobile.model.Salesagents;
import com.codewithkrish.newmobile.service.SalesagentService;

/**
 * Servlet implementation class AddToSalesagentServlet
 */
public class AddToSalesagentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
		
		if(action.equals("insertsalesagent")) {
			addSalesagent(request,response);
		}
	}

	private void addSalesagent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String message = "";
		   SalesagentService service = new SalesagentService();
		   
		   Salesagents salesagent= new Salesagents();
		   salesagent.setsName(request.getParameter("sName"));
		   salesagent.setsAddress(request.getParameter("sAddress"));
		   salesagent.setMobileNo(request.getParameter("mobileNo"));
		   salesagent.setBranch(request.getParameter("branch"));
		   
		  
		   try {
			boolean result = service.addSalesagent(salesagent);
			 if(result) {
				message = "This user has been added successfully! Salesagent Name:" + salesagent.getsName();
			 }
			 else {
				 message = "Failed to add the user! Salesagent Name:" + salesagent.getsName();
			 }
		   } catch (ClassNotFoundException | SQLException e) {
			   message = e.getMessage();
		   }
		   
		   request.setAttribute("message", message);	
			RequestDispatcher rd = request.getRequestDispatcher("add-salesagent.jsp");
			rd.forward(request, response);
		
	}

}
