package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.BaseService;
import okkpp.model.Base;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

@Service
@Bean
@Singleton
public class BaseServiceImpl extends JbootServiceBase<Base> implements BaseService {

}