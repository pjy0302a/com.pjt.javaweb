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
			<td>사번</td>
			<td>이름</td>
			<td>부서번호</td>
			<td>급여</td>
		</tr>
		<c:forEach items="${emplist}" var="emp">
			<tr><td>${emp.getFirstName()}</td>
				<td><a href="empUpdate?employeeId=${emp.employeeId}">
				${emp.getFirstName()} ${emp.lastName}</a></td>
				<td>${emp.departmentId}</td>
				<td  <c:if test="${emp.salary>=10000}">class="imp"</c:if>>${emp.salary}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>