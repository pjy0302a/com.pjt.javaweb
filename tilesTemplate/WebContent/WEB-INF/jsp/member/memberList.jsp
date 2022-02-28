<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<div align="center">
		<div>
			<h1>공지사항 목록</h1>
		</div>

		<div>
			<table class="table" style="text-align: center;">
				<tr>
					<th width="200">아이디</th>
					<th width="200">이름</th>
					<th width="200">비밀번호</th>
					<th width="200">주소</th>
				</tr>
				
				<c:forEach var="vo" items="${members}">
				<tr>
					<td>${vo.memberId}</td>
					<td>${vo.memberName}</td>
					<td>${vo.memberPassword}</td>
					<td>${vo.memberAddress}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>