package com.edu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// name1=Lee&age1=24&score1=83
		
		String nameVal = request.getParameter("name1");
		String ageVal = request.getParameter("age1");
		String scoreVal = request.getParameter("score1");

		MemberDAO dao = new MemberDAO();
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", nameVal);
		map.put("age", ageVal);
		map.put("score", scoreVal);

		dao.insertMember(map);
		
		response.sendRedirect("index.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
