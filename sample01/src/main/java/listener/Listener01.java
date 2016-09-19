package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// 리스너도 서블릿과 필터처럼 웹 애플리케이션 DD파일에 등록
// 또는 애노테이션을 붙여야 한다.


public class Listener01 implements ServletContextListener{
	
	
	// 웹 애플리케이션을 시작한 후 바로 호출한다. 
	// by ServletContainer 
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Listener01.contextInitialized()");
		
	}
	
	// 웹 애플리케이션을 종료하기 직전에 바로 호출한다.
	// by ServletContainer	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Listener01.contextDestroyed()");
		
	}

}
