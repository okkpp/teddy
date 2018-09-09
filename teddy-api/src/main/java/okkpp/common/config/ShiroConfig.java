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
		
		Map<String, String> filterChain = new LinkedHashMap<>();
		filterChain.put("/user/logout", "logout");
		filterChain.put("/user/login", "anon");
		
		filterChain.put("/swagger-ui.html", "anon");
		filterChain.put("/swagger-resources/**", "anon");
		filterChain.put("/v2/**", "anon");
		
		filterChain.put("/**", "authc");
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
		return new MyShiroRealm();
	}

    /**
     * 凭证匹配器
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * ）
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
        return hashedCredentialsMatcher;
    }
}
