/*
 *  주제 : 세션에 데이터 저장하기 
 *  => 웹 브라우져 별로 구분하여 저장할 데이터가 있다면,
 *  	그 데이터는 세션에 보관하라
 *  	 
 *  참고 
 *  	- 웹 브라우저에 상관없이 모든 사용자가 즉 모든 서블릿이 공유할 데이터는
 *      ServletContext 에 보관하라!
 *    - 요청을 처리 하는 동안(응답하기 전까지) 공유할 데이터는 
 *    	ServletRequest에 보관하라!
 *   => 데이터 저장하는 방법
 *   		ServletContext 및 ServletRequest와 같다
 *   	  
 *      -setAttribute(key, value);  	 
 *      -getAttribute(key)
 *      => 쿠키와 달리 어떤 객체라도 저장 가능
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

@WebServlet("/servlet47")
public class Servlet47 extends HttpServlet{
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

