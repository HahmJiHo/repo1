<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
[fmt:parseDate]
- 문자열 ---> java.util.Date 객체로 변환

<c:set var="date1" value="2016-9-8"/>

<fmt:parseDate value="${date1}" pattern="yyyy-MM-dd" var="dateObj1"/>

<%=pageContext.getAttribute("dateObj1")%>,

<fmt:parseDate value="2016-09-09" pattern="yyyy-MM-dd" var="dateObj2"/>
${dateObj2},

<fmt:parseDate value="9/30/2016" pattern="MM/dd/yyyy" var="dateObj3"/>
${dateObj3},

