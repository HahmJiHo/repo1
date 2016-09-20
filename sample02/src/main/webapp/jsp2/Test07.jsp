<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%-- 아주 멋진 태그!!!!  객체를 생성해 주는 태그!! 
id: 객체의 래퍼런스 이름 
class : 객체를 생성할 때 사용할 전체 클래스명(패키지명 포함 : fully-qualified class name; FQName; QName;)
--%>
<jsp:useBean id="board" class="vo.Board"></jsp:useBean>

<%-- 객체를 생성할 때 러퍼티 (게터/세터) 값 설정 가능 
name : 객체 레퍼런스 이름
property : 셋터 이름 (set을 제외 하고 첫 알파벳 소문자 이름 )
value : 셋터 메서더를 호출할 때 넘겨줄 값. 문자열을 원시타입으로 자동 변환 한다.
--%>
<jsp:useBean id="board2" class="vo.Board">
  <jsp:setProperty name="board2" property="no" value="1"/>
  <jsp:setProperty name="board2" property="title" value="게이왕 섹승도"/>
  <jsp:setProperty name="board2" property="contents" value="울트라 게이 섹승도"/>
  <jsp:setProperty name="board2" property="viewCount" value="100"/>
</jsp:useBean>

<%-- 객체 생성후 프로퍼티 값 설정 태그 사용 가능 --%>
<jsp:useBean id="board3" class="vo.Board"></jsp:useBean>
<jsp:setProperty name="board3" property="no" value="2"/>
<jsp:setProperty name="board3" property="title" value="하하하2"/>
<jsp:setProperty name="board3" property="contents" value="내용 222"/>
<jsp:setProperty name="board3" property="viewCount" value="200"/>

board : <%=board%>
board2 : <%=board2%>
board3 : <%=board3%>

