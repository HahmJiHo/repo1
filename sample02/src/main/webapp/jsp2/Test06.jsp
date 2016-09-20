<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%-- 아주 멋진 태그!!!!  객체를 생성해 주는 태그!! 
id: 객체의 래퍼런스 이름 
class : 객체를 생성할 때 사용할 전체 클래스명(패키지명 포함 : fully-qualified class name; FQName; QName;)


--%>
<jsp:useBean id="board" class="vo.Board"></jsp:useBean>

게시물 : <%=board%>   => out.print(board); 