package okkpp.common.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import okkpp.common.shiro.CrossDomainFilter;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean<CrossDomainFilter> crossDomainFilter() {
		FilterRegistrationBean<CrossDomainFilter> registration = new FilterRegistrationBean<CrossDomainFilter>();
		registration.setFilter(new CrossDomainFilter());
		registration.addUrlPatterns("/*");
		registration.setName("crossDomainFilter");
		registration.setOrder(1);
		return registration;
	}
}
