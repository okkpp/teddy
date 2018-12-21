package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.PostFavorService;
import okkpp.model.PostFavor;
import okkpp.service.TeddyServiceBase;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

@Service
@Bean
@Singleton
public class PostFavorServiceImpl extends TeddyServiceBase<PostFavor> implements PostFavorService {

}