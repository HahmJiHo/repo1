<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
[c:forEach]
- 반목문 

[List 객체와 반복문]
<%
ArrayList<String> names = new ArrayList<String>();
names.add("홍길동");
names.add("윤봉길");
names.add("임꺽정");
names.add("신채호");

pageContext.setAttribute("names",names);

%>
<c:forEach items="${names}" var="name">
${name},
</c:forEach>