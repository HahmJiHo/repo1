/*
 *  주제 : 쿠키의 유효기간 지정하기
 *  => 쿠키에 유효기간을 지정하지 않으면 웹 브라우저가 실행되는 동안만 유지 된다. 
 * 		 즉 웹 브라우저를 종료하면 쿠키가 모두 삭제 된다.
 *  => 쿠키의 유효기간을 지정하면 그 기간 동안은 임시 캐시 폴더에 저장된다.
 *  	 웹 브라우저를 종료하거나 OS를 종료하더라도 유지 된다.
 *  
 */
package servlet4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/servlet42")
public class Servlet42 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 쿠키를 만든다.
		Cookie c1 = new Cookie("name", URLEncoder.encode("홍길동", "UTF-8"));
		// 쿠키의 유효기간을 지정하지 않으면 웹브라우저가 실행 되는 동안만 유지 된다.
		
		Cookie c2 = new Cookie("email", "test@test.com");
		c2.setMaxAge(30);
		c2.setPath("/web01/test"); // 쿠키의 사용 범위를 지정한다.
		// 사용 범위를 지정할 때는 웹 애플리케이션 루트(컨텍스트 루트)가 아닌 
		// 웹 서버 루트를 기준으로 경로를 지정해야 한다.
		
		Cookie c3 = new Cookie("age", "20");
		c3.setPath("/web01/test");
		
		// 2) 쿠키를 응답 헤더에 싣는다.
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		// 3) 간단한 응답
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("웹 브라우저로 쿠키를 보냈쪙~. HTTP 응답 확인 하세용~");
		
	}
}


/* URL 인코딩의 으미
 * => URLEncoder.encode("홍길동", "UTF-8")
 * => "홍길동" (2바이트 유니코드) ---> UTF-8 코드(2~4바이트) 형식으로 인코딩 ---> ASCII 코드화 
 * 
 */

