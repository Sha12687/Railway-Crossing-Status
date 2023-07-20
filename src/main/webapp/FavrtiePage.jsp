<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<title>Favorite Crossing</title>
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
<div class="navbar m-2 d-inilne">
		<h2>Favorite Crossing Page</h2>
		<a href="Logout "
			class="me-4 bg-secondary text-white text-decoration-none p-1 ">Logout</a>
	</div>
	<div class="row m-3">
		<div class="option m-2">
			<div class="badge bg-secondary e " style="width: 4rem; padding: 9px">
				<a id="favoriteCrossingLink" href="LoginServlet" class="text-white text-decoration-none">All</a>
			</div>
			<div class="badge bg-secondary e  ms-2"
				style="width: 8rem; padding: 9px">
				<a href="FavoriteStationsServlet" class="text-white text-decoration-none">Favorite
					Crossing</a>
			</div>
			<div class="search-bar col-3 mt-1">
			<label>Search Railway Crossing</label>
			 <form class="d-flex">
        <input id="searchInput" class="form-control me-2 border border-primary" type="search" aria-label="Search"><br>
        <button type="button" id="searchButton" class="btn btn-secondary">Search</button>
      </form>
      </div>
		</div>
	<c:forEach items="${Stations}" var="Station">
  <div class="card station-card" style="border-radius: 1.3rem">
    <div class="train details p-2">
      <form action="AddToFavoritesServlet" method="post">
        <input class="border border-white fw-bold fs-2" name="stationName" value="${Station.getName()}">
        <br>
        <input type="hidden" class="border border-white fw-b text-wrap bg-success e" name="crossingStatus" value="${Station.getCrossingStatus()}">
        <label>Crossing Status:</label>
        <span class="badge ${Station.getCrossingStatus() == 'open' ? 'bg-success' : 'bg-danger'} e">${Station.getCrossingStatus()}</span>
        <br>
        <input type="hidden" class="border border-white fw-bold" name="personInCharge" value="${Station.getPersonInCharge()}">
        <label>Person In-charge:</label>
        <input class="border border-white fw-bold" name="personInCharge" value="${Station.getPersonInCharge()}">
        <br>
        <input type="hidden" class="border border-white fw-bold" name="time" value="${Station.getTrainSchedule()}">
        <label>Train Schedule:</label>
        <input class="border border-white fw-bold" name="time" value="${Station.getTrainSchedule()}">
        <br>
        <input type="hidden" class="border border-white fw-bold" name="landmark" value="${Station.getLandmark()}">
        <label>Landmark:</label>
        <input class="border border-white fw-bold" name="landmark" value="${Station.getLandmark()}">
        <br>
        <input type="hidden" class="border border-white fw-bold" name="address" value="${Station.getAddress()}">
        <label>Schedule:</label>
        <input class="border border-white fw-bold" name="address" value="${Station.getAddress()}">
        <br>
      </form>
    </div>
  </div>
</c:forEach>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

</body>
</html>