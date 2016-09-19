<%@page import="vo.Board"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>


<%-- 객체, 배열, List, Map 에서 값 꺼내는 방법 --%>
<%
pageContext.setAttribute("names", new String[]{"우동","초밥","순대국","배고팡"});
%>


\${names} : ${names}
\${names[2]} : ${names[2]}

