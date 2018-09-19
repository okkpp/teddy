package okkpp.common.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;
import org.springframework.beans.factory.annotation.Autowired;

import com.jfinal.plugin.activerecord.Record;

import okkpp.model.User;
import okkpp.service.UserService;

public class MyShiroRealm extends AuthorizingRealm{

	@Autowired
	UserService userService;
	
	@Override
	public boolean isPermitted(PrincipalCollection principals, String permission) {
//		User user = (User)principals.getPrimaryPrincipal();
//		PatternMatcher matcher = new AntPathMatcher();
//		List<Record> urlList = userService.findUserUrl(user.getId());
//		for(Record record : urlList) {
//			if(matcher.matches(record.getStr("url"), permission)) {
//				return true;
//			}
//		}
		return super.isPermitted(principals, permission);
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		System.out.println("doGetAuthorizationInfo");
		User user = (User) getAvailablePrincipal(arg0);
		List<Record> urlList = userService.findUserUrl(user.getId());
		Set<String> perms = new HashSet<>();
		for(Record record : urlList) {
			String url = record.getStr("url");
			if(null!=url) {
				perms.add(url);
			}
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(perms);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) arg0;
		String username = token.getUsername();
		User user = userService.checkLoginUser(username);
		if(null != user) {
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
			return info;
		}
		return null;
	}

}
