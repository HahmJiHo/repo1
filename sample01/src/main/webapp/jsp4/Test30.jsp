<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
[c:if]
- 조건문
<%--
<c:if test="조건식" var="변수명" scope="저장소">
콘텐츠
</c:if>
 --%>

 <c:if test="${10 > 8}" var="result" scope="page">
 하하하
 </c:if>
 테스트 결과 : ${result},
  <c:if test="${10 < 8}" var="result2" scope="page">
 호호호
 </c:if>
 
  
 테스트 결과 : ${result2}