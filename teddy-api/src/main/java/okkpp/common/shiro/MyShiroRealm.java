package okkpp.common.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import okkpp.model.User;
import okkpp.service.UserService;

public class MyShiroRealm extends AuthorizingRealm{

	@Autowired
	UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		return null;
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
