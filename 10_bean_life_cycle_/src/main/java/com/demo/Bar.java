package com.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Bar implements InitializingBean, DisposableBean {

	private String barName;

	public Bar() {
		System.out.println("ctr of bar is called...");
	}

	public void setBarName(String barName) {
		System.out.println("setter of bar is called...");
		this.barName = barName;
	}

	// --------------------post contr wale-------------
	@PostConstruct
	public void afterBeanCreatedAnnotationWala() {
		System.out.println("afterBeanCreated annotation wala bar");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterBeanCreated InitializingBean wala bar ");
	}

	public void afterBeanCreatedXmlWala() {
		System.out.println("afterBeanCreated xml wala bar");
	}

	
	
	
	

	public String getBarName() {
		return barName;
	}

	public void doWork() {
		System.out.println("---------------");
		System.out.println("i am doing work: " + barName);
		System.out.println("---------------");
	}

	// ---------------pre destoye wale------------
	@PreDestroy
	public void preDestructionAnnotationWala() {
		System.out.println("preDestruction annotation wala bar");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("desty method of DisposableBean bar");
	}

	public void preDestoroyXmlWala() {
		System.out.println("preDestoroy xml wala bar");
	}
	
}