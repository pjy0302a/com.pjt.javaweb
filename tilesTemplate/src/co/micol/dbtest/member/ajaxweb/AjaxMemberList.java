package co.micol.dbtest.member.ajaxweb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dbtest.common.DbCommand;
import co.micol.dbtest.member.service.MemberService;
import co.micol.dbtest.member.serviceImpl.MemberServiceImpl;

public class AjaxMemberList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDao = new MemberServiceImpl();
		request.setAttribute("members", memberDao.selectMemberList());
		return "member/memberlist";
	}
}
