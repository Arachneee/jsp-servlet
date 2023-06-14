package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/member")
public class MemberTestServlet extends HttpServlet {
	static int count = 0;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int number = 0;
		count++;
		String str = req.getParameter("msg");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("<html><head><title>MultiThread Test</title></head>");
		out.println("<body><h2>처리 결과(멤버변수)</h2>");
		while (number++ < 10) {
			out.print(str + " : " + number + "(전체 접속 횟수) = "+count +"<br>");
			out.flush();
			System.out.println(str + " : " + number);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		out.println("<h2>Done " + str + " !!</h2>");
		out.println("</body></html>");
		out.close();
	}

}