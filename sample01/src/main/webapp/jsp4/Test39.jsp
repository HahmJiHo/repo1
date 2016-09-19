<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
[c:import]
- HTTP 요청 가져오기 
<%--

https://search.naver.com/search.naver?where=nexearch&ie=utf8&query=java&sm=tab_stc

https://search.naver.com/search.naver?where=nexearch&query=java&sm=top_hty&fbm=1&ie=utf8

--%>
<c:url var="testUrl" value="https://search.naver.com/search.naver">
  <c:param name="where" value="nexearch"/>
  <c:param name="query" value="java"/>
  <c:param name="sm" value="top_hty"/>
  <c:param name="fbm" value="1"/>
  <c:param name="ie" value="utf8"/>
</c:url>

<%-- 변수명을 지정하지 않으면 바로 출력 --%>
<c:import url="${testUrl}"/>

