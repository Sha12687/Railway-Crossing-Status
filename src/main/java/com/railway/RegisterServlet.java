package com.railway;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;

import com.railway.dao.HibernateUtil;
import com.railway.entity.User;
import com.railway.service.UserSrevice;


/**
 * Servlet implementation class RegisterServlet
 */

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */

    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println(name +email+password);
		User user=new User();
		user.setUsername(name);
		user.setEmail(email);
		user.setPassword(password);
		UserSrevice.Insert(user);
	        response.getWriter().println("User registered successfully!");
	        request.getRequestDispatcher("login.jsp").forward(request, response);
	}

    @Override
    public void destroy() {
     
    }
}
