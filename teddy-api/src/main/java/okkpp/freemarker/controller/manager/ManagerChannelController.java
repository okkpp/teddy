package okkpp.freemarker.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import okkpp.freemarker.controller.base.FreemarkerBaseController;
import okkpp.model.Channel;

@Controller
@RequestMapping("manager/channel")
public class ManagerChannelController extends FreemarkerBaseController<Channel> {

}
