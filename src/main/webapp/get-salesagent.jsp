

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
 <p>${message}</p>
   <p>${deleteMessage}</p>
  <br> 
 
 <ul class="nav nav-tabs">
		<li class="nav-item">
		  <a class="nav-link active"aria-current="page" href="#">View Salesagent</a>
		
		<li class="nav-item">
		   <a class="nav-link" href="Admin.jsp">back to Admin page</a>
		</li>
		
	</ul>

  <br> 
 <h1>Welcome to TechMart</h1>
  <br>
  
  <br>
  <table>
      <thead>
         <tr>
            <th>s Id</th>
            <th>s Name</th>
            <th>Address</th>
            <th>Mobile No</th>
            <th>Branch </th>
            
         </tr>
      </thead>
      
        <tbody>
          <tag:forEach var="salesagent" items="${salesagentList}">
             <tr>
                <td>${salesagent.getsId()}</td>
                <td>${salesagent.getsName()}</td>
                <td>${salesagent.getsAddress()}</td>
                <td>${salesagent.getMobileNo()}</td>
                <td>${salesagent.getBranch()}</td>
                
                
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
	
 
</body>
</html>