package co.yedam.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.prj.common.Command;
import co.yedam.prj.home.command.HomeCommand;
import co.yedam.prj.member.command.MemberList;
import co.yedam.prj.member.command.MemberLogin;
import co.yedam.prj.member.command.MemberSearch;
import co.yedam.prj.member.command.ajaxMemberIdCheck;
import co.yedam.prj.member.command.memberJoin;
import co.yedam.prj.member.command.memberJoinForm;




public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do", new HomeCommand());
		map.put("/memberList.do", new MemberList());
		map.put("/memberSearch.do", new MemberSearch());
		map.put("/memberLogin.do", new MemberLogin());
		map.put("/ajaxMemberIdCheck.do", new ajaxMemberIdCheck()); //ajax로 아이디 중복체크
		map.put("/memberJoinForm.do", new memberJoinForm()); //ajax로 아이디 중복체크
		map.put("/memberJoin.do", new memberJoin()); //ajax로 아이디 중복체크
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command comm = map.get(page);
		String viewPage = comm.exec(request, response);
		
		if(!viewPage.endsWith(".do")) {
			if(viewPage.startsWith("ajax:")) {
				//ajax 처리
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}else {
				viewPage = "WEB-INF/views/" + viewPage + ".jsp";
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
