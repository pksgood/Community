<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core"%>    
<style>
	body{
		/* display: flex; */
	}
	textarea{
		justify-content: left;
		font-size: 15px;
	}
	button#asc{
		justify-content: right;
		float: right;
		margin-right: 72px;
		height: 30px;
		width: 100px;
	}
</style>


	<h3>Comments.</h3>
	<c:if test="${empty uId }">
		<textarea rows="4px" cols="90px" readonly>로그인 후 작성 가능합니다.</textarea>
	</c:if>
	<form action="/bbs/insertCom" method="post">
	<c:if test="${!empty uId }">
		<textarea rows="4px" cols="90px" name="content"></textarea>
	</c:if>
	<input type="hidden" name="num" value = "${param.num }"/>
	<input type="hidden" name="uId" value = "${uId }"/>
	<input type="hidden" name="uName" value="${uName}"/>
	
	<button type="submit" id="asc">등록</button>
	<br><br>
</form>