<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>


<%-- 객체, 배열, List, Map 에서 값 꺼내는 방법 --%>
<%
ArrayList<String> names = new ArrayList<String>();
names.add("배고파 뭐먹지");
names.add("순대국");
names.add("라멘");
names.add("짬뽕");
names.add("뼈해장국");
pageContext.setAttribute("names", names);
%>

\${names} : ${names}
\${names[2]} : ${names[2]}

