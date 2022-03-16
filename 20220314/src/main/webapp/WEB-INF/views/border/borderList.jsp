<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery.min.js"></script>
</head>
<body>

	<div align="center">
		<div>
			<h1>게시글 목록</h1>
		</div>
		<div>
			<form id="frm" method="post">
				<div>
					<select id="searchkey" name="searchkey">
						<option value="1">전체</option>
						<option value="2">작성자</option>
						<option value="3">제목</option>
						<option value="4">내용</option>
					</select> <span> <input type="text" id="searchVal" name="searchVal">&nbsp;
						<input type="button" onclick="searchList()" value="검색">&nbsp;

					</span>
					<table border="1" id="contents">
						<thead>
							<tr>
								<th width="150"><span style="color:red" onclick="sortBorder('A')" >A</span>
								글번호<span style="color:red" onclick="sortBorder('D')">D</span></th>
								<th width="150">작성자</th>
								<th width="300">제 목</th>
								<th width="150">작성일자</th>
								<th width="70">조회수</th>
							</tr>
						</thead>
						<tbody id="borderBody">
							<c:if test="${empty borders }">
								<tr>
									<td colspan="5">게시글이 존재하지 않습니다.</td>
								</tr>
							</c:if>
							<c:if test="${not empty borders }">
								<c:forEach items="${borders }" var="b">
									<tr onmouseover='this.style.background="#fcecae";'
										onmouseleave='this.style.background="#FFFFFF";'
										onclick="borderContents('${b.borderId}')">
										<td align="center">${b.borderId }</td>
										<td align="center">${b.borderWriter }</td>
										<td>${b.borderTitle }</td>
										<td align="center">${b.borderDate }</td>
										<td align="center">${b.borderHit }</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
				<br>
				<div>
					<button type="button" onclick="location.href='borderInsertForm.do'">글쓰기</button>
				</div>
				<input type="hidden" id="borderId" name="borderId">
			</form>
		</div>

	</div>
	<script type="text/javascript">
	function borderContents(n) {
		frm.borderId.value = n;
		frm.action = "borderView.do";
		frm.submit();
	}
	function searchList() {
		$.ajax({
			url : "ajaxBorderSearch.do",
			type : "post",
			data : {"key" : $("#searchkey").val(), "val" : $("#searchVal").val()},
			dataType : "json",
			success : function(result) {
				if(result.length > 0){
					searchResult(result);	//json data를 html로 변환해서 화면에 뿌려주는 메소드
				}else{
					alert("검색한 결과가 존재하지 않습니다.");
				}
			}
		});
	}
	
	function searchResult(data){
	      var tb = $("#borderBody");
	      $("#borderBody").empty();
	      
	      $.each(data, function(index,item){
	         var html= $("<tr />").attr({
	            'onmouseover' : 'this.style.background="#fcecae";',
	            'onmouseleave' : 'this.style.background="#FFFFFF"',
	            'onclick' : 'borderContents('+ item.borderId + ')'
	         }).append(
	         $("<td align='center'/>").text(item.borderId),      
	         $("<td align='center'/>").text(item.borderWriter),      
	         $("<td />").text(item.borderTitle),      
	         $("<td align='center'/>").text(item.borderDate),      
	         $("<td align='center'/>").text(item.borderHit)      
	         );
	         tb.append(html);
	         
	      });
	      
	      $("#contents").append(tb);
	   }
 	function sortBorder(key) {
		$.ajax({
			url : "ajaxSortBorder.do",
			type : "post",
			data : {"key" : key},
			dataType : "json",
			success : function(result) {
				searchResult(result);
			}
		})
	}
</script>
</body>

</html>