<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" />
<title>TechMart</title>
</head>
<body>
   <br>
     <p>${message}</p>
  <br>
	<ul class="nav nav-tabs">
		<li class="nav-item">
		  <a class="nav-link "aria-current="page" href="add-user.jsp">Add User</a>
		</li>
		<li class="nav-item active">
		  <a class="nav-link" href="#">Search/Edit User</a>
		</li>
		<li class="nav-item">
		   <a class="nav-link" href="getUsers?action=all">All Users</a>
		</li>
		
	</ul>

    <br>
    
    <div class="container">
        <h2>Search a user:</h2>
        <br>
        <form action="getUsers" >
           <label for="userID">User Id:</label>
           <input type="number" id="userID" name="userID" class="form-control"/>
           <br>
           <input type="hidden" name="action" value="single"/>
           <button type="submit" class="btn btn-info">Search</button>
        </form>
    </div>
    <br>
    <div class="container">
        <form action="updateUser" method="post">
         <label for="userID">User Id:</label>
         <input type="number"  readonly="readonly" id="userID" name="userID" class="form-control" value="${user.getUserID()}"/>
            
        <label for="userName">Enter User Name:</label>
        <input type="text" id="userName" name="userName" class="form-control" value="${user.getUserName()}">
        <br>
        
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" class="form-control" value="${user.getAddress()}">
        <br>
        
        <label for="contactNo">Contact Number:</label>
        <input type="text" id="contactNo" name="contactNo" class="form-control" value="${user.getContactNo()}">
        <br>
        
        <label for="branchNo">Branch Number:</label>
        <input type="text" id="branchNo" name="branchNo" class="form-control" value="${user.getBranchNo()}">
        <br>
        
        <label for="userPassword">Enter User Password:</label>
        <input type="text" id="userPassword" name="userPassword" class="form-control" value="${user.getUserPassword()}">
        <br>
        
        <label for="roleID">Role Id:</label>
        <input type="number" id="roleID" name="roleID" class="form-control" value="${user.getRoleID()}">
        <br>
        <input type="hidden" name="action" value="update"/>
           <button type="submit" class="btn btn-warning">Update Information</button>
        </form>
    </div>
</body>
</html>