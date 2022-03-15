package co.yedam.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.prj.common.Command;
import co.yedam.prj.member.service.MemberService;
import co.yedam.prj.member.serviceImpl.MemberServiceImpl;

public class ajaxMemberIdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// ajax로 아이디 중복체크
		MemberService memberDao = new MemberServiceImpl();
		String str = request.getParameter("str");
		boolean b = memberDao.isIdCheck(str);
		String result;
		if(!b) {
			result = "ajax:0";	//사용가능한 아이디
		}else {
			result = "ajax:1";	//이미존재하는 아이디
		}
		return result;
	}

}
