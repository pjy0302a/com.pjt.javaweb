package co.micol.dbtest.bbs.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dbtest.bbs.service.BulletinService;
import co.micol.dbtest.bbs.serviceImpl.BulletinServiceImpl;
import co.micol.dbtest.bbs.vo.BulletinVO;
import co.micol.dbtest.common.DbCommand;

public class BulletinDelete implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");

		BulletinVO vo = new BulletinVO();
		vo.setBbsId(Integer.parseInt(id));

		BulletinService service = new BulletinServiceImpl();
		service.deleteBulletin(vo);

		return "/bulletinList.do";
	}

}
