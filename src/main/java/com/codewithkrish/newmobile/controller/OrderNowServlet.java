package com.codewithkrish.newmobile.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.*;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.codewithkrish.newmobile.model.Order;
import com.codewithkrish.newmobile.service.OrderService;


/**
 * Servlet implementation class OrderNowServlet
 */
public class OrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("aweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+action);
		if(action.equals("addOrder")) {
			insertOrder(request,response);
		}
	}
	
  private void insertOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String message = "";
	    OrderService service1 = new OrderService();
	    
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        String productId = request.getParameter("id");
		int productQuantity = Integer.parseInt(request.getParameter("quantity"));
		if(productQuantity <=0) {
			productQuantity = 1;
		}
        
	    Order orderModel = new Order();
		orderModel.setId(Integer.parseInt(productId));
		orderModel.setQuantity(productQuantity);
        orderModel.setDate(formatter.format(date));
        
        try {
    		boolean result = service1.insertOrder(orderModel);
    		 if(result) {
    			message = "This Order has been added successfully! " ;
    		 }
    		 else {
    			 message = "Failed to add the order! " ;
    		 }
    	   } catch (ClassNotFoundException | SQLException e) {
    		   message = e.getMessage();
    	   }
    	   
    	    request.setAttribute("message", message);	
    		RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
    		rd.forward(request, response);

  }
}
