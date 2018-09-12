package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.UserService;
import okkpp.model.User;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

@Service
@Bean
@Singleton
public class UserServiceImpl extends JbootServiceBase<User> implements UserService {

	private User userDao = new User().dao();
	
	@Override
	public User checkLoginUser(String username) {
		User user = userDao.findFirst("select * from t_user where username = ? ", username);
		return user;
	}

}