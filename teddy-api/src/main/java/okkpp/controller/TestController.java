package okkpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import okkpp.model.User;
import okkpp.service.TestService;
import okkpp.service.UserService;

@RequestMapping("/test")
@RestController
public class TestController {

	@Autowired
	TestService service;
	@Autowired
	UserService user;
	
	@GetMapping("/page")
	public String page() {
		User u = user.findById(1);
		System.out.println(u.toJson());
		return u.toJson();
	}
}
