<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>


<%-- 
<jsp:useBean> 의 scope 속성 
=> 객체를 꺼내거나 저장할 때 사용할 저장소 (scope)를 지정하는 속성이다.
=> 저장소를 지정하지 않으면 기본이 pageContext 이다.
   즉 해당 JSP 페이지 에서만 사용 가능하다.

=> 값 
   page         :   PageContext 저장소 (기본)
   request      :   ServletRequest 저장소
   session      :   HttpSession 저장소
   application  :   ServletContext 저장소   
--%>
<jsp:useBean id="board" class="vo.Board" scope="page"></jsp:useBean>
<%--
위 태그를 자바코드로 표현: 
vo.Board board = null;
if (pageContext.getAttribute("board") != null { // 기본으로 JspContext 에서 찾는다.
  board = (vo.Board)pageContext.getAttribute("board");
} else {
  board = new vo.Board();
  pageContext.setAttribute("board",board); // JspContext에 보관한다.
}
--%>

board : <%=board%>
JspContext : <%=pageContext.getAttribute("board", pageContext.PAGE_SCOPE)%>
board == JspContext : <%=pageContext.getAttribute("board", pageContext.PAGE_SCOPE) == board %>
Servletrequest : <%=request.getAttribute("board") %>
HttpSession : <%=session.getAttribute("board") %>
ServletContext : <%=application.getAttribute("board") %>


