// 서블릿 생성자 vs init() 메서드
// 	- 생성자에서는 서블릿 관련 정보를 얻을 수 없다.
// 	- init()는 파라미터로 ServletConfig 객체를 받는다.
//		ServletConfig 객체로 web.xml 파일에 저장된 값들을 조회할 수 있다.
//		따라서 서블릿이 필요한 자원을 준비할 때 생성자에서 준비하는 것 보다는
//		init()에서 준비하는 것이 더 편리하다



package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet02 implements Servlet {
	ServletConfig config;
	
	public Servlet02() {
		try {
			String driver = "";  // 값을 어디서 가지고 올거니~~~?
			String jdbcUrl = "";
			String username ="";
			String passsword ="";
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(jdbcUrl, username, passsword);
		} catch(Exception e) {
			
		}
		
	}
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
		this.config = config; 
		
		try {
			// ServletConfig 객체를 사용하면 web.xml 에 기록된 파라미터 값을 조회할수 있다.
			// 이것이 생성자가 아닌 init() 에서 자원을 준비하는 이유이다.
			String driver = config.getInitParameter("driver");
			String jdbcUrl = config.getInitParameter("jdbcUrl");
			String username = config.getInitParameter("username");
			String passsword = config.getInitParameter("password");
			
			System.out.println(driver);
			System.out.println(jdbcUrl);
			System.out.println(username);
			System.out.println(passsword);
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(jdbcUrl, username, passsword);
		} catch(Exception e) {
			
		}
		
		
		
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
		return "servlet01";
	}



}
