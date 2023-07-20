package com.railway;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.railway.entity.CrossingStation;
import com.railway.entity.FavoriteStation;
import com.railway.entity.User;
import com.railway.service.UserSrevice;

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        boolean  flag= UserSrevice.LoginValidation(username, password);
	        if (flag==true) {
	        	 User user = UserSrevice.getUserByuserName(username,password);
	             HttpSession session = request.getSession();
	             session.setAttribute("loggedInUser", user);
	        	  List<CrossingStation> Stations = UserSrevice.allStations();
	        	  request.setAttribute("Stations", Stations);
	        	  request.getRequestDispatcher("Home.jsp").forward(request, response);
	        }
	        else {
	        request.setAttribute("errorMessage", "Invalid username or password");
	        request.getRequestDispatcher("login.jsp").forward(request, response);
	        }
		
	}
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			   HttpSession session = request.getSession(false);
		        if (session != null) {
		        	 User loggedInUser = (User) session.getAttribute("loggedInUser");
			            if (loggedInUser != null) {
			                // Retrieve the user's ID or unique identifie

			                // Fetch the favorite stations for the user from the database
			                List<CrossingStation> crossingStation = UserSrevice.allStations();

			                // Set the favorite stations as a request attribute getFavoriteStations
			                request.setAttribute("CrossingStation", crossingStation);

			                // Forward the request to the JSP page for displaying favorite stations
				        	  request.setAttribute("Stations",crossingStation );
				        	  request.getRequestDispatcher("Home.jsp").forward(request, response);
			            } else {
			                // User not logged in, redirect to login page
			                response.sendRedirect("login.jsp");
			            }	
		        	
		        }
		        }

}
