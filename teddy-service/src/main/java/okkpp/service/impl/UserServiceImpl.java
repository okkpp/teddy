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

}