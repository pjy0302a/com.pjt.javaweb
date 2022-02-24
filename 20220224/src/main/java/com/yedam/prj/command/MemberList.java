package com.yedam.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.prj.common.Command;
import com.yedam.prj.member.service.MemberService;
import com.yedam.prj.member.serviceImpl.MemberServiceImpl;

public class MemberList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 멤버 목록 보기
		MemberService memberDao = new MemberServiceImpl();	//member Table에 접근 하기 위해 Dao 생성
		request.setAttribute("members", memberDao.memberSelectList()); //멤버리스트를 실행하여 결과를 담음
		return "member/memberList";
	}

}
