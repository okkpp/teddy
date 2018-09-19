package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.RoleService;
import okkpp.model.Role;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

@Service
@Bean
@Singleton
public class RoleServiceImpl extends JbootServiceBase<Role> implements RoleService {

}