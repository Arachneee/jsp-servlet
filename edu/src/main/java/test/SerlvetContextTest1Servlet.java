package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/context1")
public class SerlvetContextTest1Servlet extends HttpServlet {
//	ServletContext sc;
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		sc = config.getServletContext();
//	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		ServletContext scHttp = this.getServletContext();
		String location = scHttp.getInitParameter("contextConfig");
		
		out.print("location" + location+"<br>");
		
		//out.print("Context : " + sc + "<br>");
		out.print("Http Context : " + scHttp);
		out.close();
	}

}
