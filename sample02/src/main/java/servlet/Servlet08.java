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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet08")
public class Servlet08 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Hello, World!!!");

	}
	

}
