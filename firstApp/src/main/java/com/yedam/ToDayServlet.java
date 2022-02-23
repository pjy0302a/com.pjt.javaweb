package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * HttpServlet 상속
 * doGet/Post 메서드 오버라이딩
 * @WebServlet 설정
 * 실행흐름을 개발자가 제어하는 것이 아니라 톰캣 컨테이너가 제어(IoC)
 * 싱글톤  : static 필드 
 * @WebServlet p86참조
 * p93 생성과 소멸
 * */
@WebServlet(urlPatterns = {"/today", "/day"}, loadOnStartup = 1, name="today")
public class ToDayServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		System.out.println(req.getRealPath("/"));
		System.out.println("doGet");
		PrintWriter out = resp.getWriter();	//응답관련작업 수행하는데 데이터를 출력하기 위한 출력스트림을 추출하는 메서드
		out.append("오늘은 is " + new Date().toString());
		//out.flush();
	
		out.append(" 입니다");	//System.out // 모니터
	}
	
	
	
	@Override
	//서버 stop 
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	//최초 한번 메모리 로드 될때
	public void init() throws ServletException {
		System.out.println("init");
	}
	
}
