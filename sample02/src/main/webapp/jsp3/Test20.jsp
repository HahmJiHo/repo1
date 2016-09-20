<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>


<%-- 객체, 배열, List, Map 에서 값 꺼내는 방법 --%>
<%
HashMap<String, String> nameMap = new HashMap<String, String>();
nameMap.put("s01","뀨~");
nameMap.put("s02","뀨뀨~");
nameMap.put("s03","꺄~");
nameMap.put("s04","꺄꺄~");
nameMap.put("s-5","123213꺄꺄~");
pageContext.setAttribute("nameMap", nameMap);
%>

\${nameMap["s01"]} : ${nameMap["s01"]}
\${nameMap["s02"]} : ${nameMap["s02"]}
${nameMap["s02"]}${nameMap['s03']}
${nameMap.s02}${nameMap.s04}
\${nameMap['s-5']} : ${nameMap['s-5']}