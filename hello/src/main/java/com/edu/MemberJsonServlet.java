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


@WebServlet("/MemberJsonServlet")
public class MemberJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberJsonServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//				response.getWriter().append("Served at: ").append(request.getContextPath());
		//request 요청 , response 응답
		// {"user_id": 100, "user_name":"박문수", "user_age": 25, "is_marriage":false}
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		List<Map<String, String>> list = dao.getMemberList();
		int totalCnt = list.size(); // 전체데이터 건수.
		int cnt = 0;
		out.print("[");
		for(Map<String, String> map : list) {
			out.print("{\"name\": \"" + map.get("name") 
					 + "\", \"age\":\""+map.get("age")
					 +"\", \"score\": "+map.get("score")
					 +", \"is_marriage\":false}");
					// 마지막 데이터 , 를 생략.
			if(++cnt != totalCnt) {
				out.print(",");
			}
		}
		out.print("]");
		//[{},{},{},{}]
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
