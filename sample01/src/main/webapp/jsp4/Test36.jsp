<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
[c:forTokens]
- 반목문 

[배열과 반복문]
<%
pageContext.setAttribute("names", 
		"홍길동,유관순,윤봉길,안창호,신채호,임꺽정");

%>
<c:forTokens items="${names}" var="name" delims=",">
${name}:
</c:forTokens>