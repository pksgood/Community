<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String uId_Session = (String) session.getAttribute("uId_Session");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="/resources/style/style_Common.css">
<link rel="stylesheet" href="/resources/style/style_Template.css">
<link rel="stylesheet" href="/resources/style/style_BBS.css">
<script src="/resources/source/jquery-3.6.0.min.js"></script>
<script src="/resources/script/script_Notice.js"></script>
</head>

<body>
	<div id="wrap">

		<!--  헤더템플릿 시작 -->
		<%@ include file="/ind/headerTmp.jsp"%>
		<!--  헤더템플릿 끝 -->

		<main id="main" class="dFlex">

			<div id="lnb">
				<!--  메인 LNB 템플릿 시작 -->
				<%@ include file="/ind/mainLnbTmp.jsp"%>
				<!--  메인 LNB 템플릿 끝 -->
			</div>


			<!-- 실제 작업 영역 시작 -->
			<div id="contents" class="bbsList">

				<c:set var="prnType" value="" />

				<c:if test="${empty keyWord}">
					<c:set var="prnType" value="전체 게시글" />
				</c:if>
				<c:if test="${!empty keyWord }">
					<c:set var="prnType" value="검색 결과" />
				</c:if>

				<div id="pageInfo" class="dFlex">
					<span>${prnType } : ${totalRecord } 개</span> <span>페이지 :
						${nowPage } / ${totalPage }</span>
				</div>
				<table id="boardList">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>이름</th>
							<th>날짜</th>
							<th>조회수</th>
						</tr>
						<tr>
							<td colspan="5" class="spaceTd"></td>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty list }">
							<tr>
								<td colspan="5">게시물이 없습니다.</td>
							</tr>
						</c:if>
						<c:if test="${!empty list }">
							<c:forEach var="dto" begin="${nowPage*5-5}" end="${nowPage*5-1}"
								items="${list }">
								<tr class="prnTr" onclick="read('${dto.num }', '${nowPage }')">
									<td><a href="/admin/read?num=${dto.num }">${dto.num }</a></td>
									<td>${dto.subject }</td>
									<td>${dto.uName }</td>
									<td>${dto.regTM }</td>
									<td>${dto.readCnt }</td>
								</tr>
							</c:forEach>
						</c:if>


						<tr id="listBtnArea">

							<td colspan="2">
								<form action="write" id="zz" method="get">
									<c:choose>
											<c:when
												test="${uId_Session eq 'admin' || uId_Session eq 'adminsub' }">
												<button type="button" id="writeBtn1" class="listBtnStyle">글쓰기</button>
											</c:when>
											<c:when
												test="${!uId_Session eq 'admin' || !uId_Session eq 'adminsub' }">
												<button type="hidden" id="writeBtn1" class="listBtnStyle">글쓰기</button>
											</c:when>
										</c:choose></td>
								</form>
							<td colspan="3">
								<form name="searchFrm" class="dFlex" id="searchFrm">
									<div>
										<select name="keyField" id="keyField" value="${keyField }">
											<option value="subject"
												<c:if test="${keyField eq 'subject' }">selected="selected"</c:if>>제
												목</option>

											<option value="uName"
												<c:if test="${keyField eq 'uName' }">selected="selected"</c:if>>이
												름</option>

											<option value="content"
												<c:if test="${keyField eq 'content' }">selected="selected"</c:if>>내
												용</option>
										</select>
									</div>
									<div>
										<input type="text" name="keyWord" id="keyWord" id="keyWord"
											size="20" maxlength="30" value="${param.keyWord }">
									</div>
									<div>
										<button type="button" id="searchBtn1" class="listBtnStyle">검색</button>
									</div>
								</form> <!-- 검색결과 유지용 매개변수 데이터시작 --> <input type="hidden"
								name="keyField" id="pKeyField" value="${param.keyField }" /> <input
								type="hidden" name="keyWord" id="pKeyWord"
								value="${param.keyWord }" /> <!-- 검색결과 유지용 매개변수 데이터끝 -->

							</td>
						</tr>
						<!-- tr#listBtnArea -->

						<tr id="listPagingArea">

							<!-- 페이징(= 페이지 나누기) 시작 -->
							<td colspan="5" id="pagingTd">
								<%

								%> <c:if test="${totalPage != 0 }">
									<!--  전체 페이지가 0이 아니라면 = 게시글이 1개라도 있다면 -->
									<c:if test="${nowBlock > 1 }">
										<span class="moveBlockArea"
											onclick="moveBlock('${nowBlock-1 }', '${blockSize }')">
											&lt; </span>
									</c:if>
									<c:if test="${nowBlock <= 1 }">
										<span class="moveBlockArea"></span>
									</c:if>

									<!-- 페이지 나누기용 페이지 번호 출력 시작  -->
									<c:forEach var="i" begin="${firstPage}" end="${totalPage}">
										<c:if test="${i == nowPage }">
											<span class="nowPageNum"> ${i } </span>
										</c:if>
										<c:if test="${i != nowPage }">
											<span class="pageNum" onclick="movePage('${i}')"> ${i }
											</span>
										</c:if>
									</c:forEach>

									<!-- 페이지 나누기용 페이지 번호 출력 끝  -->

									<c:if test="${totalBlock > nowBlock }">
										<span class="moveBlockArea"
											onclick="moveBlock('${nowBlock+1 }', '${blockSize }')">
											&gt; </span>
									</c:if>
									<c:if test="${totalBlock <= nowBlock }">
										<span class="moveBlockArea"></span>
									</c:if>

								</c:if> <c:if test="${totalPage == 0 }">
						[ Paging Area ]
					</c:if>

							</td>
						</tr>

					</tbody>
				</table>


			</div>
			<!-- 실제 작업 영역 끝 -->

		</main>
		<!--  main#main  -->
		<!--  푸터템플릿 시작 -->
		<%@ include file="/ind/footerTmp.jsp"%>
		<!--  푸터템플릿 끝 -->
	</div>
	<!-- div#wrap -->

</body>

</html>