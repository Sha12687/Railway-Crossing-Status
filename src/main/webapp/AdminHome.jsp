<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/scrpit.js"></script>
</head>
<body>
    <div class="container mt-3">
        <h2>Admin Home Page</h2>
        <span class="fs-4">Railway Crossing [3]</span> <br>
        <div class="nav-actions mt-1">
           <a href="#" class="btn btn-light mb-3">Home</a>
        <a href="addStation.jsp" class="btn btn-light mb-3">Add Railway Crossing</a>
           </div>
        <div class="search-bar col-3 mt-1">
			<label>Search Railway Crossing</label>
			 <form class="d-flex">
        <input id="searchInput" class="form-control me-2 border border-primary" type="search" aria-label="Search"><br>
        <button type="button" id="searchButton" class="btn btn-secondary">Search</button>
      </form>
      </div>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Sr. No</th>
                    <th scope="col">Name</th>
                    <th scope="col">Address</th>
                    <th scope="col">Landmark</th>
                    <th scope="col">Train Schedule</th>
                    <th scope="col">Person In-charge</th>
                    <th scope="col">Status</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
          <c:forEach items="${Stations}" var="station"  varStatus="loop" >
            <tr class="station-card">
            <td>${loop.index + 1}</td>
            <td>${station.getName()}</td>
      		<td>${station.getAddress()}</td>
      		<td>${station.getLandmark()}</td>
      		<td>${station.getTrainSchedule() }</td>
      		<td>${station.getPersonInCharge()}</td>
      		<td>${station.getCrossingStatus()}</td>
            <td> <a class="btn btn-secondary" href="#">Edit</a>
             <a class="btn btn-danger" href="DeleteStationServlet?id=${station.getId()}">Delete</a>
            </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>


	