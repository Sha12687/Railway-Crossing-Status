package com.railway;

import java.io.IOException;
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
 * Servlet implementation class FavoriteStationsServlet
 */
public class FavoriteStationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriteStationsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		   HttpSession session = request.getSession(false);
	        if (session != null) {
	            User loggedInUser = (User) session.getAttribute("loggedInUser");
	            if (loggedInUser != null) {
	                // Retrieve the user's ID or unique identifier
	                long userId = loggedInUser.getId();

	                // Fetch the favorite stations for the user from the database
	                List<FavoriteStation> favoriteStations = UserSrevice.getFavoriteStations(userId);

	                // Set the favorite stations as a request attribute getFavoriteStations
	                request.setAttribute("favoriteStations", favoriteStations);

	                // Forward the request to the JSP page for displaying favorite stations
	                List<FavoriteStation> Stations = UserSrevice.getFavoriteStations(userId);
		        	  request.setAttribute("Stations", Stations);
		        	  request.getRequestDispatcher("FavrtiePage.jsp").forward(request, response);
	            } else {
	                // User not logged in, redirect to login page
	                response.sendRedirect("login.jsp");
	            }
	        } else {
	            // Session expired or not available, redirect to login page
	            response.sendRedirect("login.jsp");
	        } 
	}
}
