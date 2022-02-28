package co.micol.dbtest.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.dbtest.common.DbCommand;

public class MemberLoginOut implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그아웃 처리
		HttpSession session = request.getSession();
		
		session.invalidate();  //세션을 삭제한다
		return "main.do";
	}

}
