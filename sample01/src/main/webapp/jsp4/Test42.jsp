<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
[fmt:formatDate]
- java.util.Date ----> 문자열

<%
Date today = new Date();
pageContext.setAttribute("today", today); // 저장소를 지정하지 않으면 기본이 pageContext
%>


<fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/>,

<fmt:formatDate value="${today}" pattern="MM/dd/yyyy"/>

