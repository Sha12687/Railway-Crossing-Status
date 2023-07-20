package com.railway.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.railway.service.UserSrevice;

/**
 * Servlet implementation class AdminRegister
 */
public class AdminRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegister() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");

	        // Create a new Admin object
	        Admin admin = new Admin();
	        admin.setName(name);
	        admin.setEmail(email);
	        admin.setPassword(password);
	        UserSrevice.save(admin);
	        System.out.println(admin);
	        response.getWriter().println("Admin registered successfully!");
	        request.getRequestDispatcher("Admin.jsp").forward(request, response);
	}

}
