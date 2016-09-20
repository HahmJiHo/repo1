/*
 * POST 요청 한글 깨짐 문제 
 * 
 * => GET 요청인 경우 Tomcat Server 설정으로 클라이언트가 보내는 데이터의 문자표를 지정한다 
 * => POST 요청으로 데이터를 보내는 경우, 톰캣 서버의 설정으로 처리할 수 없다.
 * 		데이터를 꺼내기 전에 어떤 문자표를 사용할 것인지 지정해야 한다.
 * 		request.setCharcterEncoding("UTF-8")
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

@WebServlet("/Servlet15")
public class Servlet15 extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	
		// getParamet()를 호출하기 전에 클라이언트가 보낸 데이터가 어떤 문자표를 사용했는지 알려줘라!
		// => 클라이언트가 보낸 데이터가 UTF-8 문자표를 사용한다면 다음과 같이 설정하라.
		// => 반드시 최초의 getParamter()를 호출하기전에 설정해야함.
		// =>	만약 한 번이라도 먼저 getParameter()를 호출하면 무시된다.
		request.setCharacterEncoding("UTF-8");
		
		String age = request.getParameter("age");
		String name = request.getParameter("name");
		response.setContentType("text/html;charset=UTF-8");// MIME 타입; 문자표

		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		
		out.printf("이름 = %s, 나이= %s\n", name, age);
		
		out.println("	</body>");
		out.println("</html>");
		
	}

}
/* 클라이언트가 보낸 데이터를 꺼내기 전에 문자표를 지정하는 이유
- 데이터를 꺼낼때 getParameter() 메서드를 사용한다.
  이 메서드는 클라이언트가 보낸 데이터를 2바이트 유니코드로 변환하여 리턴한다.
 	자바가 실행 중에 문자를 다룰 때는 2바이트 유니코드로 다루기 떄문이다.
 	즉 JVM은 무조건 문자를 2바이트(char 타입)로 받는다.
 	
- 문제는 Client 가 보낸 데이터를 기본으로 ISO-8859-1 로 간주한다는 것이다.  	
 	그 뜻은 클라이언트가 보낸 데이터를 영어로 간주하고 유니코드로 바꾼다.  
 	
- 해결책 
	getParameter()를 호출 하기전에 클라이언트가 보낸 데이터가 어떤 문자를 사용하는지 알려줘야 한다.
 	
 	
 */