package okkpp.common.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

public class MyAuthorizationFilter extends AuthorizationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		String uri = WebUtils.getPathWithinApplication(WebUtils.toHttp(request)).substring(0);
		System.out.println(uri);
		if (StringUtils.isEmpty(uri)) {
			return true;
		} else {
			Subject subject = getSubject(request, response);
			return subject.isPermitted(uri);
		}
	}

}
