package okkpp.freemarker.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import okkpp.freemarker.controller.base.FreemarkerBaseController;
import okkpp.model.User;

@Controller
@RequestMapping("manager/user")
public class ManagerUserController extends FreemarkerBaseController<User> {

}
