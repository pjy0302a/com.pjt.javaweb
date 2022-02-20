package com.edu.comments;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/CommentListServlet")
public class CommentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CommentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 댓글 항목 json형식으로..
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		commentDAO dao = new commentDAO();
		List<Comment> list = dao.selectAll();
		Gson gson = new GsonBuilder().create();	
		gson.toJson(list);
		out.print(gson.toJson(list));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
