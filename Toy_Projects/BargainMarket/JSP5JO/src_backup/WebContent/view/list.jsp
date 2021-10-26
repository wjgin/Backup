<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>Kkakdigu-Market__category</title>

<style type="text/css">
table {
	width: 100%;
	margin: auto;
	border-collapse: collapse;
}

.list td:last-child {
	width: 30%
}

.list td:first-child {
	width: 10%;
}
.list tr:first-child {
	border-bottom: 1px solid gray;
}
.list tr:nth-child(2) td{
	padding-top: 20px;
}
a {
	text-decoration: none;
}
</style>

</head>


<body>
	<!-- header -->
	<%@ include file="../header.jsp"%>

	<!-- 본문 content -->
	<section class="main">
		<div style='flex-basis: 80%; margin: auto;'>
		<c:if test="${list[0].name != null}">
			<h3>${list[0].name} 분야의 글 목록</h3>
		</c:if>
		<c:if test="${list[0].name == null}">
			<h3>전체 글 목록</h3>
		</c:if>

			<table class="list">
				<tr>
					<th>글 번호</th>
					<th>제목</th>
					<th>내용</th>
					<th>작성자</th>
					<th>작성 날짜</th>
				</tr>
				<c:forEach var="vo" items="${list}">
					<c:set var="content" value='${vo.content}'></c:set>
					<tr>
						<td>${vo.idx}</td>
						<td><a href="detail.do?idx=${vo.idx}&page=1">${vo.subject}</a></td>
						<td>${fn:substring(content,0,10)}...</td>
						<td>${vo.userId}</td>
						<td>${vo.wdate}</td>
					</tr>
				</c:forEach>
			</table>
			<br><br>
			
			<!-- page 처리 공간 -->
				<div style="text-align: center;">
				<hr>
				<!-- 요청 url은 현재와 같고 parameter만 변경 -->
				<c:if test="${pageDto.startPage != 1 }">
					<a class="pagenum" href="?cate=${categoryIdx}&page=1">⏪</a>
					<a class="pagenum" href="?cate=${categoryIdx}&page=${pageDto.startPage-1}">◀</a>
					<!-- 현재 페이지 10페이지 앞 -->
				</c:if>
				<c:forEach var="i" begin="${pageDto.startPage }" end="${pageDto.endPage - 1}">
					<a class="pagenum"
						<c:if test = "${pageDto.currentPage == i}">current</c:if>
						href="?cate=${categoryIdx}&page=${i}">${i}</a>
				</c:forEach>
				<c:if test="${pageDto.endPage != pageDto.totalPage}">
					<a class="pagenum" href="?cate=${categoryIdx}&page=${pageDto.endPage+1}">▶</a>
					<a class="pagenum" href="?cate=${categoryIdx}&page=${pageDto.totalPage}">⏩</a>
				</c:if>
			</div>
		</div>

	</section>

	<!-- bottom -->
	<%@ include file="../bottom.jsp"%>
</body>
</html>