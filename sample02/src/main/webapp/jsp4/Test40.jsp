<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
[c:rediret]
- Redirect 수행하기


<c:choose>
  <c:when test="${param.home == 'naver'}"><c:redirect url="http://www.naver.com"/></c:when>
  <c:when test="${param.home == 'daum'}"><c:redirect url="http://www.daum.net"/></c:when>
  <c:when test="${param.home == 'google'}"><c:redirect url="http://www.google.com"/></c:when>
  <c:otherwise>유효하지 않는 홈페이지 입니다요</c:otherwise>
</c:choose>