package com.bookapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc	//<mvc:annotation-driven />
@ComponentScan(basePackages = {"com.bookapp.web"})

public class WebConfig {
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		return messageSource;
	}
	
	@Bean
	public LocalValidatorFactoryBean getFactoryBean(ReloadableResourceBundleMessageSource messageSource) {
		LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
		factoryBean.setValidationMessageSource(messageSource);
		return factoryBean;
	}
	
}
