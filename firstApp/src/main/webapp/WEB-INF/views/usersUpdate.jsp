<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empInsert.jsp</title>
</head>
<body>
<h2>유저변경</h2>
<form id="form" action="" method="POST">
	ID : <input type="text" id= "name" name="id" value="${users.id}" ><br>
	비밀번호 : <input type="password" name="pwd" value="${users.pwd}"><br>
	이름 : <input type="text" name="name" value="${users.name}"><br>
	취미 :
		<input type="checkbox" name="hobby" value="climbing"
		<c:forEach items="${fn:split(users.hobby,' ')}" var="shobby">
			<c:if test= "${shobby eq 'climbing'}">checked="checked"</c:if>
		</c:forEach>>등산
		<input type="checkbox" name="hobby" value="sports"
		<c:forEach items="${fn:split(users.hobby,' ')}" var="shobby">
			<c:if test= "${shobby eq 'sports'}">checked="checked"</c:if>
		</c:forEach>>운동
		<input type="checkbox" name="hobby" value="reading"
		<c:forEach items="${fn:split(users.hobby,' ')}" var="shobby">
			<c:if test= "${shobby eq 'reading'}">checked="checked"</c:if>
		</c:forEach>>독서
		<input type="checkbox" name="hobby" value="traveling"
		<c:forEach items="${fn:split(users.hobby,' ')}" var="shobby">
			<c:if test= "${shobby eq 'traveling'}">checked="checked"</c:if>
		</c:forEach>>여행<br>
		
	성별 :
		<input type="radio" name="gender" value="male" <c:if test="${users.gender eq 'male'}" >checked="checked"</c:if>>남자
		<input type="radio" name="gender" value="female" <c:if test="${users.gender eq 'female'}" >checked="checked"</c:if>>여자<br>
	종교 :
		<select name="religion">
			<option value="">선택
			<option value="Christianity" <c:if test="${users.religion eq 'Christianity'}" >selected="selected"</c:if>>기독교
			<option value="Buddhism" <c:if test="${users.religion eq 'Buddhism'}" >selected="selected"</c:if>>불교
			<option value="Catholicism" <c:if test="${users.religion eq 'Catholicism'}" >selected="selected"</c:if>>천주교
			<option value="atheism" <c:if test="${users.religion eq 'atheism'}" >selected="selected"</c:if>>무교
		</select><br>
	자기소개:<br>
		<textarea rows="30" cols="10" name="introduction" >${users.introduction}</textarea><br>
		<input type="submit" value="전송">
		<input type="reset" value="지우기">
		

		</form>
</body>

</html>