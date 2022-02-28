package co.micol.dbtest.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dbtest.common.DbCommand;
import co.micol.dbtest.notice.serviceImpl.NoticeServiceImpl;
import co.micol.dbtest.notice.vo.NoticeVO;

public class Notice implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 세부내역 보기
		NoticeServiceImpl dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setId(Integer.parseInt(request.getParameter("id")));
		vo = dao.noticeSelect(vo);
		request.setAttribute("vo", vo);
		return "notice/notice.tiles";
	}

}
