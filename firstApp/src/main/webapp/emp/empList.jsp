<%@page import="java.util.List"%>
<%@page import="com.yedam.employee.Employee"%>
<%@page import="com.yedam.employee.EmployeesDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Employee> list = EmployeesDAO.getInstance().selectAll();
	for (Employee emp : list) {
	%>
	<div>
		<span><%=emp.getFirstName()%></span>
		<span><%=emp.getJobId() %></span>
	</div>
	<%
	}
	%>
</body>
<%

%>
</html>