package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.PostContentService;
import okkpp.model.PostContent;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

@Service
@Bean
@Singleton
public class PostContentServiceImpl extends JbootServiceBase<PostContent> implements PostContentService {

}