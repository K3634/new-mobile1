package com.codewithkrish.newmobile.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithkrish.newmobile.model.*;
import com.codewithkrish.newmobile.model.User;

/**
 * Servlet implementation class CheckOutServlet
 */
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
			
            ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
            User auth= (User)request.getSession().getAttribute("auth");
            
            if(cart_list !=null && auth !=null) {
            	
            	for(Cart c:cart_list) {
            		Order order = new Order();
            		order.setId(c.getId());
            		//order.setUid(auth.getUserID());
            		order.setQuantity(c.getQuantity());
            		order.setDate(formatter.format(date));
            	}
            }else {
            	if(auth == null) response.sendRedirect("login.jsp");
            	response.sendRedirect("cart.jsp");
            }
            
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
