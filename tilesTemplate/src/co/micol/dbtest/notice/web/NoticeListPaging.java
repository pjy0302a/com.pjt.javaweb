package co.micol.dbtest.notice.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dbtest.common.DbCommand;
import co.micol.dbtest.common.Paging;
import co.micol.dbtest.notice.serviceImpl.NoticeServiceImpl;
import co.micol.dbtest.notice.vo.NoticeVO;

public class NoticeListPaging implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String page = request.getParameter("page");

		page = page == null ? "1" : page;
		int pageCnt = Integer.parseInt(page);

		NoticeServiceImpl service = new NoticeServiceImpl();
		List<NoticeVO> listTotal = service.noticeSelectList();

		service = new NoticeServiceImpl();
		List<NoticeVO> list = service.selectNoticeListPaging(pageCnt);

		Paging paging = new Paging();
		paging.setPageNo(pageCnt);
		paging.setPageSize(10);
		paging.setTotalCount(listTotal.size());

		request.setAttribute("notices", list);
		request.setAttribute("paging", paging);

		return "notice/noticeListPaging.tiles";
	}

}
