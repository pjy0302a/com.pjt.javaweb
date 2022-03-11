package com.edu;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.dao.EmpDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class DataServlet
 */
@WebServlet("/DataServlet.do")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String json = "[{\"name\":\"HONG\", \"age\":20},{\"name\":\"HWANG\", \"age\":22}]";
		EmpDAO dao = new EmpDAO();
		dao.empList();
		List<Map<String, String>> map = dao.empList();
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(map));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fn = request.getParameter("firstName");
		String sa = request.getParameter("salary");
		
		EmpDAO dao = new EmpDAO();
		dao.insertEmp(fn, Integer.parseInt(sa));
		
		response.getWriter().print("{\"name\":\"" + fn + "\",\"age\":" + sa + "}");
	}

}
