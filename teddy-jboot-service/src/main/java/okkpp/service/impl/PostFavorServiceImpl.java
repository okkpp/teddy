package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.PostFavorService;
import okkpp.model.PostFavor;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

@Service
@Bean
@Singleton
public class PostFavorServiceImpl extends JbootServiceBase<PostFavor> implements PostFavorService {

}