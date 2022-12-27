<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
	table#c_list{
		width: 740px;

	}
</style>
<br>

	<table id="c_list">
					<thead>
						<tr>
							<th style="width: 10%">번호</th>
							<th style="width: 15%">이름</th>
							<th style="width: 50%;">내용</th>
							<th style="width: 25%">날짜</th>
						</tr>
						<tr>
							<td colspan="5" class="spaceTd"></td>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty list }">
							<tr>
								<td colspan="5">댓글이 없습니다.</td>
							</tr>
						</c:if>
						<c:if test="${!empty list }">
							<c:forEach var="dto" begin="0" end="${list.size()}" items="${list }">
								<tr class="">
									<td style="text-align: center">${dto.co_num }</td>
									<td style="text-align: center">${dto.uName }</td>
									<td>${dto.content }</td>
									<td>${dto.regTM }</td>
								</tr>
							</c:forEach>
						</c:if>
						
						
					</tbody>
				</table>
