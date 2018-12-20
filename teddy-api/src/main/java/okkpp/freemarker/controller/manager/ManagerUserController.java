package okkpp.freemarker.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import okkpp.common.base.BaseController;
import okkpp.common.result.PageInfo;
import okkpp.common.result.PagedResult;
import okkpp.model.User;
import okkpp.service.UserService;

@Controller
@RequestMapping("manager/user")
public class ManagerUserController extends BaseController {

	@Autowired
	private UserService userService;
	
	@GetMapping("list")
	@ResponseBody
	public PagedResult<List<User>> list(PageInfo pageinfo) {
		return userService.list(pageinfo);
	}
}
