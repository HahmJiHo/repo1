<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
[c:set]
- 변수를 만드는 태그
<%--
<c:set var="변수명" value="값" scope="저장소"/>
 --%>

<c:set var="name" value="임꺽정" scope="page"/>
<c:set var="name2" value="유관순"/>
<c:set var="name3" scope="application">윤봉길</c:set>
${pageScope.name}, ${name},

${pageScope.name2} , ${name2},

${applicationScope.name3} , ${name3}
