package org;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertForm
 */

public class InsertForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Insert STD Data..!</h1>");
		out.println("<form name='F_InserData' action='./processInsert.do' method='post'><table><tr><th>Student Name</th><td><input type='text' name='sname' id='sname'></td></tr><tr><th>Rollnumber</th><td><input type='text' name='rno' id='rno'></td></tr><tr><th>Student Marks</th><td><input type='text' name='marks' id='marks'></td></tr></table>");
		out.println("<br><input type='submit'> <input type='reset'> </form>");
		out.println("</body>");
		out.println("</html>");
	}

}
