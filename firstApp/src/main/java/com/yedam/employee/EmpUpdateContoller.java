package com.yedam.employee;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.CommonUtil;

/**
 * Servlet implementation class EmpInsertContoller
 */
@WebServlet("/empUpdate")
public class EmpUpdateContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override //사원수정페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사번파라미터
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		//단건조회
		Employee employee = EmployeesDAO.getInstance().selectOne(employeeId);
		//request에 결과 저장하고
		request.setAttribute("employee", employee);
		request.setAttribute("jobList", EmployeesDAO.getInstance().selectJobs());
		//request.setAttribute("jobList", EmployeesDAO.getInstance().selectJobs());
		request.getRequestDispatcher("/WEB-INF/views/empUpdate.jsp")
		   .forward(request, response);
	}
	
	//사원등록처리 후에 목록으로 이동
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 인코딩
		request.setCharacterEncoding("utf-8");
		//파라미터를 VO에 담기
		Employee emp = new Employee();
		emp.setEmployeeId(Integer.parseInt(request.getParameter("employee_id")));
		emp.setLastName(request.getParameter("last_name"));
		emp.setEmail(request.getParameter("email"));
		emp.setJobId(request.getParameter("job_id"));
		emp.setHireDate(request.getParameter("hire_date"));
		
		//파라미터 모두 확인
		CommonUtil.printParameter(request);
		//서비스호출
		EmployeesDAO.getInstance().update(emp);
		//페이지 이동
		response.sendRedirect(request.getContextPath() + "/EmpList");

	}

}
