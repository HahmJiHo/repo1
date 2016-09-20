<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
템플릿데이터 1
템플릿데이터 2
<%
String name = "호옹~";
%>
템플릿데이터 3
<%= name %>
템플릿데이터 4
템플릿데이터 5

<%-- expression 엘리먼트  (표현식 ) 
<%= expression %>
=> expression? 값을 리턴하는 자바 코드

예)
 <%= plus (20, 10) %>
 <%= name %> 
 <%= 20 + 2 %> 
 
 JSP 엔진이 하는 일.
 <%= expression %> ----------> out.print(expression)
 
 <%= name %>
 out.print(name);
 잘못 사용한 예 
 <%= if(...) {} %>
 => out.print( if(....) {} );
 
  
--%>