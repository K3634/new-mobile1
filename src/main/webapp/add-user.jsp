<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" />

<title>TechMart</title>
<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">

</head>
<body>


  <br>
     <p>${message}</p>
  <br>
	<ul class="nav nav-tabs">
		<li class="nav-item">
		  <a class="nav-link active"aria-current="page" href="#">Register Form</a>
		
		<li class="nav-item">
		   <a class="nav-link" href="login.jsp">Logout</a>
		</li>
		
	</ul>

<br>
<div class="container">
     
     <form method="post" action="addUser"  >
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> 
									<input type="text" name="name" id="name" placeholder="Your Name" required="required"/>
							</div>
							<div class="form-group">
								<label for="address"><i class="zmdi zmdi-home"></i></label> 
								<input type="text" id="address" name="address" placeholder="Address" required="required" />
							</div>
							
							<div class="form-group">
								<label for="contactNo"><i class="zmdi zmdi-phone"></i></label> 
								<input type="text" id="contactNo" name="contactNo" placeholder="Contact Number" />
							</div>
							
							<div class="form-group">
								<label for="branchNo"><i class="zmdi zmdi-home"></i></label>
								<input type="text" id="branchNo" name="branchNo" placeholder="Branch" />
							</div>
							
							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock"></i></label> 
								<input type="text" id="userPassword" name="userPassword" placeholder="Password" />
							</div>
							<div class="form-group">
								<label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="password" name="re_pass" id="re_pass" placeholder="Repeat your password" />
							</div>
							<div class="form-group">
								<label for="roleID"><i class="fa fa-id-badge"></i></label>
								<input type="number" id="roleID" name="roleID" placeholder="Role Id" />
							</div>
							<div class="form-group">
								<input type="checkbox" name="agree-term" id="agree-term"
									class="agree-term" /> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>I
									agree all statements in <a href="#" class="term-service">Terms
										of service</a></label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
							 <input type="hidden" name="action" value="add"/>
        <br>
						</form>
</div>

<%@include file="/includes/footer.jsp"%>
</body>
</html>