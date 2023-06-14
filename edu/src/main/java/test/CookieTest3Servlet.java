package test;

import java.io.*;
import java.util.Arrays;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cookie3")
public class CookieTest3Servlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cnt = 0;
		Cookie[] list = req.getCookies();
		
		cnt = Arrays.stream(list)
				.filter(c->c.getName().equals("count"))
				.mapToInt(i->Integer.parseInt(i.getValue()))
				.reduce((a,b)->b).orElse(0);
		cnt++;
		Cookie c = new Cookie("count", cnt+"");
		c.setMaxAge(60*60*24*10);
		resp.addCookie(c);
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<h1>방문 획수 : " + cnt);
		
		out.close();
	}

}