<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="form" action="" method="POST">
	ID : <input type="text" id= "name" name="id"><br>
	비밀번호 : <input type="password" name="pwd"><br>
	이름 : <input type="text" name="name"><br>
	취미 : 
		<input type="checkbox" name="hobby" value="climbing">등산
		<input type="checkbox" name="hobby" value="sports">운동
		<input type="checkbox" name="hobby" value="reading">독서
		<input type="checkbox" name="hobby" value="traveling">여행<br>
	성별 :
		<input type="radio" name="gender" value="male">남자
		<input type="radio" name="gender" value="female">여자<br>
	종교 :
		<select name="religion">
			<option value="">선택
			<option value="Christianity">기독교
			<option value="Buddhism">불교
			<option value="Catholicism">천주교
			<option value="atheism">무교
		</select><br>
	자기소개:<br>
		<textarea rows="30" cols="10" name="introduction"></textarea><br>
		<input type="submit" value="전송">
		<input type="reset" value="지우기">
		</form>
	<script>
		let id = document.querySelectorAll("input");
		let religion = document.querySelector("[name='religion']");
		//console.log(religion[1]);
		let textarea = document.querySelector("[name='introduction']");
		console.log(id);
		console.log(id[2].checked);
		form.addEventListener("submit",function(){
			
            if (id[0].value=='') {
                alert('id를 입력해주세요.');
                event.preventDefault();
                id[0].focus();
            }else if(id[1].value==''){
            	 alert('pwd를 입력해주세요.');
                 event.preventDefault();
                 id[1].focus();
            }else if(id[2].value==''){
           	 alert('이름을 입력해주세요.');
             event.preventDefault();
             id[2].focus();
       		}
            else if ((id[3].checked==false) && (id[4].checked==false) && (id[5].checked==false) && (id[6].checked==false)){
            	alert('취미를 입력해주세요.');
            	event.preventDefault();
            	id[3].focus();
            }else if (((id[7].checked==false) && (id[8].checked==false))){
            	alert("성별을 입력해주세요");
            	event.preventDefault();
            	id[7].focus();
            }else if (religion.value==''){
            	alert("종교를 입력해주세요");
            	event.preventDefault();
            	//id[8].focus();
            }
            else if (textarea.value == ''){
           	 alert('자기소개를 입력해주세요.');
             event.preventDefault();
             textarea.focus();
            }
		})
		
		


		//console.log(document.querySelectorAll("input")[8].value);
	</script>
</body>
</html>