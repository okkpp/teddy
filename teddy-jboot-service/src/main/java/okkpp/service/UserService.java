package okkpp.service;

import okkpp.model.User;

import java.util.List;

public interface UserService extends BaseService<User> {

	User getUserByName(String username);

	List<String> findUserUrl(Long userId);

	List<String> findUserUrl(String username);
}