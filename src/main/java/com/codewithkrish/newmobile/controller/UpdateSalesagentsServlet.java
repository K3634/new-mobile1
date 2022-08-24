package com.codewithkrish.newmobile.controller;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithkrish.newmobile.model.Salesagents;
import com.codewithkrish.newmobile.model.User;
import com.codewithkrish.newmobile.service.SalesagentService;
import com.codewithkrish.newmobile.service.UserService;

/**
 * Servlet implementation class UpdateSalesagentServlet
 */
public class UpdateSalesagentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSalesagentsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action.equals("update")) 
		{
			updateSalesagent(request,response);
		}
	}
	
	private void updateSalesagent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		   String message = "";
		   SalesagentService service = new SalesagentService();
		   
		   Salesagents salesagent= new Salesagents();
		   salesagent.setsId(Integer.parseInt(request.getParameter("sId")));
		   salesagent.setsName(request.getParameter("sName"));
		   salesagent.setsAddress(request.getParameter("sAddress"));
		   salesagent.setMobileNo(request.getParameter("mobileNo"));
		   salesagent.setBranch(request.getParameter("branch")); 
		   
		   try {
			 boolean result = service.updateSalesagent(salesagent);
		     if(result) {
				message = "The user has been updated successfully! s ID:" + salesagent.getsId();
			 }
		     else {
		    	 message = "Failed to update the user! s ID:" + salesagent.getsId(); 
		     }
		   } 
		   catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
		   }
			   
		   request.setAttribute("message", message);	
		   RequestDispatcher rd = request.getRequestDispatcher("update-salesagent.jsp");
		   rd.forward(request, response);
	   }

}
