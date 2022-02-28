package com.yedam.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.prj.command.AjaxIdCheck;
import com.yedam.prj.command.HomeCommand;
import com.yedam.prj.command.LoginForm;
import com.yedam.prj.command.MemberDelete;
import com.yedam.prj.command.MemberJoin;
import com.yedam.prj.command.MemberJoinForm;
import com.yedam.prj.command.MemberList;
import com.yedam.prj.command.MemberLogin;
import com.yedam.prj.command.logout;
import com.yedam.prj.common.Command;


/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>();	//

    public FrontController() {
        super();
        
    }


	public void init(ServletConfig config) throws ServletException {
		// 명령 그룹을 담아 두는 곳
		map.put("/home.do", new HomeCommand());	//처음 접근하는 페이지
		map.put("/memberList.do", new MemberList()); //멤버목록 보기
		map.put("/loginForm.do", new LoginForm());	//로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin()); //로그인 처리
		map.put("/logout.do", new logout()); //로그아웃 처리
		map.put("/memberJoinForm.do", new MemberJoinForm());
		map.put("/memberJoin.do", new MemberJoin());
		map.put("/ajaxIdCheck.do", new AjaxIdCheck()); //아이디 중복체크(ajax)
		map.put("/memberDelete.do", new MemberDelete()); 
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실제 요청을 분석 하고 처리해서 결과 page를 돌려주는 역할을 한다.
		request.setCharacterEncoding("utf-8");	//한글 깨짐 방지를 위함
		String uri = request.getRequestURI();	//URI를 구함
		String contextPath = request.getContextPath();	//ContextPath 구함
		String page = uri.substring(contextPath.length());	//실제 요청을 구함(처리해야 할 요청);
		
		Command command = map.get(page);	//Command command = new HomeCommand();
		String viewPage = command.run(request, response);
		System.out.println("uri : " + uri);
		System.out.println("contextPath : " + contextPath);
		System.out.println("page : " + page);
		System.out.println("command : " + command);
		System.out.println("viewPage : " + viewPage);
		if(viewPage != null && !viewPage.endsWith(".do")) {	//view Resolve
			if(viewPage.startsWith("ajax:")) {	//ajax를 처리하기위해
				response.setContentType("text/html;");
				response.getWriter().append(viewPage.substring(5));
				return;
			}else {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
			}
		}
		System.out.println("lviewPage : "  + viewPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
	}

}
