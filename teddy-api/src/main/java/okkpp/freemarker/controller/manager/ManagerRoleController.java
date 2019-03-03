package okkpp.freemarker.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import okkpp.freemarker.controller.base.FreemarkerBaseController;
import okkpp.model.Role;

@Controller
@RequestMapping("manager/role")
public class ManagerRoleController extends FreemarkerBaseController<Role> {

}
