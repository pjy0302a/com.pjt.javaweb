package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MemberTableServlet")
public class MemberTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberTableServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		테이블 형식으로 화면에 출력.
		MemberDAO dao = new MemberDAO();
		List<Map<String, String>> list = dao.getMemberList();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<table border = 1px solid black><thead>");
		out.print("<tr><th>이름</th><th>나이</th><th>점수</th></tr><tbody>");
		for(Map<String, String> map : list) {
			out.print("<tr>" + "<td>" + map.get("name") + "</td>" +  "<td>" + map.get("age") + "</td>" + "<td>" + map.get("score") + "</td>" + "</tr>");
		}
		out.print("</tbody></table>");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
