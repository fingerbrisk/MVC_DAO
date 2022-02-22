package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
	
	}
    
}
