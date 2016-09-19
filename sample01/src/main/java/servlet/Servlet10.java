/*
 * HttpServlet  추상 클래스를 상속 받아 서블릿 구현하기
 * 
 * - Servlet(인터페이스) 
 * 		<-- GenericServlet(추상 클래스)
 * 				<-- HttpServlet (상속 받음)
 * 
 */


package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet10")
public class Servlet10 extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// 0) 출력도구가 사용할 문자표 지정
		// => HTML 데이터를 출력한다고 MINE 타입을 지정한다.
		response.setContentType("text/html;charset=UTF-8");
		// 1) 출력 도구를 얻는다.
		PrintWriter out = response.getWriter();
		

		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		for (int i = 1; i <= 5; i++) {
			out.printf("<h%d>세현이형 바보</h%d>\n",i ,i);
		}
		
		out.println("	</body>");
		out.println("</html>");
		
	}

	
	

}
