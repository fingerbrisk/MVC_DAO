package dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import DBConnector.MyDBConnector;
import model.Student;

public class StudentDAO {
	
	static MyDBConnector dbcon = new MyDBConnector();
	Connection con1,con2;
	ResultSet rs;
	PreparedStatement stmt,stmt1;
	
	public int insertStudent(Student s) {
		
		int status = 0;
		con1 = dbcon.getMyConnection();
		System.out.println("Inserted "+s);
		System.out.println("Connection Set : "+con1);
		
		try {
						
			stmt = con1.prepareStatement("insert into student(Name,mobile_no) values (?,?)");
			stmt.setString(1, s.getName());
			stmt.setString(2, s.getMob_no());
			status = stmt.executeUpdate();
			System.out.println(status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	//Query function - to retrieve the data 
    public List<Student> getAllStudent() {
	
	con2 = dbcon.getMyConnection();
	
	System.out.println("Get ALL method "+con2);
	List<Student> ls = new ArrayList<Student>();
	
	
	try {
		stmt1 = con2.prepareStatement("select * from student");
		 rs = stmt1.executeQuery();
		 System.out.println("ResultSet "+rs);
		 
		 while(rs.next()) {

				Student s3 = new Student();
				
				s3.setId(rs.getInt(1));
				s3.setName(rs.getString(2));
				s3.setMob_no(rs.getString(3));
				
				ls.add(s3);
		 }
		 
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	System.out.println("**************"+ls);
		return ls;
	}
    
    //Delete data
    public int deleteStudent(int id) {

    	int status = 0;
    	
    	System.out.println("ID "+id);
    	con1 = dbcon.getMyConnection();
    	System.out.println("Delete called "+con1);
    	
    	try {
			stmt = con1.prepareStatement("delete from student where id=?");
			stmt.setInt(1, id);
			status = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	System.out.println("\nDeleteStatus "+status);
    	return status;	
    }
    public int updateStudent(Student s) {
    	
    	int status2 = 0;
    	con1 = dbcon.getMyConnection();
    	System.out.println("&&&&In update student method&&&"+s);
    	try {
			stmt = con1.prepareStatement("update student set Name=?,mobile_no=? where id=?");
			stmt.setInt(3, s.getId());
			stmt.setString(1, s.getName());
			stmt.setString(2, s.getMob_no());
			status2 = stmt.executeUpdate();
			System.out.println("####Update status :"+status2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return status2;
    	
    }

	public static Student getStudentById(int i) {
		
		PreparedStatement stmt;
		ResultSet rs = null;
		Student s = new Student();
		//To be checked
		Connection con1 = dbcon.getMyConnection();
		System.out.println("Value of ID in DAO : "+i);
		try {
			stmt = con1.prepareStatement("select * from student where id=?");
			stmt.setInt(1, i);
			
			rs = stmt.executeQuery();
			if(rs.next()) {
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setMob_no(rs.getString(3));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Get Student by Id in DAO : "+s);
		return s;
	}
	
}

