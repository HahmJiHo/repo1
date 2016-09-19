<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
[c:out]
- 출력문을 만드는 태그
<%
pageContext.setAttribute("name", "홍길동");
%>
<c:out value="${name} 님 안녕하세용"/>,
<c:out value="${'okok'}"/>,
<c:out value="${name2}"/>,
<c:out value="${name2}" default="기본값"/>,
<c:out value="${name2}">기본값2</c:out>,
