package co.micol.dbtest.notice.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dbtest.common.DbCommand;
import co.micol.dbtest.common.Paging;
import co.micol.dbtest.notice.serviceImpl.NoticeServiceImpl;
import co.micol.dbtest.notice.vo.NoticeVO;

public class NoticeList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 공지사항 전체보기
		NoticeServiceImpl dao = new NoticeServiceImpl();
		List<NoticeVO> list = new ArrayList<NoticeVO>();

		list = dao.noticeSelectList();
		request.setAttribute("notices", list);

		return "notice/noticeList.tiles";
	}

}
