<%@page import="vo.Board"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%-- 
  <jsp:useBean> 의 type 과 class 속성 동시 사용
  type => 레퍼런스 변수 만들때 사용 
  class => 객체 생성할 때 사용
           - 따라서 인터페이스를 선언할수 없다.
           - 이속성에서는 Generic을 사용할수 없다.

 --%>
<jsp:useBean id="list" 
             type="java.util.List<String>"
             class="java.util.ArrayList" scope="request"></jsp:useBean>
<%--

 --%>

ServletRequest : <%=request.getAttribute("list") %>


