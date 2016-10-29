package org;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProcessInsert extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String url_type_4="jdbc:oracle:thin:@localhost:1521:orcl";
	String uname="scott";
	String pwd="tiger";
	Connection con = null;
	Statement stmt = null;
	  

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String srno=request.getParameter("rno");
	String sname=request.getParameter("sname");
	String smarks=request.getParameter("marks");
	float am;

	org.ValidationLogic val = new ValidationLogic();
	am = val.savgCalc(smarks);

	String sql="insert into std values("+Integer.parseInt(srno)+",'"+sname+"',"+Integer.parseInt(smarks)+","+am+" )";
	System.out.println(sql+"-"+url_type_4+"-"+uname+pwd);
	
	PrintWriter out=response.getWriter();		
			
			
	if (val.marksValidation(smarks)){
		out.println("<br><font color='red'>Marks should be lessthan or equal to 100</font>");
	}
	else{		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");	
		con = DriverManager.getConnection(url_type_4,uname,pwd);		
		System.out.println("Connecttion established to ORACLE..!");	
		con.setAutoCommit(false);
		stmt = con.createStatement();		
		stmt.executeUpdate(sql);				
		out.println("<font color='green'><h1> *** <u>Registration Successful</u> *** </h1><br> The below record has been Successfully Inserted into the Student Database</font><br>");
		out.println("<br>Rollnumber: "+srno);
		out.println("<br>Student Name: "+sname);
		out.println("<br>Student Marks: "+smarks);
		System.out.println("Student Data uploaded..! ");
		con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 			
		}
	}
	
	out.println("<br><br><br><a href='./index.html'> Home Page </a>");
		
	}

}
