package com.bankapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"com.bankapp"})
@PropertySource	("classpath:db.properties")//<context:property-placeholder location="classpath:db.properties"/>
//@ImportResource
public class AppConfig {

	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.driverName}")
	private String driverClassName;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	
	@Bean
	public DriverManagerDataSource getDriverManagerDataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		
		return dataSource;
	}
}
