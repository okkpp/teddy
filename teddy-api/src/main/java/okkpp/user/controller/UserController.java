package okkpp.user.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import okkpp.common.base.BaseController;

@Api(description="用户登陆管理")
@RequestMapping("user")
@RestController
public class UserController extends BaseController {

	@ApiOperation("登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", paramType = "query", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", paramType = "query", value = "密码", required = true, dataType = "String")
    })
	@PostMapping("login")
	public String login(UsernamePasswordToken token) {
		Subject subject = SecurityUtils.getSubject();

		try {
			subject.login(token);
			return "登录成功";
		} catch (IncorrectCredentialsException e) {
			return "密码错误";
		} catch (LockedAccountException e) {
			return "登录失败，该用户已被冻结";
		} catch (AuthenticationException e) {
			return "该用户不存在";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
}
