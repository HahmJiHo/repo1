/*
 * AbstractServlet 추상 클래스와 같은 기능을 하는 것이 Generic
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

@WebServlet("/Servlet07")
public class Servlet07 extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Hello, World!!!");

	}
	

}
