/*
 * 애노테이션으로 서블릿 등록하기!
 * @WebServlet("URL")
 *  이 애노테이션을 사용하면 
 *  web.xml 에 <servlet>태그와 <servlet-mapping> 태그를 지정할 필요가 읎다.
 *  - 서블릿 컨테이너가 이 애노테이션을 처리하도록 web.xml의 web-app 태그의 속성 값을 지정하라!
 *  	=> metadata-complete="" <- flase 속성을 줘라
 *  
 *  
 * 	########## 주의 ##############
 *  
 *  - Servlet 3.0 API 부터 사용 가능하다.
 */


package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Servlet04")
public class Servlet04 implements Servlet {
	ServletConfig config;
		
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
		this.config = config;
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service()");		
	}
	@Override
	public void destroy() {
		System.out.println("destory()");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "servlet04";
	}



}
