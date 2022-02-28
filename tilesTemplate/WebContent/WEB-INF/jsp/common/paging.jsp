<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function goPage(page) {
		location.href = "noticeListPaging?page=" + page;
	}
</script>
<div class="paginate">
	<a href="javascript:goPage(${paging.firstPageNo})" class="first">처음 페이지</a>
	<a href="javascript:goPage(${paging.prevPageNo})" class="prev">이전 페이지</a>
	<span>
		<c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
			<c:choose>
				<c:when test="${i eq paging.pageNo}">
					<a href="javascript:goPage(${i})" class="choice">${i}</a>
				</c:when>
				<c:otherwise>
					<a href="javascript:goPage(${i})">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</span>
	<a href="javascript:goPage(${paging.nextPageNo})" class="next">다음 페이지</a>
	<a href="javascript:goPage(${paging.finalPageNo})" class="last">마지막 페이지</a>
</div>