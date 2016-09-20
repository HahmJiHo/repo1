<%@page import="vo.Board"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>


<%-- 객체, 배열, List, Map 에서 값 꺼내는 방법 --%>

<jsp:useBean id="board" class="vo.Board" scope="page"/>
<jsp:setProperty name="board" property="no" value="10"/>
<jsp:setProperty name="board" property="title" value="제목이요"/>
<jsp:setProperty name="board" property="contents" value="sdakfja;l"/>
<jsp:setProperty name="board" property="viewCount" value="15"/>


\${board} : ${board}
\${board.getNo()} : ${board.getNo()}
\${board.no} : ${board.no}
\${board["no"]} : ${board["no"]}
\${board['title']} : ${board["title"]}
