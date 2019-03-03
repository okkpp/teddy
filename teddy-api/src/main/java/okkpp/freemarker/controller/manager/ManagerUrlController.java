package okkpp.freemarker.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import okkpp.freemarker.controller.base.FreemarkerBaseController;
import okkpp.model.Url;

@Controller
@RequestMapping("manager/url")
public class ManagerUrlController extends FreemarkerBaseController<Url> {

}
