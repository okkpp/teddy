package okkpp.common.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import okkpp.common.shiro.MyShiroRealm;

@Configuration
public class ShiroConfig {

	@Bean
	public ShiroFilterFactoryBean shiroFilter() {
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		shiroFilter.setSecurityManager(securityManager());
		shiroFilter.setLoginUrl("/swagger-ui.html");
		shiroFilter.setUnauthorizedUrl("/swagger-ui.html");
		
		Map<String, String> filterChain = new LinkedHashMap<>();
		filterChain.put("/user/logout", "logout");
		filterChain.put("/user/login", "anon");
		
		filterChain.put("/swagger-ui.html", "anon");
		filterChain.put("/webjars/**", "anon");
		filterChain.put("/swagger-resources/**", "anon");
		filterChain.put("/v2/**", "anon");
		
		filterChain.put("/**", "anon");
		shiroFilter.setFilterChainDefinitionMap(filterChain);
		
		return shiroFilter;
	}
	
	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		
		securityManager.setRealm(shiroRealm());
		
		return securityManager;
	}
	
	@Bean
	public MyShiroRealm shiroRealm() {
		MyShiroRealm realm = new MyShiroRealm();
		realm.setCredentialsMatcher(hashedCredentialsMatcher());
		return realm;
	}

    /**
     * 凭证匹配器
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * ）
     * HashedCredentialsMatcher说明：
     * 用户传入的token先经过shiroRealm的doGetAuthenticationInfo方法
     * 此时token中的密码为明文。
     * 再经由HashedCredentialsMatcher加密password与查询用户的结果password做对比。
     * new SimpleHash("SHA-256", password, null, 1024).toHex();
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("SHA-256");//散列算法:这里使用SHA-256算法;
        hashedCredentialsMatcher.setHashIterations(1024);//散列的次数，比如散列两次，相当于 MD5(MD5(""));
        return hashedCredentialsMatcher;
    }
}
