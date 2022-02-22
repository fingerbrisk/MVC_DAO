<%@page import="model.Student"%>
<%@page errorPage="MyError.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action = "StudentServlet" method="post">
<input type = 'hidden' name ="id"  >
<label>Name :</label>
<input type = "text" name = "Name" >
<br><br>
<label>Mobile no : </label>
<input type = "text" name = "mobile_no">
<br><br>
<button type ="submit" name = "Submit" >Submit</button>
<button type = "reset" name = "Reset">Reset</button>
</form>
</body>
</html>