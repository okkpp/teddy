package okkpp.user.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import okkpp.common.base.BaseController;
import okkpp.common.result.Result;
import okkpp.dto.UserDTO;
import okkpp.model.User;
import okkpp.service.UserService;

@Api(description="用户管理")
@RequestMapping("user")
@RestController
public class UserController extends BaseController {

	@Autowired
	UserService userService;
	
	@ApiOperation("登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", paramType = "query", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", paramType = "query", value = "密码", required = true, dataType = "String")
    })
	@PostMapping("login")
	public Result<String> login(UsernamePasswordToken token) {
		Subject subject = SecurityUtils.getSubject();
		
		try {
			subject.login(token);
			return new Result<>("登录成功");
		} catch (IncorrectCredentialsException e) {
			return new Result<>("密码错误");
		} catch (LockedAccountException e) {
			return new Result<>("登录失败，该用户已被冻结");
		} catch (AuthenticationException e) {
			return new Result<>("该用户不存在");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Result<>("登录错误");
	}
	
	@ApiOperation("登录信息")
	@GetMapping("currentUser")
	public Result<UserDTO> currentUser(){
		Subject subject = SecurityUtils.getSubject();
		UserDTO user = new UserDTO();
		BeanUtils.copyProperties((User) subject.getPrincipal(), user);
		return new Result<UserDTO>(user);
	}
	
	@ApiOperation("注册")
	@GetMapping("register")
	public Result<String> register(UserDTO user){
		user.setPassword(new SimpleHash("SHA-256", user.getPassword(), null, 1024).toHex());
		User model = new User();
		BeanUtils.copyProperties(user, model);
		boolean result = userService.save(model);
		if(result) {
			return Result.success();
		}else {
			return Result.failed();
		}
	}
	
	@ApiOperation("退出登录")
	@GetMapping("logout")
	public Result<String> logout(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return new Result<>("退出登录");
	}
	
	@ApiOperation("未授权")
	@GetMapping("unauthorized")
	public Result<String> unauthorized(){
		return new Result<>("没有权限");
	}
}
