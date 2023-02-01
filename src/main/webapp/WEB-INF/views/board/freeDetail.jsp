<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/resources/js/common.js"></script>
<head>
<title>소수 자유게시판</title>
</head>
<link rel="icon" href="data:;base64,iVBORw0KGgo=">	
<input type="hidden" name="FR_IDX" value="${FR_IDX }">
<table class="board_view">
	<tbody>
			<tr>
				<th scope="row">자유 No.</th> 
				<td id="FR_IDX">${map.FR_IDX }</td>
				<th scope="row">작성자</th>
				<td>${map.FR_WRITER }</td>	 
			</tr>
			<tr>
				<th scope="row">작성일</th> 
				<td>${map.FR_REGDATE }</td>
				<th scope="row">수정여부</th>
				<td>${map.RE_MOD_YN }</td>	
			</tr>
			<tr>
				<th scope="row">카테고리</th>
				<td>${map.FR_CATEGORY }</td>	
			</tr>
			<tr>
				<th scope="row">제목</th>
				<td>${map.FR_TITLE }</td>			
			</tr>
			<tr>
				<th scope="row">내용</th> 
				<td colspan="3" style="white-space: pre-wrap;">${map.FR_CONTENT }</td>
			</tr>
<!--		<tr> -->
<!-- 			<th scope="row">첨부파일</th> -->
<!-- 			<td colspan="3"> -->
<%-- 				<c:forEach var="row" items="${!empty map }"> --%>
<!-- 				<div> -->
<%-- 					<input type="hidden" id="F_ARTICLE" value="${row.F_ARTICLE }"> --%>
<%-- 					<a href="#this" name="file">${row.F_SVNAME }</a> --%>						
<%-- 						(${row.F_SIZE}kb)<br> --%>
<!-- 				</div> -->
<%-- 				</c:forEach> --%>				
<!-- 			</td> -->
<!-- 		</tr> -->	
	</tbody>
	<tfoot>
		<tr>
			<td>
				<a href="/freeboard/${map.FR_CATEGORY }.sosu" class="btn normal">목록으로</a>
				
				<a class="use_move btn" href="/freeboard/updateForm/${FR_CATEGORY}/${FR_IDX}.sosu" onclick="move(this, 'in', 'FR_IDX')">
					수정하기
					<input type="hidden" name="FR_IDX" value="${map.FR_IDX}">
				</a>
				<a class="use_move btn" href="/freeboard/deletefree.sosu" onclick="move(this, 'in', 'FR_IDX')">
					삭제하기
					<input type="hidden" name="FR_IDX" value="${map.FR_IDX }">
				</a>
				
			</td>
		</tr>
	</tfoot>
</table>