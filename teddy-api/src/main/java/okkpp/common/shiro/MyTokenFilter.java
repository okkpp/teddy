package okkpp.common.shiro;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;

import okkpp.common.result.Result;
import okkpp.service.RoleUrlService;
import okkpp.service.UserService;

@Component
public class MyTokenFilter extends AccessControlFilter {
	
	@Autowired
	private RoleUrlService roleUrlService;
	@Autowired
	private UserService userService;
	
	public void init() {
		roleUrlService.toString();
		userService.toString();
	}
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		userService.findUserUrl(0L);
		
		String permission = WebUtils.getPathWithinApplication(WebUtils.toHttp(request)).substring(0);
		if (StringUtils.isEmpty(permission)) {
			return true;
		}
		List<String> publicRole = roleUrlService.getPublicRole();
		PatternMatcher matcher = new AntPathMatcher();
		for(String uri : publicRole) {
			if(null!=uri && matcher.matches(uri, permission)) {
				return true;
			}
		}
		
		HttpServletRequest rq = (HttpServletRequest) request;
		System.out.println("onPreHandle");
		
		String token = rq.getHeader("token");
		System.out.println("token : "+token);
		
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		Subject subject = getSubject(request, response);
		if (!subject.isAuthenticated()) {
            authenticationFailed(response);
			return false;
		}
		return true;
	}
	
    /**
     * 认证失败
     *
     * @param response
     * @throws IOException
     */
    private void authenticationFailed(ServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.getWriter().write(JSON.toJSONString(Result.notLogin()));
    }
}
