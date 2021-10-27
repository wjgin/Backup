<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyField</title>
<link rel="stylesheet" href="css/myField.css?v=3">
<script src="https://kit.fontawesome.com/a9b46edd75.js" crossorigin="anonymous"></script>
<script src="main.js" defer></script>
<script src="js/myField.js" defer></script>
</head>
<body>

	<!-- header -->
	<%@ include file="../header.jsp"%>

	<section>
		<div class="field">
			<form action="myFieldRegist.do" method="post" name="fieldRegist" 
				onsubmit="return validCheck()">
				<!-- 본문 content -->
				<table>
					<tr>
						<!-- 분야 선택 리스트 -->
						<td><select name="field" required>
								<!-- option 태그 안에 문자열 : 화면, value : 서버 전송 값 -->
								<!-- selected 옵션은 기본선택 -->
								<option value="" selected>분야 선택</option>
								<option value="1">의류/악세서리</option>
								<option value="2">스포츠/레저</option>
								<option value="3">음악/미술</option>
								<option value="4">가구/인테리어</option>
								<option value="5">디지털/가전</option>
								<option value="6">뷰티/미용</option>
<!-- 								<option value="etc">기타</option> -->
						</select></td>
					</tr>
	
<!-- 					<tr> -->
<!-- 						기타 선택 -->
<!-- 						<td><input type="text" class="etc" name="etc" -->
<!-- 							placeholder="기타 입력" disabled></td> -->
<!-- 					</tr> -->
				</table>
	
				<table>
					<tr>
						<td><input type="text" placeholder="회사 이메일을 입력하세요"></td>
						<td class="ml"><input type="button" value="전송"></td>
					</tr>
					
					<tr>
						<td><input type="text" placeholder="인증번호 입력"></td>
						<td class="ml"><input type="button" value="확인"></td>
					</tr>
				</table>
	
				<input type=submit value="제출">
			</form>
		</div>
	</section>
	<%@ include file="../bottom.jsp"%>
</body>

</html>