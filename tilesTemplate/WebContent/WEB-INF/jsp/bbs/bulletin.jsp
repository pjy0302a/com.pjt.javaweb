<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
	<script>
		$(function () {
			let id = $('#uid').val();
			let bid = $('#writer').val();

			console.log(id, bid);

			if (id == bid) {
				CKEDITOR.replace('content', {
					filebrowserUploadUrl: "${pageContext.request.contextPath}/fileUpload",
					height: "700"
				})
			}

			$('#delBtn').click(function (e) {
				e.preventDefault();
				$.ajax({
					url: 'bulletinDelete.do',
					data: {
						id: $('input[name="id"]').val()
					},
					success: function (result) {
						console.log(result);
						location.href = 'bulletinList.do';
					},
					error: function (err) {
						console.log(err);
						alert('처리중 에러발생');
						location.href = 'bulletinList.do';
					}
				});
			})
		});
	</script>
</head>

<body>
	<form action="bulletinUpdate.do" method="post">
		<input type="hidden" id="uid" value="${id }">
		<input type="hidden" name="writer" id="writer" value="${bulletin.bbsWriter }">
		<input type="hidden" name="id" value="${bulletin.bbsId }">
		<table border="1">
			<tr>
				<th>제목:</th>
				<td>
					<input type="text" name="title" id="title" value="${bulletin.bbsTitle }">
				</td>
			</tr>
			<tr>
				<th>내용:</th>
				<td width="1000">
					<c:choose>
						<c:when test="${bulletin.bbsWriter eq id }">
							<textarea name="content" id="content" cols="60" rows="20">${bulletin.bbsContent }</textarea>
						</c:when>
						<c:otherwise>
							<div>${bulletin.bbsContent }</div>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<c:if test="${bulletin.bbsWriter eq id }">
						<input type="submit" value="수정">
					</c:if>
					<c:if test="${bulletin.bbsWriter eq id }">
						<button type="button" id="delBtn">삭제</button>
					</c:if>
					<button type="button" onclick="location.href='bulletinList.do'">목록</button>
				</td>
			</tr>
		</table>
	</form>
</body>

</html>