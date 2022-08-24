<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"><link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body><br>
     <p>${message}</p>
  <br><ul class="nav nav-tabs">
		<li class="nav-item">
		  <a class="nav-link active"aria-current="page" href="#">Update Salesagents</a>
		
		<li class="nav-item">
		   <a class="nav-link" href="Admin.jsp">back to Admin page</a>
		</li>
		
	</ul>
    <br><div class="container">
        <h2>Search a Salesagent:</h2>
        <br>
        <form action="ViewSalesagentServlet" >
           <label for="sId">Salesagent Id:</label>
           <input type="number" id="sId" name="sId" class="form-control"/>
           <br>
           <input type="hidden" name="action" value="single"/>
           <button type="submit" class="btn btn-info">Search</button>
        </form>
    </div>
    <br>
    <div class="container">
        <form action="UpdateSalesagentsServlet" method="post">
         <label for="sId">Salesagent Id:</label>
         <input type="number"  readonly="readonly" id="sId" name="sId" class="form-control" value="${salesagent.getsId()}"/>
            
        <label for="sName">Enter  Name:</label>
        <input type="text" id="sName" name="sName" class="form-control" value="${salesagent.getsName()}">
        <br>
        
        <label for="sAddress">Address:</label>
        <input type="text" id="sAddress" name="sAddress" class="form-control" value="${salesagent.getsAddress()}">
        <br>
        
        <label for="mobileNo">Mobile Number:</label>
        <input type="text" id="mobileNo" name="mobileNo" class="form-control" value="${salesagent.getMobileNo()}">
        <br>
        
        <label for="branch">Branch :</label>
        <input type="text" id="branch" name="branch" class="form-control" value="${salesagent.getBranch()}">
        <br>
        
       
        <br>
        <input type="hidden" name="action" value="update"/>
           <button type="submit" class="btn btn-warning">Update Information</button>
        </form>
    </div>
</body>
</html>