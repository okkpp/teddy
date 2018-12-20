package okkpp.freemarker.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import okkpp.common.base.BaseController;

@Controller
@RequestMapping("manager")
public class ManagerController extends BaseController {

	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("user", getSubject());
		return "/manager/index";
	}
	
	@RequestMapping("user")
	public String user(Model model) {
		model.addAttribute("user", getSubject());
		return "/manager/manager_user";
	}
}
