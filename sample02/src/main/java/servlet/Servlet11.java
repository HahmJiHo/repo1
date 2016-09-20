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

@WebServlet("/Servlet11")
public class Servlet11 extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	
		// 클라이언트가 보낸 데이터 꺼내기
		// => 서블릿에 데이터 보내는 방법?
		// => URL에 데이터를 첨부한다.
		// 예) http://localhost:8080/web01/Servlet11?파라미터 명=값&파라미터명=값
		String name = request.getParameter("name");
				
		response.setContentType("text/html;charset=UTF-8");
		// 1) 출력 도구를 얻는다.
		PrintWriter out = response.getWriter();
		

		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");

		out.printf("%s님 안녕ㅎㅏ세용??\n", name);
		
		out.println("	</body>");
		out.println("</html>");
		
	}

}
/*
Tomcat8 에서는 한글이 제대로 처리된다
Tomcat7 이하 버전에서는 URL 한글 파라미터 값이 깨지는 문제 발생
	해결책 
		서버 설정 파일(conf/server.xml) 찾아 속성 변경
*/