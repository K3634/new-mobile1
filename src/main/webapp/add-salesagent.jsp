<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TechMart</title><meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" />
<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body> <br>
     <p>${message}</p>
  <br><ul class="nav nav-tabs">
		<li class="nav-item">
		  <a class="nav-link active"aria-current="page" href="#">Insert SalesAgent</a>
		
		<li class="nav-item">
		   <a class="nav-link" href="Admin.jsp">back to Admin page</a>
		</li>
		
	</ul>
<br>
   <div class="container">

		<form method="post" action="add-to-salesagent">
			<div class="form-group">
				<label for="sName"><i
					class="zmdi zmdi-account material-icons-name"></i></label> <input
					type="text" name="sName" id="sName" placeholder=" Name" />
			</div>
			<div class="form-group">
				<label for="sAddress"><i class="zmdi zmdi-home"></i></label> <input
					type="text" id="sAddress" name="sAddress" placeholder="Address" />
			</div>

			<div class="form-group">
				<label for="mobileNo"><i class="zmdi zmdi-phone"></i></label> <input
					type="text" id="mobileNo" name="mobileNo"
					placeholder="Mobile Number" />
			</div>

			<div class="form-group">
				<label for="branch"><i class="zmdi zmdi"></i></label> <input
					type="text" id="branch" name="branch"
					placeholder="Branch Number" />
			</div>

			
			<div class="form-group form-button">
				<input type="submit" name="signup" id="signup" class="form-submit"
					value="Insert" />
			</div>
			<input type="hidden" name="action" value="insertsalesagent" /> <br>
		</form>
	</div>
</body>
</html>