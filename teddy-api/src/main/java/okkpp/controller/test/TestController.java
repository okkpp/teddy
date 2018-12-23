package okkpp.controller.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
import okkpp.service.UserService;
import okkpp.vo.TestVO;

@Api(value="测试API")
@RequestMapping("/test")
@RestController
public class TestController extends BaseController {

	@Autowired
	UserService user;
	
	@ApiOperation("一个测试接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", paramType = "query", value = "用户名", required = true, dataType = "String")
    })
	@GetMapping("/page")
	@Cacheable("data")
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
		return new PagedResult<>(list, 1, 10, 1, 2);
	}
	
	@ApiOperation("测试捕捉异常接口")
	@GetMapping("error")
	public Result<String> error() throws Exception {
		throw new Exception("my test exception");
	}
	
	@ApiOperation("测试数据校验接口")
	@PostMapping("validate")
	public Result<String> validate(TestVO vo) {
		
		return successMsg("vo:"+vo.toString());
	}
	
	@ApiOperation("测试jbootModel")
	@GetMapping("model")
	public Result<String> model(User user) {
		return Result.success(user.toJson());
	}
}
