<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%-- 
 <jsp:forward page="">
 => RequestDispatcher의 include() 코드를 생성한다.

자바코드
RequestDispathcer rd = request.getRequesetDispatcher("a.jsp");
rd.forward(request, response);
 --%>
뀨뀨
<jsp:forward page="header.jsp"/>
내용....
<jsp:forward page="footer.jsp"/>
꺄꺄