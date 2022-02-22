package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import model.Student;


@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		String name = request.getParameter("Name");
		String Mobno = request.getParameter("mobile_no");
		
		System.out.println("Name : "+name+ "Mob no"+Mobno);
		Student s = new Student();
		try {
			if(name !=null && Mobno != null) {
		s.setName(name);
		s.setMob_no(Mobno);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}	
		
		StudentDAO sd = new StudentDAO();
		
		int x = sd.insertStudent(s);
		
		List<Student> ls1 = sd.getAllStudent();
		
		System.out.println("Return value "+x);
		
		if(x == 1)
		{
			request.setAttribute("key","Data insertion successful");
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.include(request, response);
			
		}
		else {
			request.setAttribute("key","Data insertion fail");
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.include(request, response);
			
		}
	}

}
