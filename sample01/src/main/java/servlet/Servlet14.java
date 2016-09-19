/*
   * GET, POST, HEAD
 * 
 * => GET
 * => POST
 * => HEAD 
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

@WebServlet("/Servlet14")
public class Servlet14 extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		
		out.printf("이름 = %s, 나이= %s\n", 
				request.getParameter("name"), request.getParameter("age"));
		
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
------------------------------------------------------------------------------------------------
[[[[[[[[[[[[[[[[[[ GET 요청 ]]]]]]]]]]]]]]]]]]

GET /web01/Servlet14?name=aaa&age=111 HTTP/1.1
Host: localhost:8080
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*
Referer: http://localhost:8080/web01/Servlet14.html
Accept-Encoding: gzip, deflate, sdch
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4


=> 설명
- 서버에 보내는 데이터는 URL에 포함된다
	/web01/servlet14?name=aaa&age=111
- 한번에 보낼수 있는 데이터가 제한된다.
	=> 웹 서버는 보통 request-line 또는 header 크기를 제한 하기 때문이다.		  
		 아파치/Tomcat (8KB), IIS6~7 (16KB)
		 

**특징**
- 소량의 데이터를 보낼 때(게시글 상세보기, 삭제) 사용하는 요청 방식
- 바이너리 데이터를 전송할 수 없다. 
- URL 에 데이터가 포함되기 때문에 URL 과 데이터를 함께 저장할 수 있다.
	=> 즐겨찾기 저장이 쉽다.(이메일 또는 게시판 링크 정보를 공유하기 쉽다)
		 
		 
*/
/*
[[[[[[[[[[[[[[[[[[ POST 요청 ]]]]]]]]]]]]]]]]]]

POST /web01/Servlet14 HTTP/1.1
Host: localhost:8080
Content-Length: 16
Cache-Control: max-age=0
Origin: http://localhost:8080
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36
Content-Type: application/x-www-form-urlencoded
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*
Referer: http://localhost:8080/web01/Servlet14.html
Accept-Encoding: gzip, deflate
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4

name=bbb&age=222

=> 설명
- 서버에 보내는 데이터는 message-body 에 포함된다.
- message-body 에 대한 데이터 정보가 요청 헤더에 포함된다 .
	
	Content-Length: 16
	Content-Type: application/x-www-form-urlencoded

- 서버에 보내는 데이터의 크기 제한이 없다.
	서버에서 승인하는 만큼 보낼 수 있다.
- URL과 데이터 정보가 분리 되어 있어 링크 정보를 공유할 수 없다.

**특징**
- 대용량 데이터를 보낼 때(게시글 등록/수정) 사용하는 요청 방식
- multi-part 포맷으로 바이너리 데이터를 전송할 수 있다.
- 특정 결과를 출력하는페이지의 링크 정보를 공유 할 수 읍다.
- URL에 데이터가 포함되어 있지 않기 때문에 보안을 요구하는 데이터는 노출을 막을 수 있다.
*/

/*
[[[[[[[[[[[[[[[[[[ HEAD 요청 ]]]]]]]]]]]]]]]]]]
=> 프로토콜 예)
HEAD /web01/servlet14 HTTP/1.1
Host : localhost:8080

=> 응답 프로토콜 예)
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Type: text/html;charset=UTF-8
Transfer-Encoding: chunked
Date: Wed, 24 Aug 2016 02:40:45 GMT
(내용은 서버에서 보내지 않는다)


- 서버에 그 자원에 대한 정보만 알고 싶을 떄 사용한다.
- 서버는 요청한 자원의 데이터를 보내지 않고 그 자원에 대한 헤더 정보만 보낸다.
- 보통 프록시 서버가 웹서버에게 요청할 때 사용한다.

 
 */