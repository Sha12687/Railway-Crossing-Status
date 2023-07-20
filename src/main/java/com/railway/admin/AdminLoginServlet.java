package com.railway.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.railway.entity.CrossingStation;
import com.railway.entity.User;
import com.railway.service.UserSrevice;

/**
 * Servlet implementation class AdminLoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        System.out.println(username+password);
	        boolean  flag= UserSrevice.LoginValidationAdmin(username, password);
	        if (flag==true) {
	        	 Admin admin = UserSrevice.getUserByAdminName(username, password);
	             HttpSession session = request.getSession();
	             session.setAttribute("loggedInAdmin", admin);
	        	  List<CrossingStation> Stations = UserSrevice.allStations();
	        	  request.setAttribute("Stations", Stations);
	        	  request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
	        }
	        else {
	        request.setAttribute("errorMessage", "Invalid username or password");
	        request.getRequestDispatcher("Admin.jsp").forward(request, response);
	        }
	}

}
