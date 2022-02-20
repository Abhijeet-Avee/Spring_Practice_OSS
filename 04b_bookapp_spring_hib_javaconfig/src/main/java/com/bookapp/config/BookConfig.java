package com.bookapp.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.bookapp"})
@EnableAspectJAutoProxy
@EnableTransactionManagement
@Import(DbConfig.class)
public class BookConfig {
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory(DriverManagerDataSource ds) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(ds);
		sessionFactory.setPackagesToScan("com.bookapp.model.dao");
		sessionFactory.setHibernateProperties(getHibProperties());
		return sessionFactory;
	}
	
	private Properties getHibProperties() {
		Properties prop = new Properties();
		prop.setProperty("hibernate.hbm2ddl.auto","update");
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		prop.setProperty("hibernate.show.sql", "true");
		prop.setProperty("hibernate.format_sql", "true");
		return prop;
	}

	@Bean
	public HibernateTransactionManager getManager(SessionFactory sessionFactory) {
		HibernateTransactionManager manager = new HibernateTransactionManager();
		manager.setSessionFactory(sessionFactory);;
		return manager;
	}
}
