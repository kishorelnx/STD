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

public class DeleteForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Delete STD Data..!</h1>");
		out.println("<form name='F_DeleteData' action='./processDelete.do'><h3>Enter Roll number</h3><input type='text' name='rno' id='rno'>");
		out.println("<input type='submit' value='Delete'> <input type='reset'> </form>");
		out.println("</body>");
		out.println("</html>");
	}

}
