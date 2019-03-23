package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public abstract class QuestionServerImplementation extends UnicastRemoteObject implements RemoteQuestions {

	Vector<Question> ExamQuestions = new Vector<Question>();
	
	QuestionServerImplementation() throws RemoteException {
	
		
		
		
	}
	
	/**Implementing the interface method student**/
	public List<Question> getStudent() throws Exception {
		List<Question> list = new ArrayList<Question>();
		
		  
	      String JDBC_DRIVER = "com.mysql.jdbc.Driver";   
	      String DB_URL = "jdbc:mysql://localhost:3306/details";  
	      
	      /** Database username and password**/
	      String USER = "myuser"; 
	      String PASS = "password";  
	      
	      Connection conn = null; 
	      Statement stmt = null;  
	      
	      /**Register JDBC driver**/ 
	      Class.forName("com.mysql.jdbc.Driver");   
	      
	      /**Open a connection**/
	      System.out.println("Connecting to database..."); 
	      conn = DriverManager.getConnection(DB_URL, USER, PASS); 
	      System.out.println("Connection successfull...");  
	      
	      stmt = conn.createStatement();  
	      String sql = "SELECT * FROM Student"; 
	      ResultSet rs = stmt.executeQuery(sql);
	      
	      
	      while(rs.next()) { 
	          // Retrieve by column name 
	          String sid  = rs.getString("studentID"); 
	          
	          String sfname = rs.getString("firstname"); 
	          String slname = rs.getString("lastname"); 
	         // String sgender = rs.getString("gender");
	          
	          int sbday = rs.getInt("birthday"); 
	          int sphone = rs.getInt("phone");  
	          
	          // Setting the values 
	          Question student = new Question();
	          student.setSid(sid); 
	          student.setSfname(sfname); 
	          student.setSlname(slname); 
	          student.setSbday(sbday); 
	          student.setSphone(sphone); 
	          list.add(student); 
	          
	       } 
		rs.close();
		return list;
		
	}

	public List<Question> getTeacher() throws Exception {
		
		List<Question> list = new ArrayList<Question>();
		
		  
	      String JDBC_DRIVER = "com.mysql.jdbc.Driver";   
	      String DB_URL = "jdbc:mysql://localhost:3306/details";  
	      
	      /** Database username and password**/
	      String USER = "myuser"; 
	      String PASS = "password";  
	      
	      Connection conn = null; 
	      Statement stmt = null;  
	      
	      /**Register JDBC driver**/ 
	      Class.forName("com.mysql.jdbc.Driver");   
	      
	      /**Open a connection**/
	      System.out.println("Connecting to database..."); 
	      conn = DriverManager.getConnection(DB_URL, USER, PASS); 
	      System.out.println("Connection successfull...");  
	      
	      stmt = conn.createStatement();  
	      String sql = "SELECT * FROM Teacher"; 
	      ResultSet rs = stmt.executeQuery(sql);
	      
	      
	      
	      while(rs.next()) { 
	          // Retrieve by column name 
	          String tid  = rs.getString("teacherID"); 
	          
	          String tfname = rs.getString("firstname"); 
	          String tlname = rs.getString("lastname"); 
	         // String tgender = rs.getString("gender");
	          
	          int tbday = rs.getInt("birthday"); 
	          int tphone = rs.getInt("phone");
	          String temail = rs.getString("email");
	          
	          /** Setting the values**/
	          Question teacher = new Question();
	          teacher.setTid(tid); 
	          teacher.setTfname(tfname); 
	          teacher.setTlname(tlname);  
	          teacher.setTbday(tbday);
	          teacher.setTphone(tphone); 
	          teacher.setTemail(temail);
	          list.add(teacher); 
	       } 
		rs.close();
		return list;
		
	
	}
	
}
