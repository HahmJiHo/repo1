/*
	forward
	=> 다른 서블릿으로 실행을 위임할때 사용하는 기법이다.
	
	 
 */
package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet27/s1")
public class Servlet27_s1 extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain;charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.println("********************************");
		out.println("첫 번째 서블릿 : Servlet27_s1......");
		
		// 다른 서블릿으로 실행을 위임한다.
		// 1) 요청을 다른 서블릿으로 배달해줄 객체를 준비한다.
		RequestDispatcher rd = request.getRequestDispatcher("/servlet27/s2");
		// 2) 요청을 위임한다.
		rd.forward(request, response);
	}
}
