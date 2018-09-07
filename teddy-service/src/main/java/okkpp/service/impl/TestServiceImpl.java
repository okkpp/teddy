package okkpp.service.impl;

import java.util.List;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import io.jboot.aop.annotation.Bean;
import okkpp.service.TestService;

@Service
@Bean
@Singleton
public class TestServiceImpl implements TestService {

	@Override
	public void test()  {
		System.out.println("service");
		List<Record> list = Db.find("select * from t_user");
		for(Record r : list) {
			System.out.println(r.toJson());
		}
	}

}
