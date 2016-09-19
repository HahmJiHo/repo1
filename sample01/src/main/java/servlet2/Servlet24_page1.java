/*
	Refresh 방법
	=> 클라이언트 에게 콘텐츠 출력을 완료한 후, 다른 URL 로 다시 요청하도록 하는 방법
	
	방법 1 : HTTP 응답 헤더에 refresh 정보 삽입.
	방법 2 : HTML <meta> 태그에 refresh 정보 삽입
	 
 */
package servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet24_page1")
public class Servlet24_page1 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int age = Integer.parseInt(request.getParameter("age"));
		
		if (age < 18) {
			response.setHeader("Refresh", "1;url=servlet24_page2");
		} else {
			response.setHeader("Refresh", "1;url=servlet24_page3");
		}
		
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
	
		out.println("<html><head>");
		out.println("<title>Refresh 테스트</title><body>");	
		out.println("<script>");
		out.println("var age = " + age );
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
	}

}
