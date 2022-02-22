<%@page import="dao.StudentDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Student StudentObj = (Student)request.getAttribute("Update");
%>
<form class="form-style-4" action = "UpdateServlet2" method = "get">
<fieldset><legend>Edit Student Information</legend ><br>
<input type = "hidden" name = "Uid" value = "<%=StudentObj.getId()%>">
<label>Name : <span class="required"></span>
<input type = "text" name = "UName" value = "<%=StudentObj.getName()%>">
</label><br><br>
<label>Mobile no.: <span class="required"></span>
<input type = "text" name = "Umobile_no" value = "<%=StudentObj.getMob_no()%>"></label><br><br>
<span></span><button type="submit" value="Submit" >Submit</button>
<button type = "reset" name = "submit">Reset</button>
</fieldset>
</form>
</body>
</html>