<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <c:choose>
	<c:when test="${param.bool == true }">
		<script>
			alert("수정 완료");
			location.href = "/bbs/list";
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("수정 중 문제가 발생했습니다. 다시 시도해주세요.\n만일 문제가 계속될 경우 고객센터(02-1234-5678)로 연락해주세요.");
			history.back();
		</script>
	</c:otherwise>
</c:choose>


<!-- //검색어 수신 시작
String keyField = 
String keyWord = 
String nowPage = request.getParameter("nowPage");
 -->

<%-- 
<%

if (exeCnt > 0) {
	String url = "/bbs/read.jsp?nowPage="+nowPage;
			 url += "&num="+upBean.getNum();
			 url += "&keyField="+keyField;
			 url += "&keyWord="+keyWord;
	
	//out.print("url : " + url);	 
	//response.sendRedirect(url);   <= 한글 전송 오류 발생
%>		
	 <script>
	 	location.href="<%=url%>";
	 </script>
<%		
} else {
%>		
	<script>
		alert("DB처리중 오류가 발생했습니다.\n문제가 계속되면 관리자에게 연락바랍니다.");
		history.back();
	</script>

<%
}	
%> --%>

