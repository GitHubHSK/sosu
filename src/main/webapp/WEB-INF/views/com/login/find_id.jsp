<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">

<form action="/members/findid.sosu" method="POST">
   <div>이름</div><input type="text" name="M_NAME" id="m_name">
   <div>휴대전화</div><input type="text" name="M_PHONE" id="m_phone">
   <div>질문</div>
      <select name="M_QUE">
         <option value="1">기억에 남는 추억의 장소는?</option>
         <option value="2">자신이 세번째로 존경하는 인물은?</option>
         <option value="내가 좋아하는 캐릭터는?">내가 좋아하는 캐릭터는?</option>
         <option value="4">다시 태어나면 되고 싶은 것은?</option>
         <option value="5">초등학교 때 기억에 남는 짝꿍 이름은?</option>
         <option value="6">인상깊게 읽은 책 이름은?</option>
      </select>
      <input type="text" name="M_ANS">
   
   <input type="submit" value="확인">
</form>

</div>
</body>
=======
<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/login.css" rel="stylesheet">
</head>
<body>
<div class="container" style="text-align:center">

<h1 style="margin-top:50px; margin-bottom:40px">FIND ID</h1>

<form action="/members/findid.sosu" method="POST">

	<table class="input-form" >
		<colgroup>
			<col style="width:100px;">
			<col style="width:auto;">
		</colgroup>
		<thead></thead>
		<tbody>
			<tr>
				<th class="header"><label for="m_name">이름</label></th>
				<td class="find-contents" colspan="2" >
					<input type="text" name="M_NAME" id="m_name">
				</td>
			</tr>
			
			<tr>
				<th class="header"><label for="m_phone">휴대전화</label></th>
				<td class="find-contents" colspan="2" >
				<input type="text" name="M_PHONE" id="m_phone">
				</td>
			</tr>
			
			<tr>
				<th class="header">질문</th>
				<td class="find-contents">
					<select name="M_QUE" style="width: 100%; text-align: center;">
				         <option value="1">기억에 남는 추억의 장소는?</option>
				         <option value="2">자신이 세번째로 존경하는 인물은?</option>
				         <option value="3">내가 좋아하는 캐릭터는?</option>
				         <option value="4">다시 태어나면 되고 싶은 것은?</option>
				         <option value="5">초등학교 때 기억에 남는 짝꿍 이름은?</option>
				         <option value="6">인상깊게 읽은 책 이름은?</option>
			      	</select>
			     </td>
      			<td class="find-contents">
      				<input type="text" name="M_ANS" style="width: 60%;margin-left: 10%;">
      			</td>
			</tr>
			
				<tr>
					<td colspan="3" align="center">
						<input type="submit" value="아이디 찾기" class="btn-login">
					</td>
				</tr>	
			</tbody>
      
      		</table>
			
	
</form>

</div>
</body>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/login.css" rel="stylesheet">
</head>
<body>
<div class="container" style="text-align:center">

<h1 style="margin-top:50px; margin-bottom:40px">FIND ID</h1>

<form action="/members/findid.sosu" method="POST">

	<table class="input-form" >
		<colgroup>
			<col style="width:100px;">
			<col style="width:auto;">
		</colgroup>
		<thead></thead>
		<tbody>
			<tr>
				<th class="header"><label for="m_name">이름</label></th>
				<td class="find-contents" colspan="2" >
					<input type="text" name="M_NAME" id="m_name">
				</td>
			</tr>
			
			<tr>
				<th class="header"><label for="m_phone">휴대전화</label></th>
				<td class="find-contents" colspan="2" >
				<input type="text" name="M_PHONE" id="m_phone">
				</td>
			</tr>
			
			<tr>
				<th class="header">질문</th>
				<td class="find-contents">
					<select name="M_QUE" style="width: 100%; text-align: center;">
				         <option value="1">기억에 남는 추억의 장소는?</option>
				         <option value="2">자신이 세번째로 존경하는 인물은?</option>
				         <option value="3">내가 좋아하는 캐릭터는?</option>
				         <option value="4">다시 태어나면 되고 싶은 것은?</option>
				         <option value="5">초등학교 때 기억에 남는 짝꿍 이름은?</option>
				         <option value="6">인상깊게 읽은 책 이름은?</option>
			      	</select>
			     </td>
      			<td class="find-contents">
      				<input type="text" name="M_ANS" style="width: 60%;margin-left: 10%;">
      			</td>
			</tr>
			
				<tr>
					<td colspan="3" align="center">
						<input type="submit" value="아이디 찾기" class="btn-login">
					</td>
				</tr>	
			</tbody>
      
      		</table>
			
	
</form>

</div>
</body>
>>>>>>> branch 'develop' of https://github.com/gksmf4721/sosu.git
>>>>>>> branch 'develop' of https://github.com/GitHubHSK/sosu.git
</html>