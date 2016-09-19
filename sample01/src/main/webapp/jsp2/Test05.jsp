<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%
ArrayList list = new ArrayList();
%>
<%-- 아주 멋진 태그!!!!  객체를 생성해 주는 태그!! --%>
<jsp:useBean id="list2" class="java.util.ArrayList"></jsp:useBean>

list의 크기 : <%=list.size()%>
list2의 크기 : <%=list2.size() %>
