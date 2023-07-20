package com.railway.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.railway.entity.CrossingStation;
import com.railway.service.UserSrevice;

/**
 * Servlet implementation class DeleteStationServlet
 */
public class DeleteStationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long stationId = Long.parseLong(request.getParameter("id"));
		 UserSrevice.delete(stationId);
		 List<CrossingStation> Stations = UserSrevice.allStations();
   	  request.setAttribute("Stations", Stations);
   	  request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
	}
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response); // Delegate to doGet() method to handle the delete operation
	    }
}
