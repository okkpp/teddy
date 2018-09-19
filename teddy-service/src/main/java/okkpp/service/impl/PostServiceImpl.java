package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.PostService;
import okkpp.model.Post;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

@Service
@Bean
@Singleton
public class PostServiceImpl extends JbootServiceBase<Post> implements PostService {

}