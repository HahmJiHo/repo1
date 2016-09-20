/*
	 HttpGenericServlet 도우미 클래스 사용하기
	 => service()의 ServletRequest, ServletResponse 파리미터 값을
	 		원래 타입으로 형변환 하는게 귀찮아서,
	 		그것을 미리 처리한 HttpGenericServlet을 상속 받아 서블릿 만들기
 */
package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet21")
public class Servlet21 extends HttpGenericServlet {
	
	//Http GenericServlet 에서 추가한 service() 메서드를 오버라이딩 한다.
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service(HttpServletRequse, HttpServletResponse)");
		
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.printf("HTTP 요청 방법 : %s", request.getMethod());
		
		
	}
}
