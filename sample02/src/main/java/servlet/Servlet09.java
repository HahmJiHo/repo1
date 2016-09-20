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

@WebServlet("/Servlet09")
public class Servlet09 extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// 0) 출력도구가 사용할 문자표 지정
		/*	MIME(Multi-purpose Internet Mail Extension)  Type
		 *  - 보내는 데이터 타입을 상대에게 알려줘야 하는 상대편에게 제대로 처리할 수 있따.
		 * 	-	Email 프로그램에서 첨부하여 보내는 데이터 타입을 지정하기 위해 만든 문법이다
		 * 	- 그러나 오늘 날에는 이메일 뿐만 아니라 다른 기술에서도  MINE Type 을 사용하고 있다.
		 * 	- 보통 많이 사용되는 MINE 타입 은 국제적으로 공개 되어있다
		 */
		
		response.setContentType("text/plain;charset=UTF-8");
		// 1) 출력 도구를 얻는다.
		PrintWriter out = response.getWriter();
		
		// getWriter()가 리턴한 출력도구는 기본으로 Unicode를 ISO-8859-1 문자표에 따라 출력한다.
		// => ISO-8859-1 문자표?
		// 영어 대/소 문자 ,숫자, 특수문자 등 약 100자 정도의 문자에 대해 코드 값을 정의해 놓고있다.
		//	=> 한글에 대해서는 코드값을 정의하지 않음.
		// 해결책 !!
		//	=> 유니코드를 출력할때 사용할 문자표를 ISO-8859-1 을 UTF-8 로 교체
		for (int i = 0; i < 100; i++) {
			out.printf("세현이형 바보 멍충이%d\n", i);
		
		}
		
		
	}

	
	

}
