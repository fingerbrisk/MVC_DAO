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
 * Servlet implementation class UpdateSudent
 */
@WebServlet("/UpdateSudent")
public class UpdateSudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String sid = request.getParameter("id");
		
		
		int i = Integer.parseInt(sid);
		
		System.out.println("ID value in : "+i);
		
		Student s =  StudentDAO.getStudentById(i);
		
		System.out.println("Get Student by Id in UpdateServlet1 : "+s);
		
		//Directing to updateStudent.jsp
			request.setAttribute("Update", s);
			RequestDispatcher rd = request.getRequestDispatcher("updateStudent.jsp");
			rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);

		
	}

}
