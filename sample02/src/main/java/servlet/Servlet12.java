/*
 * HttpServlet  추상 클래스를 상속 받아 서블릿 구현하기
 * 
 * - Servlet(인터페이스) 
 * 		<-- GenericServlet(추상 클래스)
 * 				<-- HttpServlet (상속 받음)
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

@WebServlet("/Servlet12")
public class Servlet12 extends GenericServlet {

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
	=> '+' : URL 에서 + 문자는 공백(space)을 의미한다.
				 	진짜 '+' 문자를 파라미터 값으로 표현하고 싶다면 URL 인코딩 문자로 표현하라
				 		예) %2B
	=> '%' : URL 에서 %는 인코딩 문자의 시작기호로 사용된다.
					예 %2B는 '+' 문자의 코드 값을 의미한다.
	
	URI(Uniform Resource Identifier)
	=> 인터넷 상의 특정 컴퓨터에 저장된 자원(파일)을 가리키는 식별자/주소 이다. 
	=> 표기법
	1) URN
		 예) urn:isbn:045123456 
	2) URL
		 예) http://www.btmcamp.co.kr
		 
	URL 인코딩?
	=> URL을 작성할 때 ASCII 문자표(영어대/소문자, 숫자, 특수문자 일부)에 정의되지 않은 문자는 
		 특별한 형식으로 변횐 되어 서버에 보내진다.
		 이렇게 특별한 문자로 변환하는 것을 URL 인코딩 이라 한다.
		 
*/