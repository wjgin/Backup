<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Kkakdigu-Market__category</title>

</head>

<body>
	<!-- header -->
	<%@ include file="../header.jsp"%>

	<!-- 본문 content -->
	<section class="main">
		<div style='flex-basis: 80%; margin: auto;'>
			<h3>${list[0].name} 분야의 글</h3>
				
				<table style='width: 100%; margin: auto; border-collapse: seperate; border-spacing: 40px 0;'>
					<tr>
						<td>글 번호</td><td>제목</td><td>내용</td><td>작성자</td>
					</tr>
					<c:forEach var="vo" items="${list}">
						<tr>
							<td><a href="#">${vo.idx}</a></td>
							<td><a href="#">${vo.subject}</a></td>
							<td><a href="#">${vo.content}</a></td>
							<td><a href="#">${vo.userId}</a></td>
						</tr>
					</c:forEach>
				</table>
		</div>

	</section>

	<!-- bottom -->
	<%@ include file="../bottom.jsp"%>
</body>
</html>