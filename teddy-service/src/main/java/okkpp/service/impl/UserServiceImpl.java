package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.UserService;
import okkpp.model.User;
import io.jboot.service.JbootServiceBase;

import java.util.List;

import javax.inject.Singleton;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

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

	@Override
	@Cacheable("data")
	public List<Record> findUserUrl(Long userId) {
		List<Record> list = Db.find("select temp.* from t_role left join "
				+ "(select b.user_id,a.* from "
				+ "(select t_role_url.role_id,t_url.url from t_role_url left join t_url "
				+ "on t_role_url.url_id = t_url.id where t_role_url.`enable` = t_url.`enable` and t_role_url.`enable` = 1)as a "
				+ "left join "
				+ "(select t_user_role.user_id,t_user_role.role_id from t_user_role left join t_user "
				+ "on t_user_role.user_id = t_user.id where t_user_role.`enable` = t_user.`enable` and t_user_role.`enable` = 1)as b "
				+ "on a.role_id = b.role_id) as temp "
				+ "on t_role.id = temp.role_id "
				+ "where t_role.`enable` = 1 and temp.user_id = ? ", userId);
		return list;
	}

}