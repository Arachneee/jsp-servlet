package test;

import java.io.*;
import java.util.Arrays;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cookie2")
public class CookieTest2Servlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		Cookie[] list = req.getCookies();
		
		Arrays.stream(list).forEach(i->out.println(i.getName() + " : " + i.getValue() + "<br>"));

		out.close();
	}

}