/*
	include
	=> 다른 서블릿의 실행을 포함 할 때 사용하는 기법
	
	 
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


@WebServlet("/servlet28/s1")
public class Servlet28_s1 extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain;charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.println("첫 번째 서블릿 : Servlet28_s1......");
		
		// 다른 서블릿의 실행을 포함한다. => 꼭 메서드 호출과 유사하다.
		RequestDispatcher rd = request.getRequestDispatcher("/servlet28/s2");
		rd.include(request, response);
		
		rd = request.getRequestDispatcher("/servlet28/s3");
		rd.include(request, response);

		out.println("----------------------------------------");
	}
}
