<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="uId_Session" value = "${sessionScope.uId_Session}" />
<!--
MemberMgr에서 세션을 사용하여 해당 회원의 정보를 반환하는 메서드를 생성하고 
memberMod.jsp 페이지에서 출력 항목에 맞도록 출력합니다.
탈퇴를 처리하는 메서드를 생성하여 처리합니다.
JavaScript파일을 기존 회원가입소스를 활용할 것인지 새롭게 만들것인지도 결정하고
회원정보수정이 정상적으로 처리될 수 있도록 작업합니다.
 -->    

 
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원정보수정</title>
	<link rel="stylesheet" href="/resources/style/style_Common.css">
	<link rel="stylesheet" href="/resources/style/style_Template.css">
	<script src="/resources/source/jquery-3.6.0.min.js"></script>
	<script src="/resources/script/script_Join.js"></script>
</head>

<body>
    <div id="wrap">
    	
    	<!--  헤더템플릿 시작 -->
		<%@ include file="/ind/headerTmp.jsp" %>
    	<!--  헤더템플릿 끝 -->    	
    	
    	
    	<main id="main" class="dFlex">
    		
	    	<!-- 실제 작업 영역 시작 -->
    		<div id="contents" class="joinInsert">
    		
    			<form name="regFrm" id="regFrm" method="post">
    				<table id="regFrmTbl">
    					<caption>회원 정보 보기</caption>
    					<tbody>
    						<tr>
    							<td class="req">아이디</td>
    							<td>${Obj.uId}</td>
    							<td>&nbsp;</td>
    						</tr>
    						<tr>
    							<td class="req">이름</td>
    							<td>
    								${Obj.uName}
    							</td>
    						</tr>
    						<tr>
    							<td class="req">Email</td>
    							<td>
	    							<span>${fn:split(Obj.uEmail,'@')[0]}</span>
    								<span>@</span>
    								<span>${fn:split(Obj.uEmail,'@')[1]}</span>
    								<input type="hidden" name="uEmail" id="uEmail">
    							</td>
    						</tr>
    						<tr>
    							<td>성별</td>
    							<td>
    								<label>
    									<c:if test="${Obj.gender == 1}">
    									 	남
    									</c:if>
    									<c:if test="${Obj.gender == 2}">
    									 	여
    									</c:if>
    								</label>
    							</td>
    							<td>&nbsp;</td>
    						</tr>
    						<tr>
    							<td>생년월일</td>
    							<td>
    								${Obj.uBirthday}
    							</td>
    							<td>&nbsp;</td>
    						</tr>
    						<tr>
    							<td>주소</td>
    							<td>    								
    								${Obj.uAddr }
    							</td>
    						</tr>
    						<tr>
    							<td>취미</td>
    							<td>    		
    								<label>
    									 	<c:if test="${fn:substring(Obj.uHobby,0,1) eq'1'}">
				                                  인터넷
				                              </c:if>
				                              <c:if test="${fn:substring(Obj.uHobby,1,2) eq'2'}">
				                                  여행
				                              </c:if>
				                              <c:if test="${fn:substring(Obj.uHobby,2,3) eq'3'}">
				                                  게임
				                              </c:if>
				                              <c:if test="${fn:substring(Obj.uHobby,3,1) eq'4'}">
				                                  영화
				                              </c:if>
				                              <c:if test="${fn:substring(Obj.uHobby,0,1) eq'5'}">
				                                  운동
				                              </c:if>
    								</label>						
    						<tr>
    							<td>직업</td>
    							<td>    								
    								<select name="uJob" id="uJob" class="frmDropMenu">
    									<option value=""> - 선택 - </option>
    									<option
    										<c:if test="${Obj.uJob== '교수' }">
    											selected="selected"
    										</c:if>
    									>교수</option>
    									<option
    									<c:if test="${Obj.uJob== '학생' }">
    									 	selected="selected"
    									</c:if>
    									>학생</option>
    									<option
    									<c:if test="${Obj.uJob== '회사원' }" > selected="selected"</c:if>
    									>회사원</option>
    									<option
    									<c:if test="${Obj.uJob== '공무원' }" > selected="selected"</c:if>
    									>공무원</option>
    									<option
    									<c:if test="${Obj.uJob== '자영업' }" > selected="selected"</c:if>
    									>자영업</option>
    									<option
    									<c:if test="${Obj.uJob== '전문직' }" > selected="selected"</c:if>
    									>전문직</option>
    									<option
    									<c:if test="${Obj.uJob== '주부' }" > selected="selected"</c:if>
    									>주부</option>
    									<option
    									<c:if test="${Obj.uJob== '무직' }" > selected="selected"</c:if>
    									>무직</option>
    								</select>
    							</td>
    							<td></td>
    						</tr>
    						<tr>
    							<td colspan="3">
    								<a href="javascript:history.back();">
										<button type="button" id="backBtn">회원 리스트</button>		
									</a>
    							</td>
    						</tr>
    					</tbody>
    				</table>
    			</form>
    			<!-- form[name=regFrm] -->
    		</div>
    		<!-- 실제 작업 영역 끝 -->
    	</main>
    	<!--  main#main  -->
    	<!--  푸터템플릿 시작 -->
		<%@ include file="/ind/footerTmp.jsp" %>
    	<!--  푸터템플릿 끝 -->  
    </div>
    <!-- div#wrap -->
</body>

</html>