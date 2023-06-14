package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ServletConfigTest extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		String env = this.getInitParameter("charset");
		req.setCharacterEncoding(env);
		
		out.print("<h3>이름 : " + req.getParameter("name"));
		out.close();
	}
	
	

}
