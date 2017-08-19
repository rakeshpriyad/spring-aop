package com.student.spring.aop.annotation.after.returning;

public interface CustomerBo {

	void addCustomer();

	String addCustomerReturnValue();

	void addCustomerThrowException() throws Exception;

	void addCustomerAround(String name);
}