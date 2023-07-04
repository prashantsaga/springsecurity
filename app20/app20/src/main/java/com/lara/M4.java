package com.lara;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class M4 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Customer obj1 = (Customer)context.getBean("c1",Customer.class);
		System.out.println(obj1.getFirstName());
		System.out.println(obj1.getLastName());
		Address add = obj1.getAddress();// explicitly wiring one object to another object.
		System.out.println(add.getHouseNo());
		System.out.println(add.getStreetName());
	}
}
