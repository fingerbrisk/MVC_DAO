<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="MyError.jsp" %>  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int i=0;
String uid = request.getParameter("user_id");
String pswd = request.getParameter("pwd");

try {
 i = Integer.parseInt(uid);
}
catch(NumberFormatException e) {
	e.printStackTrace();
}

if(i == 1234 && pswd.equals("admin")){
	
	request.setAttribute("login", "Welcome Admin");
	RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
	rd.include(request, response);
}
else{
	request.setAttribute("login", "Login Failed");
	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	rd.include(request, response);
}
%>
</body>
</html>