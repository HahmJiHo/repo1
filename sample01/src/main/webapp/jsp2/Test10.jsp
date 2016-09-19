<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>


<%-- 
  request/session/application
 --%>
<jsp:useBean id="board" class="vo.Board" scope="request"></jsp:useBean>

board : <%=board%>
JspContext : <%=pageContext.getAttribute("board", pageContext.PAGE_SCOPE)%>
board == JspContext : <%=pageContext.getAttribute("board", pageContext.PAGE_SCOPE) == board %>
Servletrequest : <%=request.getAttribute("board") %>
HttpSession : <%=session.getAttribute("board") %>
ServletContext : <%=application.getAttribute("board") %>


