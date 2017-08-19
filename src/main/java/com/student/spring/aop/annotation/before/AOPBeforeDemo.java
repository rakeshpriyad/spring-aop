package com.student.spring.aop.annotation.before;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPBeforeDemo {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring-config-aop-annotation-before.xml" });

		CustomerBo cbo = (CustomerBo) context.getBean("customerBo");
		System.out.println(cbo);
		cbo.addCustomer();
		context.close();
	}
}