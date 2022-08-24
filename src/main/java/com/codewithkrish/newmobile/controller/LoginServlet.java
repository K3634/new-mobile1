package com.codewithkrish.newmobile.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codewithkrish.newmobile.dao.LoginDao;
import com.codewithkrish.newmobile.model.User;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User();

		user.setUserName(userName);
		user.setUserPassword(password);

		LoginDao loginDao = new LoginDao();

		try
		{
			User userValidate = loginDao.authenticateUser(user);
            
			if(userValidate.getRoleID()==1)
			{
				System.out.println("User's Home");

				HttpSession session = request.getSession();
				
				session.setAttribute("User", userName);
				request.setAttribute("userName", userName);

				request.getRequestDispatcher("User.jsp").forward(request, response);
			}
			else if(userValidate.getRoleID()==2)
			{
				System.out.println("Admin's Home");

				HttpSession session = request.getSession(); //Creating a session
				session.setAttribute("Admin", userName); //setting session attribute
				request.setAttribute("userName", userName);

				request.getRequestDispatcher("Admin.jsp").forward(request, response);
			}
			
			
			else if(userValidate.getRoleID()==3)
			{
				System.out.println("SalesAgent's Home");

				HttpSession session = request.getSession();
				session.setAttribute("SalesAgent", userName);
				request.setAttribute("userName", userName);

				request.getRequestDispatcher("SalesAgent.jsp").forward(request, response);
			}
			
			else if(userValidate.getRoleID()==4)
			{
				System.out.println("Supplier's Home");

				HttpSession session = request.getSession();
				session.setAttribute("Supplier", userName);
				request.setAttribute("userName", userName);

				request.getRequestDispatcher("SalesAgent.jsp").forward(request, response);
			}
			else
			{
				System.out.println("Error message = "+userValidate);
				request.setAttribute("errMessage", userValidate);

				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		catch (Exception e2)
		{
			e2.printStackTrace();
		}
	} //End of doPost()
	

}
