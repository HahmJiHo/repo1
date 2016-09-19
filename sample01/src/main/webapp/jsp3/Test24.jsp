<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%
pageContext.setAttribute("name", "홍길동");
%>
[ empty 연산자 ]
<%-- 없냐고 물어보는..
null 이면 true
null 이 아니면 false;
--%>
\${empty name} : ${empty name}
\${empty name2} : ${empty name2}

[조건 연산자 사용하기]

\${10 > 20 ? "크다" : "작다"} : ${10 > 20 ? "크다" : "작다"}