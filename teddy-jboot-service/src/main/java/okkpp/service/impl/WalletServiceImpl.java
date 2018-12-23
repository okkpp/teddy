package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.WalletService;
import okkpp.model.Wallet;
import okkpp.service.TeddyServiceBase;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

@Service
@Bean
@Singleton
public class WalletServiceImpl extends TeddyServiceBase<Wallet> implements WalletService {

}