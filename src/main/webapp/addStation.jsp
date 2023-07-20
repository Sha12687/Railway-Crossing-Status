<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Add Station</title>
</head>
<body>
<div class="conatiner text-center mt-5">
 <h1>Add Station</h1>

  <form action="AddStationServlet" class="mt-2" method="POST">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br><br>
    <label for="personInCharge">Person in Charge:</label>
    <input type="text" id="personInCharge" name="personInCharge" required><br><br>

    <label for="trainSchedule">Train Schedule:</label>
    <input type="text" id="trainSchedule" name="trainSchedule" required><br><br>

    <label for="landmark">Landmark:</label>
    <input type="text" id="landmark" name="landmark" required><br><br>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" required><br><br>
  <label for="crossingStatus">Crossing Status:</label>
    <input type="checkbox" id="crossingStatus" name="crossingStatus"><br>
    <input type="submit" value="Add Station">
  </form>
  </div>
</body>
</html>