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

[Map 객체와 반복문]
<%
HashMap<String, String> nameMap = new HashMap<String, String>();
nameMap.put("n1","홍길동");
nameMap.put("n2","윤봉길");
nameMap.put("n3","임꺽정");
nameMap.put("n4","신채호");

pageContext.setAttribute("nameMap",nameMap);

%>
<c:forEach items="${nameMap}" var="keyValue">
${keyValue},
</c:forEach>