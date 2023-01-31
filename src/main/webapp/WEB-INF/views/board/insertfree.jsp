<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/WEB-INF/include/include-header.jspf"%>
<html>
<head>
<title>자유게시판 작성</title>
</head>
<body>
<form id="frm" enctype="multipart/form-data">
<table>
	<caption>게시글등록</caption>
	<tbody>   
		<tr>
			<th>제목</th>
			<td>
				<input type="text" id="FR_TITLE" name="FR_TITLE" maxlength="70" placeholder="제목을 입력하세요">
			</td> 
		</tr>
		<tr>
			<th>카테고리</th>
			<td>
				${FR_CATEGORY}
			<td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>
				${M_IDX }
			</td> 
		</tr>
		<tr>
			<th>내용</th>
			<td class="view_text" colspan="4"> 
				<textarea rows="5" id="FR_CONTENT" name="FR_CONTENT" placeholder="내용을 입력하세요" style="width:500px; height:300px"></textarea>
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
	<a href="#this" class="btn" id="write">작성하기</a>
	<input type="hidden" name="FR_CATEGORY" value="${FR_CATEGORY}">
	<input type="hidden" name="FR_WRITER" value="${M_NICKNAME}">
	<a href="/freeboard/${FR_CATEGORY}.sosu" class="btn">목록으로</a>
	<!-- <a href="#this" class="btn" id="list">목록으로</a>-->	
</div>	
</form>
		
<script type="text/javascript">
	
	var gfv_count = 1;

	$(document).ready(function() {
		$("#write").on("click", function(e) { //작성하기 버튼
			e.preventDefault();
			fn_insertfree();
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

	function fn_insertfree() {
		var comSubmit = new ComSubmit("frm");
		comSubmit.setUrl("<c:url value='/freeboard/insertfree.sosu' />");
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
</body>
</html>