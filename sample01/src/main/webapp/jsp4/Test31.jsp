<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
[c:choose]
- 여러 조건 테스트 

<c:set var="age" value="100"/>

<c:choose>
  <c:when test="${age <19}">미성년</c:when>
  <c:when test="${age >=19 && age < 50 }">청년</c:when>
  <c:when test="${age >=50 && age < 65 }">중년</c:when>
  <c:otherwise>노인</c:otherwise>
</c:choose>
