package okkpp.controller.user;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
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
import okkpp.common.utils.EhcacheUtil;
import okkpp.constants.EhCacheConstants;
import okkpp.dto.UserDTO;
import okkpp.model.User;
import okkpp.service.UserService;
import okkpp.vo.UserVO;

@Api(description = "用户管理")
@RequestMapping("user")
@RestController
public class UserController extends BaseController {

	@Autowired
	UserService userService;
	@Autowired
	EhcacheUtil ehcacheUtil;

	@ApiOperation("登陆")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username", paramType = "query", value = "用户名", required = true, dataType = "String"),
			@ApiImplicitParam(name = "password", paramType = "query", value = "密码", required = true, dataType = "String") })
	@PostMapping("login")
	public Result<String> login(HttpServletResponse response, UsernamePasswordToken token) {
		Subject subject = SecurityUtils.getSubject();

		try {
			subject.login(token);
			UUID uuid = UUID.randomUUID();
			// 把用户登录信息存入缓存 key值为 TOKEN_{用户标识}
			ehcacheUtil.put(EhCacheConstants.TOKEN_PREFIX + uuid.toString(), token);
			response.addCookie(new Cookie("token", uuid.toString()));
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
	public Result<UserDTO> currentUser() {
		UserDTO user = transfer(getSubject(), UserDTO.class);
		return new Result<UserDTO>(user);
	}

	@ApiOperation("注册")
	@GetMapping("register")
	public Result<String> register(UserVO user) {
		user.setPassword(new SimpleHash("SHA-256", user.getPassword(), null, 1024).toHex());
		User model = transfer(user, User.class);
		boolean result = userService.save(model);
		if (result) {
			return Result.success();
		} else {
			return Result.failed();
		}
	}

	@ApiOperation("退出登录")
	@GetMapping("logout")
	public Result<String> logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return new Result<>("退出登录");
	}

	@ApiOperation("未授权")
	@GetMapping("unauthorized")
	public Result<String> unauthorized() {
		return new Result<>("没有权限");
	}
}
