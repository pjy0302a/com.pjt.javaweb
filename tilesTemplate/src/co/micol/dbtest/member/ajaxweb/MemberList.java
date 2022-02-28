package co.micol.dbtest.member.ajaxweb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dbtest.common.DbCommand;
import co.micol.dbtest.member.service.MemberService;
import co.micol.dbtest.member.serviceImpl.MemberServiceImpl;

public class MemberList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberService memberDao = new MemberServiceImpl();	//member Table에 접근 하기 위해 Dao 생성
		request.setAttribute("members", memberDao.selectMemberList()); //멤버리스트를 실행하여 결과를 담음
		return "member/memberList.tiles";
		
	}

}
