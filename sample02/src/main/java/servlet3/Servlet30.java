package servlet3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet30")
public class Servlet30 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1) ServletContext 보관소에 값을 저장한다.
		ServletContext servletContext = this.getServletContext();
		servletContext.setAttribute("a1", "hello");

		//2) ServletRequest 보관소에 값을 저장
		request.setAttribute("r1", "World!");

		// 다른 서블릿으로 forwrad			
		RequestDispatcher rd = request.getRequestDispatcher("/servlet31");
		rd.forward(request, response);

	}
}
