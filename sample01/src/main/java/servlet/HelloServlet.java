package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet {
	ServletConfig config;
	// Servlet Lifecycle 과 관련된 메서드
	// 1) Servlet Container 가 서블릿 객체를 만든 후 호출하는 메서드
	// =>	각 서블릿 클래스에 대해 인스턴스는 딱 한 개만 만든다.
	//		따라서 이메서드는 각 서블릿에 대해 딱 한 번만 호출 된다.
	//		주로 서블릿 객체가 작업할 때 사용할 자원을 준비하는 코드를 넣는다.
	
	// 자바가 실행될떄 미리 준비하는 객체 
	@Override
	public void init(ServletConfig config) throws ServletException {
		//파라미터로 받은 ServletConfing 객체를 보관해 두었다가 
		//getServletConfig() 메서드가 호출될 때 리턴하라!
		this.config = config;
		System.out.println("init()");
		// 혹시 이 서블릿을 실행하는데 필요한 객체나 데이터가 있다면 여기에서 준비하라!
	}
	
	// 2) 클라이언트 요청이 들어 올 때 마다 Servlet Container 가 호출 하는 메서드
	// => 가장 중요한 메서드 
	// =>	클라이언트 요청이 있을 때마다 호출되는 메서드 이기 때문에 이메서드 안에 요청처리 코드 작성.
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// ServletContainer는 이 메서드를 호출하면서 작업할 때 사용하라고,
		// 아주 중요한 두 개의 객체를 파라미터로 넘겨준다.
		// ServletRequest : 요청 정보를 다룰 때 사용할 도구들이 들어있다. 
		// ServletResponse : 응답에 관련된 도구들이 들어 있다.
		System.out.println("service()");
	}
	
	// 3) Servlet Container 가 종료하기 직전에 각 서블릿 객체에 대해 호출 하는 메서드 
	// =>	Servlet Container 가 종려 되기 직전에 딱 한번 호출 된다.
	//		보통 init()에서 준비한 자원을 해제 시키는 작업을 한다.
	@Override
	public void destroy() {
		//특별히 서버를 멈추기 전에 해제해야 할 자원이 있다면, 이메서드에 그 코드를 작성하라
		System.out.println("destory()");
		
	}
	// Servlet 관리할 때 호출되는 메서드	
	// 4) Servlet Container 가 관리자 화면에서 서블릿 이름을 출력할때 호출하는 메서드
	@Override
	public String getServletInfo() {
	// 보통 서블릿에 대해 이름이나 간단한 설명을 출력한다.
		return null;
	}
	
	// 5) Servlet Container 또는 내부에서 서블릿 설정 정보를 다룰떄 호출하는 메서드
	// =>	이메서드는 ServletConfing 객체를 리턴.
	// =>	보통 init()에서 파라미터 받은 객체를 그대로 리턴한다.
	//		ServletConfig 객체는 new 연산자로 임의적으로 만들수 없다. 
	@Override
	public ServletConfig getServletConfig() {		
		return this.config;
	}
		
}
/* 서블릿을 WAS(톰켓)에 배치한다(deploy)
 *	- pc에 프로그램을 배치하는 것을 보통 "install" 또는 "setup" 이라고 표현한다.
 * 		배치 장소는 "c: program files" 폴더 이다.
 * 	- WAS에 웹 애플리케이션을 배치 하는 것을 "deploy" 라고 한다.
 * 		배치 장소는 WAS에 따라 다르다. 문서를 확인하라
 * 		톰캣의 경우, "톰캣설치폴더/webapps" 이다.
 * 
 * - 배치 작업
 * 		1) webapps 폴더 안에 웹 애플리케이션 폴더 를 생성한다.
 * 		2) 웹 애플리케이션 폴더 밑에 "WEB-INF/classes"폴더 를 생성  
 * 		3) 컴파일된 클래스 파일을 classes 폴더에 둔다
 * 		4) 배치하는 서블릿 클래스에 대한 정보를 "배치 기술서(Deploy Descriptor)" 파일에 기록한다.
 * 			 => WEB-INF/web.xml
 * 			 => web.xml 파일은 기존에 있는 예제 웹 애플리케이션 폴더에서 복사해 사용하라                            
 */
