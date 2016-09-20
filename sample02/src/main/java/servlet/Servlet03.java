/*
 * 서블릿 생성자 vs init() 메서드
 * - 	서블릿 객체는 최초 요청시 생성된다.
 * - 	그런데 서블릿이 사용할 자원을 준비시키는데 시간이 오래걸린다면, 최소로 요청하는 사용자는
 * 		사용자는 늦게 응답 을 받을 수 있다.
 * - 	더중요한 것은 자원을 준비하는 코드에 잠재적인 오류가 있다 하더라도 
 * 		그것은 최초 요청할 때 까지 알수가 없다.
 * - 	즉, 최초 요청할 때 오류를 발견한다면,  업무에 치명적일 수 있다.
 *  
 *  - 해갤책?
 *  => 서블릿을 요청하지 않아도, 서버를 실행할 때 서블릿 객체를 미리 생성할 수 있다면 
 *  	 서버 실행중에 오류를 미리 발견하여 조치를 취할 수 있을 것이다.
 *  => web.xml 에 서블릿을 등록할 때 서버에 서블릿을 생성하라고 설정하라  
 *  	<load-on-startup>순번</load-on-startup>
 *  
 */


package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet03 implements Servlet {
	ServletConfig config;
		
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
			e.printStackTrace();
		}
						
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		for (int i = 0; i < 82; i++) {
			System.out.printf("세현이형 %d미리 박격포\n", i);
		}
		
		
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
