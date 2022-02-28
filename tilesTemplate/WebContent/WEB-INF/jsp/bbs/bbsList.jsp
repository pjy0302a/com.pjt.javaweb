<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style type="text/css">
	<!--
	tr.row:hover {
		background-color: lightyellow;
	}
	-->
</style>

<script type="text/javascript">
	function formSubmit(id) {
		frm.id.value = id;
		frm.submit();
	}
</script>

<div>
	<br />
</div>
<div align="center">
	<div>
		<h1>게시판 목록</h1>
	</div>
	<form id="frm" name="frm" action="bulletinSelect.do" method="post">
		<input type="hidden" id="id" name="id">
	</form>
	<div>
		<table class="table">
			<tr>
				<th width="100">순번</th>
				<th width="200">제목</th>
				<th width="100">작성자</th>
				<th width="100">작성일자</th>
				<th width="100">조회수</th>
			</tr>
			<!--  <p>${list}</p> -->
			<c:forEach var="vo" items="${list }">
				<tr onclick="formSubmit(${vo.bbsId})">
					<td align="center">${vo.bbsId }</td>
					<td align="center">${vo.bbsTitle }</td>
					<td align="center">${vo.bbsWriter }</td>
					<td align="center">${vo.bbsCreateDate }</td>
					<td align="center">${vo.bbsHit }</td>
				</tr>
			</c:forEach>
		</table>
	</div><br />
	<div>
		<button type="button" onClick="location.href='main.do'">홈</button>&nbsp;&nbsp;&nbsp;
		<c:if test="${not empty id }">
			<button type="button" onClick="location.href='bulletinForm.do'">등록</button>
		</c:if>
	</div>
</div>