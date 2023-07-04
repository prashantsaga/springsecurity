package com.example.securityapp1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("hello")
	public String sayHello()
	{
		System.out.println("sayhello");
		return "from hello api";
	}
	@RequestMapping("test")
	public String sayTest()
	{
		System.out.println("saytest");
		return "from test api";
	}
	@RequestMapping("/")
	public String say()
	{
		System.out.println("say");
		return "from say api";
	}
}
