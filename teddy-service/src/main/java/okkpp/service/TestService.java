package okkpp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

@Service
public class TestService {

	public void test() {
		System.out.println("service");
		List<Record> list = Db.find("select * from t_buyer_user");
		for(Record r : list) {
			System.out.println(r.toJson());
		}
	}
}
