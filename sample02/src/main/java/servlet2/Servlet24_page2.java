/*
	 오리지날 HttpServlet 사용하기
	 => Jave EE 에서 제공해주는 HttpServlet 을 상속받아 
	  	서블릿을 만들어 보자~
	 
 */
package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet24_page2")
public class Servlet24_page2 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("미성년자를 위한 메인 페이지");

	}

}
