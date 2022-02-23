package com.yedam.employee;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpListServ
 */
@WebServlet("/adm/EmpListServ") //2.5부터사용
public class EmpListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpListServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String body = "";
		List<Employee> list = EmployeesDAO.getInstance().selectAll();
		for(Employee emp : list) {
			body += emp.getFirstName() + "<br>";
		}
		response.getWriter()
		.append("<html>")
		.append("<head>")
		.append("<title>today</title>")
		.append("</head>")
		.append("<body>")
		.append("<h1>EMP</h1>")
		.append(body)
		.append("</body>")
		.append("</html>");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
