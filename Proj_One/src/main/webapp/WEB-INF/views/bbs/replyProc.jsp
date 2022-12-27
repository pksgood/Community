
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
/* int repUpCnt = bMgr.replyUpBoard(reBean.getRef(), reBean.getPos());
     // 끼어들기가 아닐경우 실행되는 소스 없음.
     
int repInsCnt = bMgr.replyBoard(reBean);

String nowPage = request.getParameter("nowPage");
String keyField = request.getParameter("keyField");
String keyWord = request.getParameter("keyWord"); */
%>

<c:choose>
	<c:when test="${cnt > 0 }">
		<script>
			alert("답변글 작성 완료~!");
			location.href = "/bbs/list";
		</script>
	</c:when>
	<c:otherwise>
		<script>
		let msg = "답변글 등록중 오류가 발생했습니다.\n";
	     msg += "다시 시도해주세요\n";
	     msg += "오류가 지속되면 관리자에게 연락바랍니다.";
			alert(msg);
			history.back();
		</script>
	</c:otherwise>
</c:choose>

<!-- if(repInsCnt > 0) { 
	// replayUpBoard( )와 replyBoard( )가 정상실행되었음을 의미함.
	
	String url = "/bbs/list.jsp?nowPage="+nowPage;
	url += "&keyField="+keyField;
	url += "&keyWord="+keyWord;
    -->
	
<%-- <%
} else {
%>	 --%>
