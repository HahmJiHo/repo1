/*
	 HttpServletRequest 와 HttpServletResponse

	 요청이 들어오면 톰캣 서버는 서블릿에 대해 service() 메서드를 호출 한다.
	 이때 두개의 파라미터 값을 넘기는데
	 HttpServletRequest와 HttpServletResponse를 넘긴다.

	 즉, service() 메서드의 파라미터 값은 
	 servletRequest 의 자식 인터에스인 HttpServletRequse 와
	 servletResponse 의 자식 인터에스인 HttpServletResponse 의 객체이다
 */
package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;


@WebServlet("/servlet20")
public class Servlet20 extends GenericServlet {
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		// ServletRequest 에는 HTTP 요청이(GET/POST/HEAD/PUT/TRACE/DELETE/CONNET) 등이  
		// 무엇인지 알려주는 메서드가 없다 컴파일 오류
		// request.getMethod();
		
		// HTTP 프로토콜에 대해 정보를 추출하려면
		// Service() 파라미터 값을 원래 타입으로 변환해야 한다.
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.printf("HTTP 요청 방법 : %s", httpRequest.getMethod());
		
		
	}
}
