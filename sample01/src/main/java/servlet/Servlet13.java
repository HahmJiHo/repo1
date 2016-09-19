/*
 *  HTTP 응답과 요청
 *  
 *  웹 브라우저는 웹서버에 요청할 때 HTTP 규칙에 따라 데이터를 보낸다.  
 *  웹 서버 또한 웹브라우저에게 응답할때 HTTP 규칙에 따라 보낸다. 
 *  
 *  확인
 *  => 웹브라우저와 웹서버 사이에 주고 받는 데이터를 모니터링 프로그램을 통해 확인해 보자. 
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

@WebServlet("/Servlet13")
public class Servlet13 extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	
		// 클라이언트가 보낸 데이터 꺼내기
		// => 서블릿에 데이터 보내는 방법?
		// => URL에 데이터를 첨부한다.
		// 예) http://localhost:8080/web01/Servlet11?파라미터 명=값&파라미터명=값
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		String op = request.getParameter("op");

		
		
		response.setContentType("text/html;charset=UTF-8");
		// 1) 출력 도구를 얻는다.
		PrintWriter out = response.getWriter();
		

		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		switch (op) {
		case "+": out.printf("%d %s %d = %d\n", a, op, b, a + b); break;
		case "-": out.printf("%d %s %d = %d\n", a, op, b, a - b); break;
		case "*": out.printf("%d %s %d = %d\n", a, op, b, a * b); break;
		case "/": out.printf("%d %s %d = %d\n", a, op, b, a / b); break;
		default :
			out.println("지원하지 않는 연산자 입니다.");	
		}	
		out.println("	</body>");
		out.println("</html>");
		
	}

}
/*
HTTP 요쳥(웹브라우저 -> 웹서버)
=> 규칙
Request-line (요청방법 URI 프로토콜/버전) CRLF
0개 이상의 헤더(일반/요청/엔티티) CRLF
빈 줄
(POST 요청인 경우 데이터가 이 순서에 놓인다)


GET /web01/Servlet13?a=10&b=5&op=* HTTP/1.1
Host: localhost:8080
Cache-Control: max-age=0
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,**;q=0.8...
Accept-Encoding: gzip, deflate, sdch
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4






HTTP 응답 (웹서버 -> 웹 브라우저)
=> 규칙
Status-line(버전 상태코드 간단한문장)CRLF
0개 이상의 헤더(일반/응답/엔티티) CRLF
빈 줄 
Message-body(콘텐츠)

HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Type: text/html;charset=UTF-8
Content-Length: 62
Date: Tue, 23 Aug 2016 07:52:25 GMT
Proxy-Connection: Keep-alive

<html>
<head></head>
<body>
10 * 5 = 50
	</body>
</html>


*/