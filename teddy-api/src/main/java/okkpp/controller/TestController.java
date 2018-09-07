package okkpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import okkpp.service.TestService;

@RequestMapping("/test")
@RestController
public class TestController {

	@Autowired
	TestService service;
	
	@GetMapping("/page")
	public String page() {
		service.test();
		return "page";
	}
}
