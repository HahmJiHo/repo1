/*
 *  주제 : 클라이언트 에게 데이터를 보관시키는 방법 - cookie
 *  
 *  => 클라이언트에게 데이터(쿠키)를 보낼 떄 응답 헤더를 이용하여 보낸다.
 *  
 *  => 데이터(쿠키)는 key/value 한 쌍의 값으로 보낸다.
 * 	=> key와 value는 반드시 문자열 이여야 한다.
 * 	=> key와 value는 ISO-8859-1로 인코딩 되어야 한다.
 * 	=> 한글 문자를 아스키 문자표 에 있는 영문화 시킨 다음에 보내야 한다. 
 * 	=> 한글 ? URLencoding을 수행하여 ASCII 코드화 시켜서 보내야 한다.
 *  => 데이터의 사용 범위를 지정할 수 있다.
 *  => 데이터의 유효 기간을 지정할 수 있다.
 *  => 웹 브라우저는 서버로부터 받은 데이터의 
 *  	 사용 범위 내에 있는 URL을 요청할 때는
 *  	 반드시 그 데이터를 요청 헤더에 포함하여 서버에 보내야 한다.(강제 사항)
 *  => 즉 쿠키는 서버가 데이터를 웹 브라우저 에게 주면서 다음과 같이 말하는 것과 같다.
 *  	 "내가 준 데이터 잘 보관하고 있다가 다음에 나한테 요청할 때 가져와~"
 * 		 "날짜 지난 것은 가져오지마~"
 * 		 "내가 보내라고 지정한 URL을 요청할 때만 보내~"
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

@WebServlet("/test/servlet37")
public class Servlet37 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 쿠키를 만든다.
		Cookie c1 = new Cookie("name", URLEncoder.encode("홍길동", "UTF-8"));
		// 쿠키의 사용 범위를 지정하지 않으면 쿠키를 보내는 서블릿의 경로가 사용 범위 이다.
		
		Cookie c2 = new Cookie("email", "test@test.com");
		c2.setPath("/web01/test"); // 쿠키의 사용 범위를 지정한다.
		// 사용 범위를 지정할 때는 웹 애플리케이션 루트(컨텍스트 루트)가 아닌 
		// 웹 서버 루트를 기준으로 경로를 지정해야 한다.
		
		Cookie c3 = new Cookie("age", "20");
		c3.setPath("/web01/test2");
		
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

