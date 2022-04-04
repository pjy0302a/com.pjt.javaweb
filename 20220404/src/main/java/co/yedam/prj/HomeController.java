package co.yedam.prj;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		
		return "home/home";
	}
	@RequestMapping("/home.do")
	public String home() {
		return "home/home";
	}
}
