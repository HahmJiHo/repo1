/*
  리스너 요청이 들어올 때 작업수행 @WebListener 를 사용하여 등록하기
*/
package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

// 리스너도 서블릿과 필터처럼 웹 애플리케이션 DD파일에 등록
// 또는 애노테이션을 붙여야 한다.

@WebListener
public class Listener02 implements ServletRequestListener {
	
	public Listener02() {
		System.out.println("Listener02");
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// 요청이 들어오면 호출된다.
		System.out.println(sre.getServletRequest().getRemoteAddr());
		System.out.println("Listener02.requestDestroyed()");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// service()를 실행한후 호출된다.
		System.out.println("Listener02.requestInitialized()");
		
	}
	
	
}