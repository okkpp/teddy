package okkpp.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class FreemarkerController {

	@RequestMapping("freemarker")
	public String freemarker(Model model) {
		
		model.addAttribute("okkpp", "duck");
		return "/auth/auth_login";
	}
}
