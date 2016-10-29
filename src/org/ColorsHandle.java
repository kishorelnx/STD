package org;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/colors.do")
public class ColorsHandle extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String url_type_4="jdbc:oracle:thin:@localhost:1521:orcl";
	String uname="scott";
	String pwd="tiger";
	Connection con = null;
	Statement stmt = null;
	  

protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String s = request.getParameter("colorcode");
	
	PrintWriter out = response.getWriter();
	
	System.out.println(s);
	
	if(s.equals("red")){
	out.println("<script>document.getElementById('d1').style.backgroundColor = '#ff3333'</script>");
	} else if(s.equals("green")){
		out.println("<script>document.getElementById('d1').style.backgroundColor = '#33ff33'</script>");
	} else if((s.equals("yellow"))){
		out.println("<script>document.getElementById('d1').style.backgroundColor = '#e6ff33'</script>");
	

	}
		
	}

}
