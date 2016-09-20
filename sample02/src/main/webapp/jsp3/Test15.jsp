<%@page import="vo.Board"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>


<jsp:useBean id="board" class="vo.Board" scope="application"/>
<jsp:setProperty name="board" property="no" value="10"/>
<jsp:setProperty name="board" property="title" value="제목이요"/>
<jsp:setProperty name="board" property="contents" value="sdakfja;l"/>
<jsp:setProperty name="board" property="viewCount" value="15"/>

게시물 : <%=board%>
JspContext : ${pageScope.board}
ServletRequst : ${requestScope.board}
HttpSession : ${sessionScope.board}
ServletContext : ${applicationScope.board}

저장소 (범위)를 지정하는 객체 이름을 생략하면 다음 순서대로 찾는다.
pageScope --> reqeustScope --> sessionScope --> applicationScope -> null 
=>${board}

<%--

Expression Language
=> ${OGNL 표기법}, #{OGNL 표기법}

=> OGNL (Object Graph Navigation Language)
  - 객체의 피러퍼티를 찾아가는 표기법
  - 예를 들면, 파일 경로 와 비슷 하다. 
  - 객체명.프로퍼티명.프러퍼티명.프러퍼티명


EL에서 기본으로 제공하는 객체들
pageContext :  PageContext
servletContext : ServletContext 
session     : HttpSession
request     : ServletRequest
response    : ServletResponse
param       : request.getParameter()
paramValue  : request.getParameterValues()
header      : request.getHeader()
headerValue : 헤더의 값들을 담은 객체
cookie      : 쿠키의 정보를 담은 객체
initParam   : cofing.getInitparameter()

 --%>