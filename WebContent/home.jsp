<%@page import="dao.StudentDAO"%>
<%@page import="model.Student"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page errorPage="error.jsp" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>  
        table{  
            border-collapse: collapse;  
            width: 80%;   
        }  
    th,td{  
        border: 3px solid green;   
        padding: 15px;  
    }  
               
    </style> 
</head>
 
<body>
<A href = "Student.jsp">Add Student</A>
<%
String str = (String)request.getAttribute("key");
String str1 = (String)request.getAttribute("del");
String str2 = (String)request.getAttribute("update2");
String login = (String)request.getAttribute("login");

 StudentDAO st = new StudentDAO();

List<Student> ls2 = st.getAllStudent();
Iterator<Student> itr = ls2.iterator();
%>
<%
if(str!=null){%>
	
	<%= str %>
<% 
}
%>
<%if(str2!=null){
	%>
	<%=str2 %>
<% 	
}%>
<table>
<thead>
<tr>
<th>Id</th>
<th>Name</th>
<th>Mob.no</th>
<th>Delete</th>
<th>Update</th>
</tr>
</thead>
<tbody>
<%
   if(!ls2.isEmpty()){
	     
	while(itr.hasNext()){
	
		Student s = itr.next();
	%>
	<tr>
	<td><%= s.getId() %></td>
	<td><%= s.getName() %></td>
	<td><%= s.getMob_no() %></td>
	<td><A href = "deleteStudent?id=<%=s.getId()%>">Delete</A></td>
	<td><A href = "UpdateSudent?id=<%=s.getId()%>">Edit</A></td>	
<%  }// while closing
   } // if Closing
   else{
	   %>
	<tr>
		<td colspan = "3" >No DATA</td>
	</tr> 
	   <%

   } // else Closing%>
</tbody>
</table>
</body>
</html>