package org;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProcessDisplay extends HttpServlet {
	String url_type_4="jdbc:oracle:thin:@localhost:1521:orcl";
	String uname="scott";
	String pwd="tiger";
	Connection con = null;
	Statement stmt = null;
	
	private static final long serialVersionUID = 1L;      

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String sql="select * from std where rno = "+Integer.parseInt(request.getParameter("rno"));
			System.out.println(sql+"-"+url_type_4+"-"+uname+pwd);
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			con = DriverManager.getConnection(url_type_4,uname,pwd);		
			System.out.println("Connecttion established to ORACLE..!");		
			stmt = con.createStatement();		
			ResultSet rs=stmt.executeQuery(sql); 
			
			PrintWriter out=response.getWriter();
			
			while(rs.next())  {
			    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));			
			
			out.println("<font color='green'><h1> *** <u>Student Information</u> *** </h1></font><br> Entered Rollnumber is: "+request.getParameter("rno")+"<br>");
			out.println("<br>Rollnumber: "+rs.getInt(1));
			out.println("<br>Student Name: "+rs.getString(2));
			out.println("<br>Student Marks: "+rs.getString(3));
			}
			
			out.println("<br><br><br><a href='./index.html'> Home Page </a>");
			
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
		
		System.out.println("Student Data uploaded..! ");
		
	}

}
