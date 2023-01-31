<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/WEB-INF/include/include-header.jspf"%>

<div class="container">
	<h3>게시글 수정하기</h3>
</div>
<form id="frm" enctype="multipart/form-data" method="post">
<table class="board_view">
	<tbody>
		<tr>
			<th scope="row">자유No.</th>
			<td colspan="4">
				${map.FR_IDX}
				<input type="hidden" id="FR_IDX" name="FR_IDX" value="${map.FR_IDX }">
			</td>
		</tr>
		<tr>
			<th scope="row">작성자</th>
			<td colspan="4"> 
				${map.M_IDX }
			</td>
		</tr>
		<tr>
			<th scope="row">제목</th>
			<td colspan="4">
				<input type="text" id="FR_TITLE" name="FR_TITLE" value="${map.FR_TITLE }" placeholder="제목을 입력하세요">
			</td>	
		</tr>	
		<tr>
			<th scope="row" style="width: 90px;">카테고리</th>
			<td colspan="4">
				${map.FR_CATEGORY }
			</td>	
		</tr>
		<tr>
			<th>내용</th>
			<td class="view_text" colspan="4">
				<textarea rows="20" cols="100" id="FR_CONTENT" name="FR_CONTENT" placeholder="내용을 입력하세요" style="height:300px">${map.FR_CONTENT }</textarea>
			</td>
		</tr>
	</tbody>
</table>
<div id="fileDiv" align="center">
	<p>
		<input type="file" id="file" name="file_0">
		<a href="#this" class="btn" id="delete" name="delete">삭제</a>
	</p>
</div>
<div align="center">
	<a href="#this" class="btn" id="addFile">파일 추가</a>
	<a href="#this" class="btn" id="update">수정하기</a>
</div>
</form>		
<script type="text/javascript">
	
	var gfv_count = 1;

	$(document).ready(function() {
		$("#update").on("click", function(e) { //수정하기 버튼
			e.preventDefault();
			fn_updatefree();
		});

		$("#addFile").on("click", function(e) { //파일추가 버튼
			e.preventDefault();
			fn_addFile();
		});

		$("a[name='delete']").on("click", function(e) { //삭제 버튼
			e.preventDefault();
			fn_deleteFile($(this));
		});

	});

	function fn_updatefree() {
		var comSubmit = new ComSubmit("frm");
		comSubmit.setUrl("<c:url value='/freeboard/updatefree.sosu' />");
		comSubmit.submit();
	}

	function fn_addFile() {
		var str = "<p><input type='file' name='file_" + (gfv_count++)
				+ "'><a href='#this' class='btn' name='delete'>삭제</a></p>";
		$("#fileDiv").append(str); //<<div id="fileDiv">에 변수 str의 값을 추가
		$("a[name='delete']").on("click", function(e) {
			e.preventDefault();
			fn_deleteFile($(this));
		});
	}

	function fn_deleteFile(obj) {
		obj.parent().remove(); //this의 바로 위의 요소(<p>태그)를 삭제
	}
</script>
<script src="/resources/js/common.js"></script>
<script src="/resources/js/freeboard.js"></script>