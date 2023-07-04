package com.lara;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class M3 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Student obj1 = context.getBean("s1", Student.class);
//		Student obj2 = context.getBean("s1", Student.class);
//		Student obj3 = context.getBean("s1", Student.class);
//		Student obj4 = context.getBean("s1", Student.class);
//		Student obj5 = context.getBean("s1", Student.class);
//		System.out.println(obj1 == obj2);
//		System.out.println(obj2 == obj3);
//		System.out.println(obj4 == obj5);
//		System.out.println(obj5 == obj1);
		
		System.out.println("object is ready");
		System.out.println(obj1.getFirstName());
		System.out.println(obj1.getLastName());
		context.registerShutdownHook(); /* object is removing from container    while evacuating it is call distory method */
		System.out.println("done");
	}
}
