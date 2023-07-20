<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Registration Page</title>
  </head>
  <body>
  <div class="container h-100">
  <div class="row ">
    <div class="col-md-12 d-flex flex-column justify-content-center align-items-center min-vh-100">
    <div class="text-center lh-1">
      <h3 class="m-0">Railway Crossing</h3>
      <span class="fw-light">Admin Registration</span>
      </div>
    <form action="AdminRegister" class="mt-3" method="post">
      <div class="form-group">
    <label for="name">Enter Name:</label><br>
    <input class="rounded" type="text" id="name" name="name" required>
    </div>
      <div class="form-group">
    <label for="email"> Enter Email:</label><br>
    <input class="rounded" type="email" id="email" name="email" required>
    </div>
      <div class="form-group">
    <label for="password">Enter Password:</label><br>
    <input class="rounded" type="password" id="password" name="password" required>
    </div>
    <div class="text-center"><br>
    <input class="btn btn-success" type="submit" value="Register">
    </div>
</form>
<div class="mt-1">
<span class="fw-light" >Already have account? <a href="login.jsp">Sign in Instead</a></span>
</div>
</div>
</div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>