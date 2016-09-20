<%@page import="vo.Board"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%

Board obj = new Board();
obj.setNo(10);
obj.setTitle("10adsfasdfa:");
obj.setContents("10");
obj.setViewCount(10);

request.setAttribute("board", obj);
%>

<%-- 
  <jsp:useBean> 의 type 속성
  객체를 만들지 않고 꺼내고만 싶을 떄 사용한다.
  type으로 지정된 클래스는 레퍼런스 변수 를 생성할 때 사용한다.
  객체를 생성하지 않는다. 
  
  => 만약 지정된 저정소에서 객체를 찾지 못하면 예외~~ 
 --%>
<jsp:useBean id="board" type="vo.Board" scope="request"></jsp:useBean>
<%--
vo.Board board = request.getAttribute("board")
board가 null 이라 하더라도 객체를 생성하지 않는다.
 --%>

board : <%=board%>
Servletrequest : <%=request.getAttribute("board") %>


