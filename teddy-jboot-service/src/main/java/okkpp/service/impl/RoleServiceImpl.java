package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.RoleService;
import okkpp.service.TeddyServiceBase;
import okkpp.model.Role;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

@Service
@Bean
@Singleton
public class RoleServiceImpl extends TeddyServiceBase<Role> implements RoleService {

}