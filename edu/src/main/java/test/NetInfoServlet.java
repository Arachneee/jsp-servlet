package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.*;

@WebServlet("/netInfo")
public class NetInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<head><title>Request 정보 출력 Servlet</title></head>");
		out.print("<body>");
		out.print("<h3>네트워크 관련 요청 정보</h3>");
		out.print("Request Scheme : " + req.getScheme() + "<br/>");
		out.print("Server Name : " + req.getServerName() + "<br/>");
		out.print("Server Address : " + req.getLocalAddr() + "<br/>");
		out.print("Server Port : " + req.getServerPort() + "<br/>");
		out.print("Client Address : " + req.getRemoteAddr() + "<br/>");
		out.print("Client Host : " + req.getRemoteHost() + "<br/>");
		out.print("Client Port : " + req.getRemotePort() + "<br/>");
		out.print("<h3>요청방식과 프르토콜 정보</h3>");
		out.print("Request URI : " + req.getRequestURI() + "<br/>");
		out.print("Request URL : " + req.getRequestURL() + "<br/>");
		out.print("Context Path : " + req.getContextPath() + "<br/>");
		out.print("Request Protocol : " + req.getProtocol() + "<br/>");
		out.print("Servlet Path : " + req.getServletPath() + "<br/>");
		
		out.print("<h3>모든 헤더 정보</h3>");
		Enumeration<String> em = req.getHeaderNames();
		while (em.hasMoreElements()) {
			String s = em.nextElement();
			out.println(s + " : " + req.getHeader(s) + "<br/>");
		}
		
		out.print("<h3>추가 정보</h3>");
		out.print("Request Method : " + req.getMethod() + "<br/>");
		out.print("Path Info : " + req.getPathInfo() + "<br/>");
		out.print("Path Translated : " + req.getPathTranslated() + "<br/>");
		out.print("Query String : " + req.getQueryString() + "<br/>");
		out.print("Content Length : " + req.getContentLength() + "<br/>");
		out.print("Content Type : " + req.getContentType() + "<br/>");
	
		out.print("</body></html>");
		out.close();
	}

}