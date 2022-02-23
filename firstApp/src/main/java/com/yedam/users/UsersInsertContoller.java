package com.yedam.users;

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
import com.yedam.employee.Employee;
import com.yedam.employee.EmployeesDAO;

/**
 * Servlet implementation class EmpInsertContoller
 */
@WebServlet("/UsersInsert")
public class UsersInsertContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override //사원등록페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member.jsp")
		   .forward(request, response);
	}

	//사원등록처리 후에 목록으로 이동
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 인코딩
		request.setCharacterEncoding("utf-8");
		//파라미터를 VO에 담기
		Users user = new Users();
		user.setId(request.getParameter("id"));
		user.setPwd(request.getParameter("pwd"));
		user.setName(request.getParameter("name"));
		//user.setHobby(request.getParameter("hobby"));
		System.out.println(request.getParameter("hobby"));
		user.setGender(request.getParameter("gender"));
		user.setReligion(request.getParameter("religion"));
		user.setIntroduction(request.getParameter("introduction"));
		
		String[] hobbyArr = request.getParameterValues("hobby");
		String sum ="";
		for(String s : hobbyArr) {
			sum += s +" ";
			
		}
		String hobby = sum;		//String[]을 string으로 변환 => "ski,read"
		user.setHobby(hobby);
		//파라미터 모두 확인
		CommonUtil.printParameter(request);
		//서비스호출
		UsersDAO.getInstance().insert(user);
		//페이지 이동
		//response.sendRedirect(request.getContextPath() + "/EmpList");

	}

}
