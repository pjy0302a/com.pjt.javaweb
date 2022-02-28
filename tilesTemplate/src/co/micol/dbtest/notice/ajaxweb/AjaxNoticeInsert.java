package co.micol.dbtest.notice.ajaxweb;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import co.micol.dbtest.common.DbCommand;
import co.micol.dbtest.notice.serviceImpl.NoticeServiceImpl;
import co.micol.dbtest.notice.vo.NoticeVO;

public class AjaxNoticeInsert implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 저장하기
		NoticeServiceImpl dao = new NoticeServiceImpl();
		
		NoticeVO vo = new NoticeVO();
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setWdate(Date.valueOf(request.getParameter("wdate")));

		dao.insertNotice(vo);
		System.out.println(vo);
		Gson gson = new Gson();
		String str = gson.toJson(vo);
		return "ajax:"+str;
	}
}
