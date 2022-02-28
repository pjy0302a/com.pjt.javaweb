package co.micol.dbtest.notice.ajaxweb;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import co.micol.dbtest.common.DbCommand;
import co.micol.dbtest.notice.serviceImpl.NoticeServiceImpl;
import co.micol.dbtest.notice.vo.NoticeVO;

public class AjaxNoticeList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		NoticeServiceImpl dao = new NoticeServiceImpl();
		List<NoticeVO> list = dao.noticeSelectList();
		Gson gson = new Gson();
		String str = gson.toJson(list);
		return "ajax:"+str;
	}
}
