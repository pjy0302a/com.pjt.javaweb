package co.yedam.prj.border.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.prj.border.service.BorderService;
import co.yedam.prj.border.service.BorderVO;
import co.yedam.prj.border.serviceImpl.BorderServiceImpl;
import co.yedam.prj.common.Command;

public class AjaxSortBorder implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		BorderService borderDao = new BorderServiceImpl();
		List<BorderVO> list = new ArrayList<BorderVO>();
		String key = request.getParameter("key");
		list = borderDao.borderSortList(key);
		System.out.println(key + "================");
		String data = null;
		try {
			data = new ObjectMapper().writeValueAsString(list);	//json 객체로 변환 한다.
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		System.out.println(data.toString());
		return "ajax:" + data;
	}

}
