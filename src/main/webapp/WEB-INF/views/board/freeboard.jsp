<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/WEB-INF/include/include-header.jspf"%>
<html>
<head>
<title>소수 자유게시판</title>
</head>
<body>
<h1>자유게시판</h1>
<div align="right">
	<c:if test="${!empty M_EMAIL }">
		<tr> 
			<td>
				<a class="use_move" href="/freeboard/insertForm/${FR_CATEGORY }.sosu" onclick="move(this, 'in', 'FR_IDX', 'FR_CATEGORY', 'M_NICKNAME')" >
					글쓰기
				</a>
			</td>
		</tr>
	</c:if>
</div>
<table style="border:1px solid #ccc">
	<colgroup>
		<col width="10%"/>
		<col width="10%"/>
		<col width="*"/>
		<col width="10%"/>
		<col width="10%"/>
		<col width="20%"/> 
	</colgroup>
	<thead>
		<tr>
			<th scope="col">자유 No.</th>
			<th scope="col">메인이미지</th>
			<th scope="col">제목</th>
			<th scope="col">작성자</th>
			<th scope="col">추천</th>
			<th scope="col">등록날짜</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${!empty list }">
				<c:forEach items="${list }" var="map" >
					<tr align="center" onclick="location.href='/freeboard/${map.FR_CATEGORY }/${map.FR_IDX }.sosu'" >	
						<td>${map.FR_IDX }</td>
						<td>${map.F_SVNAME }</td>
						<td>${map.FR_TITLE }</td>
						<td>${map.M_NICKNAME }</td>
						<td>${map.FRZ_COUNT }</td>
						<td>${map.FR_REGDATE }</td>
						<td>
						<input type="hidden" name="FR_IDX" value="${map.FR_IDX }">
						<input type="hidden" name="M_NICKNAME" value="${map.M_NICKNAME }">
						<input type="hidden" name="FR_CATEGORY" value="${map.FR_CATEGORY }">
						<input type="hidden" name="M_IDX" value="${map.M_IDX }">
						</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="3">조회된 결과가 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>	
	</tbody>
</table>
</body>
</html>