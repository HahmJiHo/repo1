/*
 *  주제 : 세션 무효화 시키기 
 *  => 세션을 무효화 시키면 해당 
 */
package servlet5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet48")
public class Servlet48 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 다음 메서드가 리턴하는 것은 기존에 존재하던 세션 객체이다.
		// 물론 웹브라우저가 알려준 세션 아이디에 해당하는 객체일 것이다.
		// => 만약, 웹브라우저를 종료 했다가 새로 띄운 다음에 이 서블릿을 실행한다면,
		//		세션 아이디를 못 받았기 때문에 새로운 세션 객체를 만들어 리턴할 것이다.
		HttpSession session = request.getSession();
		session.invalidate(); // 세션 무효화
		session = request.getSession(); // 새 세션 객체를 리턴한다.
		
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.printf("세~~~~~~~~~~~~~~~~~~~~~션아이디 : %s\n", session.getId());
		out.printf("name = %s\n", session.getAttribute("name"));
		out.printf("gender = %s\n", session.getAttribute("gender"));
		out.printf("age = %s\n", session.getAttribute("age"));
		out.printf("date = %s\n", session.getAttribute("date"));
		
	}
}

/* 새로 세션을 만들 때
 * => 클라이언트로 쿠키를 사용하여 세션 아이디를 보낸다.
 * 
 * 
 * 
 */

