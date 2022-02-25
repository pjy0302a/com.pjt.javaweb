package com.yedam.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.prj.common.Command;
import com.yedam.prj.member.service.MemberService;
import com.yedam.prj.member.serviceImpl.MemberServiceImpl;

public class AjaxIdCheck implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		//Ajax를 이용한 아이디 중복체크
		MemberService memberDao = new MemberServiceImpl();
		String id = request.getParameter("id");
		boolean b = memberDao.isIdcheck(id);
		if(b) {
			return "ajax:"+b; //사용가능한 아이디
		}else {
			return "ajax:"+b; //이미존재하는 아이디
		}
		
	}

}
