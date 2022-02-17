package com.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audiance {

	@Around("execution(public void doMagic())")
	public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("starting around...");
		//pjp.proceed();
		System.out.println("end around");
	}
	
	
	
//	@AfterThrowing("execution(public void doMagic())")
//	public void callDr() {
//		System.out.println("Call dr now.");
//	}
//	
//	@AfterReturning("execution(public void doMagic())")
//	public void doClappingAfterReturning() {
//		System.out.println(" clap clap.after.after returing..");
//	}
//	
//	@After("execution(public void doMagic())")
//	public void doClappingAfter() {
//		System.out.println(" clap clap.after...");
//	}
//	
//	@Before("execution(public void doMagic())")
//	public void doClapping() {
//		System.out.println("maza aa gaya.. wow clap clap....");
//	}
//
//	@Pointcut("execution(public void doMagic())")
//	public void myPointCut() {}
//	
//	@Before("myPointCut()")
//	public void doClapping() {
//		System.out.println("maza aa gaya.. wow clap clap....");
//	}
}
