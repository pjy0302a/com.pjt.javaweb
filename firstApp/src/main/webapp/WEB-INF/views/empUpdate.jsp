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
<h2>사원변경</h2>
<form method="post" action="/firstApp/EmpInsert">
	employee_id<input name="employee_id" value="${employee.employeeId}"><br>
	last_name<input name="last_name" value="${employee.lastName}"><br>
	email<input name="email" value="${employee.email}"><br>
	job_id<select name="job_id">
			<c:forEach items="${jobList}" var="job">
				<option value="${job.jobId}"<c:if test="${employee.jobId==job.jobId}"> selected="selected"</c:if>>"${job.jobTitle}"</option>
			</c:forEach>
	</select><br>
	department_id<select name="department_id">
					<option value="">선택</option>
					<option value="10">인사</option>
					<option value="20" selected="selected">개발</option>					
					</select><br>
	hire_date<input name="hire_date" type="date" value="${fn:substring(employee.hireDate,0,10)}"><br>
	<input name="hobby" type="checkbox" value="ski">스키
	<input name="hobby" type="checkbox" value="read">독서
	<button>등록</button>
</form>
</body>
</html>