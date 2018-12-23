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
import okkpp.common.result.Result;
import okkpp.model.Role;
import okkpp.model.User;
import okkpp.service.RoleService;
import okkpp.service.UserService;

@Controller
@RequestMapping("manager/user")
public class ManagerUserController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@GetMapping("listUser")
	@ResponseBody
	public PagedResult<List<User>> listUser(PageInfo pageinfo) {
		return userService.list(pageinfo, User.table);
	}

	@GetMapping("listRole")
	@ResponseBody
	public PagedResult<List<Role>> listRole(PageInfo pageinfo) {
		return roleService.list(pageinfo, Role.table);
	}
	
	@RequestMapping("saveRole")
	@ResponseBody
	public Result<String> saveRole(Role role) {
		return Result.judge(roleService.saveOrUpdate(role));
	}
}
