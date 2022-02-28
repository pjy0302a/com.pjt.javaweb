<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>공지사항관리</h3>
<div class="row">
	<!--  목록 시작 -->
	<div class="col-md-12 col-lg-8">
		<table class="table">
			<thead>
			<tr>
				<th width="100">순번</th>
				<th width="200">제목</th>
				<th width="100">작성일자</th>
				<th width="100">조회수</th>
			</tr>
			</thead>
			<tbody id="list"></tbody>
		</table>	
	</div>
	<!--  목록 끝 -->
	
	<!--  등록폼 시작 -->
	<div class="col-md-12 col-lg-4">
		<form id="frm" name="frm" action="noticeWrite.do" method="post">
			<div>
			<table border="1">
				<tr>
					<th width="70">제목</th>
					<td width="200"><input type="text" id="title" name="title" size="50"></td>
					<th width="70">작성일자</th>
					<td width="140"><input type="date" id="wdate" name="wdate"></td>
				</tr>
				<tr>
					<th width="70">내용</th>
					<td colspan="3">
						<textarea id="content" name="content" rows="6" cols="90"></textarea>
					</td>
				</tr>
			</table>
			</div> <br/>
			<div>
				<input id="btnSave"  class="btn btn-success" type="button" value="저장하기">
				<input id="btnReset" class="btn btn-warning" type="reset"  value="취소">
				<input id="btnList"  class="btn btn-info"  type="button" value="목록가기">
			</div>
		</form>
	</div>
	<!--  등록폼 끝 -->
</div>
<script src="./js/notice.js"></script>

