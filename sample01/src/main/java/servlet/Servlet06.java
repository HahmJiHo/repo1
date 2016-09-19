/*
 * AbstractServlet 클래스를 사용하여 Servlet 인터페이스 간단히 구현하기
 * -Servlet 인터페이스의 네 개 메서드를 미리구현한 객체를 상속받아 구현.
 * 
 */


package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Servlet06")
public class Servlet06 extends AbstractServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Hello, World!!!");

	}
	

}
