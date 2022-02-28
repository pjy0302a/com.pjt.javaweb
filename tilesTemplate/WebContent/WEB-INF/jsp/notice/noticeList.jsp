<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<h1>공지사항 목록</h1>
	</div>
	<form id="frm" name="frm" action="notice.do" method="post">
		<input type="hidden" id="id" name="id">
	</form>
	<div>
		<table class="table">
			<tr>
				<th width="100">순번</th>
				<th width="200">제목</th>
				<th width="100">작성일자</th>
				<th width="100">조회수</th>
			</tr>
			<c:forEach var="vo" items="${notices }">
				<tr onclick="formSubmit(${vo.id})">
					<td align="center">${vo.id }</td>
					<td align="center">${vo.title }</td>
					<td align="center">${vo.wdate }</td>
					<td align="center">${vo.hit }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br />
	<div>
		<button type="button" onClick="location.href='main.do'">홈</button>
		&nbsp;&nbsp;&nbsp;
		<c:if test="${id eq 'admin' }">
			<button type="button" onClick="location.href='noticeForm.do'">등록</button>
		</c:if>
	</div>
	<div>
		<jsp:include page="../common/paging.jsp" flush="true">
			<jsp:param name="firstPageNo" value="${paging.firstPageNo}" />
			<jsp:param name="prevPageNo" value="${paging.prevPageNo}" />
			<jsp:param name="startPageNo" value="${paging.startPageNo}" />
			<jsp:param name="pageNo" value="${paging.pageNo}" />
			<jsp:param name="endPageNo" value="${paging.endPageNo}" />
			<jsp:param name="nextPageNo" value="${paging.nextPageNo}" />
			<jsp:param name="finalPageNo" value="${paging.finalPageNo}" />
		</jsp:include>
	</div>
</div>