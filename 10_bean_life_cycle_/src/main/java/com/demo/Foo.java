package com.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Foo implements InitializingBean, DisposableBean {

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

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterBeanCreated InitializingBean wala  ");
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

	// ---------------pre destoye wale------------
	@PreDestroy
	public void preDestructionAnnotationWala() {
		System.out.println("preDestruction annotation wala");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("desty method of DisposableBean");
	}

	
}