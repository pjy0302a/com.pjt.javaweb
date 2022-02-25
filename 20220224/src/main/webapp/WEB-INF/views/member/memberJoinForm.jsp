<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- javaScript 폼이 로드 될때 먼저수행할 자바스크립트 기술 -->
<!-- 자바스크립트 라이브러리, 또는 DOM객체를 선행적으로 수행될때 -->
<script type="text/javascript">
function formCheck() {
		if(frm.idCheck.value == 'No'){
		alert("아이디 중복 체크를 해주세요!!");
		return false;
	} 
	if(frm.password.value != frm.password1.value){
		alert("패스워드가 일치 하지 않습니다.")
		frm.password.value="";
		frm.password1.value="";
		frm.password.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body>
<jsp:include page="../home/header.jsp"/>
<div align="center">
	<div><h1>회 원 가 입</h1></div>
	<div>
		<form id="frm" action="memberJoin.do" onsubmit="return formCheck();" method="post">
		<div>
			<table border="1">
				<tr>
					<th width="100">* 아이디</th>
					<td width="280">
						<input type="email" id="id" name="id" required="required" placeholder="EX)abc.@abc.com">&nbsp;&nbsp;
						<button type="button" onclick="idCheckCall()" id="idCheck" value="No">중복체크</button>
					</td>
				</tr>
				<tr>
					<th>* password</th>
					<td><input type="password" id="password" name="password" required="required"> 
				</tr>
				<tr>
					<th>* password확인</th>
					<td><input type="password" id="password1" name="password1" required="required"> 
				</tr>
				<tr>
					<th>* 이 름</th>
					<td><input type="text" id="name" name="name" required="required"> 
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="tel" id="tel" name="tel"> 
				</tr>
				<tr>
					<th>주 소</th>
					<td><input type="text" id="address" name="address" size="60"> 
				</tr>
			</table>
		</div><br>
		<div>
			<input type="hidden" id="author" name="author" value="USER">
			<input type="reset" value="취소">&nbsp;&nbsp;
			<input type="submit" value="회원가입">
		</div>
		</form>
	</div>
</div>
<script type="text/javascript">

	function idCheckCall() {	// ajax로 아이디를 중복체크 하는 함수
		const xhttp = new XMLHttpRequest();	// aJax 객체를 생성
		const id = frm.id.value;
		xhttp.onreadystatechange = function () {
			if(xhttp.readyState==4){	//통신이 연결되서 데이터가 다 전달되었다면
				if(xhttp.status==200){	//정상적으로 수행되고 결과가 왔을때
					var b = xhttp.responseText;	//결과데이터 받는 부분
					
					if(b == "true"){
						alert(id + "는 사용가능한 아이디 입니다.");
						frm.idCheck.value="Yes";
						frm.idCheck.style.display = "none";
						frm.password.focus();
					}else{
						alert(id + "는 이미 사용하는 아이디 입니다.");
						frm.id.value="";
						frm.id.focus();
					}
				}
			}	
		}
		xhttp.open("GET","ajaxIdCheck.do?id="+id);	//호출해야할 방법과 주소
		xhttp.send();	//호출
	}
</script>
</body>
</html>