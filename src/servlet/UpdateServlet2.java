package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import model.Student;

/**
 * Servlet implementation class UpdateServlet2
 */
@WebServlet("/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String uid = request.getParameter("Uid");
		String uname = request.getParameter("UName");
		String umob_no = request.getParameter("Umobile_no");
		int i = Integer.parseInt(uid);
		
		Student s = new Student();
		s.setId(i);
		s.setName(uname);
		s.setMob_no(umob_no);
		
		System.out.println("Student in Servlet2 : "+s);
		
		StudentDAO sd = new StudentDAO();
		int update_status = sd.updateStudent(s);
		
		if(update_status==1) {
			request.setAttribute("update2","Editing successful");
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.include(request, response);
		}
		else {
			request.setAttribute("update2","Data insertion successful");
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.include(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
