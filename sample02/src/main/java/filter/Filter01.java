/*  필터 만드는 방법과 구동 원리
 * 	=> javax.servlet.Filter 인터페이스 구현
 *
 * 	init() 
 * 		- 필터가 객체를 생성한 후 자동으로 호출되는 메서드
 * 		- 필터가 작업할 때 사용할 자원을 준비시키는 코드를 둔다.
 * 
 * 	doFiter()
 * 		- 필터가 적용될 때 마다 호출하는 메서드
 * 		- 서블잇의 service() 메서드를 호출 하기 전에 해야할 작업이나
 * 			호출한 후에 해야할 작업을 둔다.
 *  destroy() 
 *  	- 피렅가 사용하가 위한 자원을 해제
 *  
 *  => 필터를 DB 파일(Deployment Descriptor 파일 -> web.xml) 에 등록한다.
 */
package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
//@WebFilter("/Servlet16")
public class Filter01 implements Filter{
	FilterConfig config;
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config; 
		System.out.println("Filter01.init()..");
	}
 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain nextFilter)
			throws IOException, ServletException {
				System.out.println("Filter01.doFilter() : tservice() 호출 하기 전에 수행할 작업.");

				// 다음에 실행할 필터가 있다면 그 필터를 실행한다. 
				// 만약 다음 필터가 없다면, 서블릿의 service()를 호출한다.
				nextFilter.doFilter(request, response);
				
				System.out.println("Filter01.doFilter() : service() 호출한 후에 수행할 작업");
	}
	
	@Override
	public void destroy() {
		System.out.println("Filter01.destory()..");
		
	}
	
	
	
}
/*
 * 필터의 구동원리
 * 1) 웹 애플리케이션이 시작 되면 
 * 2)	웹 애플리케이션에 등록된 필터 객체가 생성 및 생성자 호출
 * 3) 웹 애플리케이션에 등록된 서블릿 중에서 <load-on-startup>이 선언된 
 * 		서블릿 객체 생성 및 생성자 호출, init() 호출
 * 4) 서블릿 요청 
 * 		=> 그 경로에 설정된 필터 실행(doFilter() 호출됨)
 * 		=> 다음 필터 실행..
 * 		=> 더이상 실행할 필더가 없다면 서블릿의 service() 호출
 *		=> 거꾸로 필터로 리턴함.
 *		=> 이전 필터가 없을 때 까지 계속 리턴... 
 * 		
 * 
 * 
 */

