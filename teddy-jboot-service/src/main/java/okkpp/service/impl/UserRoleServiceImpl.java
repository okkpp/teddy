package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.UserRoleService;
import okkpp.model.UserRole;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

@Service
@Bean
@Singleton
public class UserRoleServiceImpl extends JbootServiceBase<UserRole> implements UserRoleService {

}