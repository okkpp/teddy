package okkpp.freemarker.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import okkpp.freemarker.controller.base.FreemarkerBaseController;
import okkpp.model.Post;

@Controller
@RequestMapping("manager/post")
public class ManagerPostController extends FreemarkerBaseController<Post> {

}
