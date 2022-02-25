package com.yedam.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.prj.common.Command;
import com.yedam.prj.member.service.MemberService;
import com.yedam.prj.member.serviceImpl.MemberServiceImpl;
import com.yedam.prj.member.vo.MemberVO;

public class MemberJoin implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 처리
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setTel(request.getParameter("tel"));
		vo.setAddress(request.getParameter("address"));
		vo.setAuthor(request.getParameter("author"));
		
		int n = memberDao.memberInsert(vo);
		if(n != 0) {
			return "member/loginForm";
		}else {
			return "member/memberResisterForm";
		}
		
	}

}
