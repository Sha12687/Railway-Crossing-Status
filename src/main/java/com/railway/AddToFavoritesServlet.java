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
 * Servlet implementation class AddToFavoritesServlet
 */
public class AddToFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToFavoritesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the selected station ID from the request parameters
    	String name=request.getParameter("stationName");
    	  String crossingStatus = request.getParameter("crossingStatus");
    	    String personInCharge = request.getParameter("personInCharge");
    	    String address = request.getParameter("address");
    	    String time=request.getParameter("time");
    	    String landmakr=request.getParameter("landmark");
    	 FavoriteStation favoriteStation=new FavoriteStation();
    	 favoriteStation.setName(name);
    	 favoriteStation.setCrossingStatus(crossingStatus);
    	 favoriteStation.setPersonInCharge(personInCharge);
    	 favoriteStation.setLandmark(landmakr);
    	 favoriteStation.setAddress(address);
    	 favoriteStation.setTrainSchedule(time);
    	   HttpSession session = request.getSession(false);
    	   if (session != null) {
    	        User loggedInUser = (User) session.getAttribute("loggedInUser");
    	        if (loggedInUser != null) {   
    	            favoriteStation.setUser(loggedInUser);
    	            UserSrevice.addFavorite(favoriteStation);
    	         	  List<CrossingStation> Stations = UserSrevice.allStations();
    	        	  request.setAttribute("Stations", Stations);
    	            request.getRequestDispatcher("Home.jsp").forward(request, response);
    	        } else {
    	        	  response.sendRedirect("login.jsp");
    	        	  
    	        }
    	    } 
    }

}
