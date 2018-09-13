package okkpp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import okkpp.common.base.BaseController;
import okkpp.common.result.PagedResult;
import okkpp.common.result.Result;
import okkpp.dto.UserDTO;
import okkpp.model.User;
import okkpp.service.TestService;
import okkpp.service.UserService;

@Api(value="测试API")
@RequestMapping("/test")
@RestController
public class TestController extends BaseController {

	@Autowired
	TestService service;
	@Autowired
	UserService user;
	
	@ApiOperation("一个测试接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", paramType = "query", value = "用户名", required = true, dataType = "String")
    })
	@GetMapping("/page")
	public Result<UserDTO> page(@ApiParam UserDTO userDto, String username) {
		User u = user.findById(1);
		System.out.println(u.toJson());
		UserDTO result = new UserDTO();
		BeanUtils.copyProperties(u, result);
		return new Result<UserDTO>(result);
	}
	
	@ApiOperation("测试分页结果集")
	@GetMapping("paged")
	public PagedResult<List<UserDTO>> paged() {
		List<UserDTO> list = new ArrayList<UserDTO>();
		list.add(new UserDTO());
		list.add(new UserDTO());
		return new PagedResult<>(list);
	}
	
	@ApiOperation("测试捕捉异常接口")
	@GetMapping("error")
	public Result<String> error() throws Exception {
		throw new Exception("my test exception");
	}
}
