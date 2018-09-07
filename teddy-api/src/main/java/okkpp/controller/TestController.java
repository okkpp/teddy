package okkpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import okkpp.model.User;
import okkpp.service.TestService;
import okkpp.service.UserService;

@Api(description="测试API")
@RequestMapping("/test")
@RestController
public class TestController {

	@Autowired
	TestService service;
	@Autowired
	UserService user;
	
	@ApiOperation("一个测试接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", paramType = "query", value = "用户名", required = true, dataType = "String")
    })
	@GetMapping("/page")
	public String page(String username) {
		User u = user.findById(1);
		System.out.println(u.toJson());
		return u.toJson();
	}
}
