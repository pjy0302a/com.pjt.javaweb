<%@page import="com.yedam.employee.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.imp {color : red}
</style>
</head>
<body>
<h1>mvc패턴</h1>

<%--
List<Employee> obj = (List<Employee>)request.getAttribute("emplist");
out.print(obj.get(0).getFirstName());
--%>
<hr>
${emplist[0].getFirstName()}
<hr>
${fn:length(emplist)} 건
	<table>
		<tr>
			<td>id</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>취미</td>
			<td>성별</td>
			<td>종교</td>
			<td>자기소개</td>
	
		</tr>
		<c:forEach items="${userlist}" var="user">
			<tr><td>${user.id}</td>
				<td>${user.pwd}</td>
				<td><a href="UserUpdate?id=${user.id}">
				${user.name}</a></td>
				<td>${user.hobby}</td>
				<td>${user.gender}</td>
				<td>${user.religion}</td>
				<td>${user.introduction}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>