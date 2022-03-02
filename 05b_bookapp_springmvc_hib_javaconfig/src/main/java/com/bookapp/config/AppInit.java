package com.bookapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
	System.out.println("----getRootCofigClasses-----");
		return new Class[] {ModelConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("----getServletConfigClasses-----");
		return new Class[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
