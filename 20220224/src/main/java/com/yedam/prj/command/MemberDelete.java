package com.yedam.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.prj.common.Command;
import com.yedam.prj.member.service.MemberService;
import com.yedam.prj.member.serviceImpl.MemberServiceImpl;
import com.yedam.prj.member.vo.MemberVO;

public class MemberDelete implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 회원삭제
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		int n = memberDao.memberDelete(vo);
		if(n != 0) {
			return "memberList.do";
		}else {
			request.setAttribute("message", "회원삭제가 정상적으로 이루어 지지 않았습니다.");
			return "member/memberLogin";
		}
		
	}

}
