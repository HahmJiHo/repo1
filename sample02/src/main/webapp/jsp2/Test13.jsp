<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%-- 
 <jsp:include>
 => RequestDispatcher의 include() 코드를 생성한다.

자바코드
RequestDispathcer rd = request.getRequesetDispatcher("a.jsp");
rd.include(request, response);
 --%>
뀨뀨
<jsp:include page="header.jsp"></jsp:include>
내용....
<jsp:include page="footer.jsp"></jsp:include>
꺄꺄