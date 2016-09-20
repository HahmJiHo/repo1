/*
	Redirect 방법
	=> 클라이언트 에게 즉시 다른 URL을 요청하도록 명령을 내릴 때 
	
	방법 : 응답 상태 코드(200 대신 301)를 바꾼다.
	용도 : 리프래시와 달리 콘텐츠 출력없이 다른 페이지로 보낼 때 사용 한다.
	
	 
 */
package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet26")
public class Servlet26 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int age = Integer.parseInt(request.getParameter("age"));
			
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		
		out.println("<html><head>");
		out.println("<title>Refresh 테스트</title><body>");	
		out.println("<script>");
		out.println("if (age < 19) {");
		out.println("console.log('미성년') } else {");
		out.println("console.log('성년') }");
		out.println("</script>");
		out.println("</head>");
		if (age < 19) {
			out.println("미성년");	
		} else {
			out.println("성년");
		}
		out.println("</body>");
		out.println("</html>");
		
		
		// 리다이렉트는 클라이언트로 콘텐츠를 보내지 않는다. 
		// => 이전에 출력한 것은 현재 버퍼에 저장되어 있다.
		//		아직 클라이언트로 출력한 생태가 아니라는 것이다.
		//		따라서 버퍼에 저장된 콘텐츠를 버린다.
		// 주의사항
		// => 만약 출력한 내용이 많아서 버퍼에 보관된 내용이 이미 출력 되었다면,
		// 		리다이렉트 할 수 없다.
		//		리다이렉트는 클라이언트로 출력하기 전에만 가능하다.
		if (age < 19) {
			response.sendRedirect("servlet24_page2");
		} else {
			response.sendRedirect("servlet24_page3");
		}
		
	}
}
