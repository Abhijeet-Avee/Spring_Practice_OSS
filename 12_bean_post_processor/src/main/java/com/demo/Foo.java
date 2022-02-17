package com.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Foo implements BeanNameAware , ApplicationContextAware{

	private String fooName;

	public Foo() {
		System.out.println("ctr of foo is called...");
	}

	public void setFooName(String fooName) {
		System.out.println("setter of foo is called...");
		this.fooName = fooName;
	}

	// --------------------post contr wale-------------
	@PostConstruct
	public void afterBeanCreatedAnnotationWala() {
		System.out.println("afterBeanCreated annotation wala");
	}

	public Foo(String fooName) {
		this.fooName = fooName;
	}

	public String getFooName() {
		return fooName;
	}

	public void doWork() {
		System.out.println("---------------");
		System.out.println("i am doing work: " + fooName);
		System.out.println("---------------");
	}

	@PreDestroy
	public void preDestructionAnnotationWala() {
		System.out.println("preDestruction annotation wala");
	}

	@Override
	public void setBeanName(String name) {
		//logging log4j
		System.out.println("^^^^^^^^^^^^^^^^^");
		System.out.println("setBean name method is called : "+ name);
		System.out.println("^^^^^^^^^^^^^^^^");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("#############");
		System.out.println("setApplicationContext method is called..");
		System.out.println("#############");
	}

}




