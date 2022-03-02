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
@ComponentScan(basePackages = {"com.bookapp.model"})
@Import(DbConfig.class)
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class ModelConfig {
	
	private Properties getHibernateProps() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto","update");
		properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL57Dialect");
		properties.setProperty("hibernate.show_sql","true");
		properties.setProperty("hibernate.format_sql","true");
		return properties;
	}
	
	@Bean
	public LocalSessionFactoryBean getLocalSessionFactoryBean(DriverManagerDataSource dataSource) {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setPackagesToScan(new String[] {"com.bookapp.model.dao"});
		factoryBean.setHibernateProperties(getHibernateProps());
		return factoryBean;
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
}
