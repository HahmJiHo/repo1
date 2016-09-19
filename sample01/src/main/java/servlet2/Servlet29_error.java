/*

	forword
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


@WebServlet("/servlet29/error")
public class Servlet29_error extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();		
		out.println("------------error----------");
		out.println("파라미터 값이 없거나 지원하지 않는 연산자 입니다.");

	}
}
