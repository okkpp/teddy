package okkpp.freemarker.controller.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import okkpp.common.base.BaseController;
import okkpp.service.PostService;

@Controller
@RequestMapping("index")
public class IndexController extends BaseController {

	@Autowired
	private PostService postService;
	
	@RequestMapping("blog")
	public String index(Model model) {
		model.addAttribute("user", getSubject());
		model.addAttribute("list", postService.findAll());
		return "/index/blog";
	}
	
}
