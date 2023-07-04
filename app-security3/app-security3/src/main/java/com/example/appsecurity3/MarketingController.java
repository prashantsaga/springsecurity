package com.example.appsecurity3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // This annotation are used in create restapi and return is JSON
@RequestMapping("marketing")// Its Mapps Http Request
public class MarketingController {

	@GetMapping("server1")// This annotation are used for handle the Http requset in the given Url
	public String service1()
	{
		System.out.print("marketting Service1");
		return "from Market Service1";
	}
	@GetMapping("server2")
	public String service2()
	{
		System.out.print("marketting Service2");
		return "from Market Service2";
	}

}
 // JSON - Java Script Object Notation are used in transmitting data in to  the web application.