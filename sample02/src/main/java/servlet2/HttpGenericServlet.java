package servlet2;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public abstract class HttpGenericServlet extends GenericServlet {
	
	// 톰캣 서버가 호출하는 service 
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("service(ServletRequset, ServletResponse)");
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;	
		
		service(httpRequest, httpResponse);
	}
	
	// 추상클래스를 통해 물려주기 위한 메서드
	public abstract void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	
}
