package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.RoleUrlService;
import okkpp.model.RoleUrl;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

@Service
@Bean
@Singleton
public class RoleUrlServiceImpl extends JbootServiceBase<RoleUrl> implements RoleUrlService {

}