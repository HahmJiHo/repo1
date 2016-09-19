/*
 *  주제 : 기존 세션 얻기
 *  => 세션 관리 정책에 따라서
 *  	 웹브라우저에서 세션 아이디를 요쳥 헤더에 첨부하여 쿠키 형태로 보냈고,
 *  	 서블릿에서 확인해보니 그 세션 아이디에 해당하는 세션 객체가 존재하며 그리고 유효 하다면,
 *  	 
 *  
 */
package servlet5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet45")
public class Servlet45 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 다음 메서드가 리턴하는 것은 기존에 존재하던 세션 객체이다.
		// 물론 웹브라우저가 알려준 세션 아이디에 해당하는 객체일 것이다.
		// => 만약, 웹브라우저를 종료 했다가 새로 띄운 다음에 이 서블릿을 실행한다면,
		//		세션 아이디를 못 받았기 때문에 새로운 세션 객체를 만들어 리턴할 것이다.
		HttpSession session = request.getSession();
		
		
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.printf("세~~~~~~~~~~~~~~~~~~~~~션아이디 : %s\n", session.getId());
		
		
	}
}

/* 새로 세션을 만들 때
 * => 클라이언트로 쿠키를 사용하여 세션 아이디를 보낸다.
 * 
 * 
 * 
 */

