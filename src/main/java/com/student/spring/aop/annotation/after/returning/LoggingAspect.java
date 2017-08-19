package com.student.spring.aop.annotation.after.returning;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	@Before("execution(* com.student.spring.aop.annotation.after.returning.CustomerBo.addCustomer(..))")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("logBefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@After("execution(* com.student.spring.aop.annotation.after.returning.CustomerBo.addCustomer(..))")
	public void logAfter(JoinPoint joinPoint) {

		System.out.println("logAfter() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");

	}
	
	@AfterReturning(
		      pointcut = "execution(* com.student.spring.aop.annotation.after.returning.addCustomerReturnValue(..))",
		      returning= "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {

		System.out.println("logAfterReturning() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Method returned value is : " + result);
		System.out.println("******");

	}
	
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

		System.out.println("logAfterThrowing() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		System.out.println("******");

	}
	
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("logAround() is running!");
		System.out.println("hijacked method : " + joinPoint.getSignature().getName());
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
		
		System.out.println("Around before is running!");
		joinPoint.proceed();
		System.out.println("Around after is running!");
		
		System.out.println("******");

	}
	
}