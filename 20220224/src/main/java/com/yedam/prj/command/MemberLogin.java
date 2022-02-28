package com.yedam.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.prj.common.Command;
import com.yedam.prj.member.service.MemberService;
import com.yedam.prj.member.serviceImpl.MemberServiceImpl;
import com.yedam.prj.member.vo.MemberVO;

public class MemberLogin implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 처리
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();	//서버가 가지고 있는 나의 세션 객체를 호출
		vo.setId(request.getParameter("id"));
		//System.out.println("vo get id : " + vo.getId());
		vo.setPassword(request.getParameter("password"));
		
		vo = memberDao.memberLogin(vo);
		
		if(vo.getName() != null) {
			//세션 처리
			
			session.setAttribute("id", vo.getId());	//세션 아이디 담기
			session.setAttribute("author", vo.getAuthor()); //권한 
			session.setAttribute("name", vo.getName()); 	//이름
			return "home.do";
//			request.setAttribute("message", vo.getName() + "님 환영합니다.");
		}else {
			request.setAttribute("message", "아이디 또는 패스워드가 일치하지않습니다.");
			return "member/memberLogin";
		}
		
	}

}
