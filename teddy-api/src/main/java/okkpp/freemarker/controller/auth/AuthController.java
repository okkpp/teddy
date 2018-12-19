package okkpp.freemarker.controller.auth;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import okkpp.common.result.Result;
import okkpp.common.utils.EhcacheUtil;
import okkpp.constants.EhCacheConstants;
import okkpp.model.User;
import okkpp.service.UserService;

@Controller
@RequestMapping("auth")
public class AuthController {

	@Autowired
	UserService userService;
	@Autowired
	EhcacheUtil ehcacheUtil;
	
	@RequestMapping("login")
	public String index(Model model) {
		return "/auth/auth_login";
	}
	
	@PostMapping("auth")
	public String login(Model model, HttpServletResponse response, UsernamePasswordToken token) {
		Subject subject = SecurityUtils.getSubject();

		try {
			subject.login(token);
			UUID uuid = UUID.randomUUID();
			// 把用户登录信息存入缓存 key值为 TOKEN_{用户标识}
			ehcacheUtil.put(EhCacheConstants.TOKEN_PREFIX + uuid.toString(), token);
			response.addCookie(new Cookie("token", uuid.toString()));
			
			model.addAttribute("user", new Result<>((User)subject.getPrincipal()));
			return "/auth/auth_login";
		} catch (IncorrectCredentialsException e) {
			model.addAttribute("result", new Result<>("密码错误"));
			return "/auth/auth_login";
		} catch (LockedAccountException e) {
			model.addAttribute("result", new Result<>("登录失败，该用户已被冻结"));
			return "/auth/auth_login";
		} catch (AuthenticationException e) {
			model.addAttribute("result", new Result<>("该用户不存在"));
			return "/auth/auth_login";
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("result", new Result<>("登录错误"));
		return "/auth/auth_login";
	}
}
