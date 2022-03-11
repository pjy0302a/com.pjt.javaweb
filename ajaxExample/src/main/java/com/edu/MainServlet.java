package com.edu;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/MainServlet.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MainServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String json = "[{\"name\":\"HONG\", \"age\":20},{\"name\":\"HWANG\", \"age\":22}]";
		listDAO dao = new listDAO();
		dao.AllList();
		List<Map<String, String>> map = dao.AllList();
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(map));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fn = request.getParameter("myInput");
		
		listDAO dao = new listDAO();
		dao.insertList(fn);
		
		response.getWriter().print("{\"CONTENT\":\"" + fn + "\"}");
	}

}
