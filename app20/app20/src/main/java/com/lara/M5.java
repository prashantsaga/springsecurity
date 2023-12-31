package com.lara;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class M5 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Author obj1 = (Author)context.getBean("author",Author.class);
		System.out.println(obj1.getFirstName());
		System.out.println(obj1.getLastName());
		Address add = obj1.getAddress();// explicitly wiring one object to another object.
		System.out.println(add.getHouseNo());
		System.out.println(add.getStreetName());
	}
}
