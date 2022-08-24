<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" />
<title>TechMart</title>
</head>
<body>
  <h1>Welcome to TechMart</h1>
  <br>
  <br>
  <p>${message}</p>
   <p>${deleteMessage}</p>
  <br>
  
  <ul class="nav nav-tabs">
		<li class="nav-item">
		  <a class="nav-link"aria-current="page" href="add-user.jsp">Add User</a>
		</li>
		<li class="nav-item">
		  <a class="nav-link" href="search-edit.jsp">Search/Edit User</a>
		</li>
		<li class="nav-item">
		   <a class="nav-link active" href="#">All Users</a>
		</li>
		
	</ul>
  <br>
 <div class="container">
  <table class="table table-hover">
      <thead>
          <tr>
            <th>User Id</th>
            <th>User Name</th>
            <th>Address</th>
            <th>Account No</th>
            <th>Branch No</th>
            <th>User Password</th>
            <th>Role Id</th>
          </tr>
      </thead>
      
      <tbody>
          <tag:forEach var="user" items="${userList}">
             <tr>
                <td>${user.getUserID()}</td>
                <td>${user.getUserName()}</td>
                <td>${user.getAddress()}</td>
                <td>${user.getContactNo()}</td>
                <td>${user.getBranchNo()}</td>
                <td>${user.getUserPassword()}</td>
                <td>${user.getRoleID()}</td>
                
                <td>
                     <form action="deletUser" method="post">
                         <input type="hidden" name="action" value="delete"/>
                         <input type="hidden" name="userID" value="${user.getUserID()}"/>
                         <button type="submit" class="btn btn-danger">Delete</button>
                     </form>
                </td>
              </tr>  
          </tag:forEach>
      </tbody>
  </table>
 
 </div> 
 
</body>
</html>
