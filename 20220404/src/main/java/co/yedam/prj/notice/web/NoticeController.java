package co.yedam.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.yedam.prj.notice.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeDao;
	
	//요청들 처리하는 메소드 작성
	@RequestMapping("/noticeList.do")
	public String noticeList(Model model) {
		//리스트 가져오는거 처리
		model.addAttribute("notices",noticeDao.noticeSelectList());
		return "notice/noticeList";
	}
	
	
	
}
