<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <c:choose>
	<c:when test="${param.cnt > 0 }">
		<script>
			alert("수정 완료");
			location.href = "/admin/notice";
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("수정 중 문제가 발생했습니다. 다시 시도해주세요.\n만일 문제가 계속될 경우 고객센터(02-1234-5678)로 연락해주세요.");
			history.back();
		</script>
	</c:otherwise>
</c:choose>



