package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.UrlService;
import okkpp.model.Url;
import okkpp.service.TeddyServiceBase;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

@Service
@Bean
@Singleton
public class UrlServiceImpl extends TeddyServiceBase<Url> implements UrlService {

}