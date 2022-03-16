package co.yedam.prj.border.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.prj.border.service.BorderService;
import co.yedam.prj.border.serviceImpl.BorderServiceImpl;
import co.yedam.prj.common.Command;

public class BorderList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		BorderService borderDao = new BorderServiceImpl();
		request.setAttribute("borders", borderDao.borderSelectList());
		return "border/borderList";
	}

}
