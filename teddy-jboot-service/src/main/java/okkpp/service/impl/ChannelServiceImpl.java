package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.ChannelService;
import okkpp.model.Channel;
import okkpp.service.TeddyServiceBase;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

@Service
@Bean
@Singleton
public class ChannelServiceImpl extends TeddyServiceBase<Channel> implements ChannelService {

}