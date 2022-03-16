package co.yedam.prj.border.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.prj.border.service.BorderService;
import co.yedam.prj.border.service.BorderVO;
import co.yedam.prj.border.serviceImpl.BorderServiceImpl;
import co.yedam.prj.common.Command;

public class BorderView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		BorderService borderDao = new BorderServiceImpl();
		BorderVO vo = new BorderVO();
		vo.setBorderId(Integer.parseInt(request.getParameter("borderId")));
		request.setAttribute("border", borderDao.borderSelect(vo)); 
		borderDao.borderUpdateHit(vo.getBorderId());
		return "border/borderView";
	}

}
