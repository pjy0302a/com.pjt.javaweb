package co.micol.dbtest.bbs.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dbtest.bbs.service.BulletinService;
import co.micol.dbtest.bbs.serviceImpl.BulletinServiceImpl;
import co.micol.dbtest.bbs.vo.BulletinVO;
import co.micol.dbtest.common.DbCommand;

public class BulletinInsert implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		BulletinVO vo = new BulletinVO();
		vo.setBbsContent(content);
		vo.setBbsTitle(title);
		vo.setBbsWriter(writer);
		
		BulletinService service = new BulletinServiceImpl();
		service.insertBulletin(vo);

		return "/bulletinList.do";
	}

}
