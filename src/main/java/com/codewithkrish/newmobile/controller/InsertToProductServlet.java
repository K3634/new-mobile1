package com.codewithkrish.newmobile.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithkrish.newmobile.model.Product;
import com.codewithkrish.newmobile.service.ProductService;


/**
 * Servlet implementation class InsertToProductServlet
 */
public class InsertToProductServlet extends HttpServlet {
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
		
		if(action.equals("insert")) {
			addProduct(request,response);
		}
	}
	
	 private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		   String message = "";
		   ProductService service = new ProductService();
		   
		   Product product= new Product();
		   product.setName(request.getParameter("name"));
		   product.setCategory(request.getParameter("category"));
		   product.setPrice(Double.parseDouble(request.getParameter("price")));
		   product.setImage(request.getParameter("image"));
		   
		  
		   try {
			boolean result = service.addProduct(product);
			 if(result) {
				message = "This user has been added successfully! Product Name:" + product.getName();
			 }
			 else {
				 message = "Failed to add the user! User Name:" + product.getName();
			 }
		   } catch (ClassNotFoundException | SQLException e) {
			   message = e.getMessage();
		   }
		   
		   request.setAttribute("message", message);	
			RequestDispatcher rd = request.getRequestDispatcher("insert-product.jsp");
			rd.forward(request, response);
		   
	   }

}
