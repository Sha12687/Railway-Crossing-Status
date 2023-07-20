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
 * Servlet implementation class AddStationServlet
 */
public class AddStationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name = request.getParameter("name");
	        String personInCharge = request.getParameter("personInCharge");
	        String trainSchedule = request.getParameter("trainSchedule");
	        String landmark = request.getParameter("landmark");
	        String address = request.getParameter("address");
	        boolean crossingStatus = request.getParameter("crossingStatus") != null;
	        CrossingStation crossingStation=new CrossingStation();
	        crossingStation.setName(name);
	        crossingStation.setPersonInCharge(personInCharge);
	        crossingStation.setTrainSchedule(trainSchedule);
	        crossingStation.setLandmark(landmark);
	        crossingStation.setAddress(address);
	        crossingStation.setCrossingStatus(crossingStatus);
	        UserSrevice.save(crossingStation);
	        List<CrossingStation> Stations = UserSrevice.allStations();
      	  request.setAttribute("Stations", Stations);
	        request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
	}

}
