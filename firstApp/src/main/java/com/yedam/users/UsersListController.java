package com.yedam.users;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 1. 요청파악(파라미터 추출, 유효성체크)
 * 2. 서비스 처리(DB)
 * 3. 결과 저장
 * 4. view 페이지로 이동(forward / sendRedirect)
 * 
 * */


/**
 * Servlet implementation class EmpListController
 */
@WebServlet("/UserList")
public class UsersListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//멤버변수 
	int count = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//지역변수
		int localCount = 0;
		
		System.out.println("전역 : " + ++count);
		System.out.println("지역 : " + ++localCount);
		
		//request 정보
		System.out.println("ContextPath: "+request.getContextPath());
		System.out.println("User-Agent: " + request.getHeader("User-Agent"));
		System.out.println("클라이언트 IP: " + request.getRemoteAddr());
		System.out.println("질의문자열: " + request.getQueryString());
		System.out.println("uri: " + request.getRequestURI());
		System.out.println("RealPath" + request.getServletContext().getRealPath("/"));
		
		
		List<Users> list = UsersDAO.getInstance().selectAll();
		//for (Employee emp : list) {
			request.setAttribute("userlist", list);
			request.getRequestDispatcher("/WEB-INF/views/userView.jsp")
			.forward(request, response);
			
	//}
	}
}
