<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="Myerror.jsp" %>    
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	</head>
<body>
<%
String login = (String)request.getAttribute("login");


if(login!=null){
%>
   <p><%=login %></p>
<%
	}
%>
<centre>
<h1>Admin Login</h1>
<form action = "validate_login.jsp" >
	<label>User Id: </label>
	<input type = "text" name="user_id"><br><br>
	
	<label>Password : </label>
	<input type = "password" name = "pwd"><br><br>

	<button type = "submit" name ="submit">Submit</button>
	<button type = "reset" name = "reset">Reset</button>
</form> 

</centre>
</body>
</html>