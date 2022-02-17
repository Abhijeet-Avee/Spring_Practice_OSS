package com.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackages = {"com.demo"})
public class AppConfig {

//	@Bean(name = "foo")
//	public Foo getFoo() {
//		return new Foo("dev");
//	}
	
	@Profile("dev")
	@Bean(name = "foo")
	public Foo getFoo() {
		return new Foo("dev");
	}
	
	@Profile("prod")
	@Bean(name = "foo")
	public Foo getFooProd() {
		return new Foo("prod");
	}
	
	@Profile("test")
	@Bean(name = "foo")
	public Foo getFooTest() {
		return new Foo("test");
	}
	
}

