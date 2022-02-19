package com.bankapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.bankapp"})
@EnableAspectJAutoProxy
@EnableTransactionManagement
@Import(DbConfig.class)
public class AppConfig {
	
	@Bean
	public LocalSessionFactoryBean getLocalSessionFactoryBean(DataSource dataSource) {
		LocalSessionFactoryBean lsb = new LocalSessionFactoryBean();
		lsb.setDataSource(dataSource);
		lsb.setPackagesToScan(new String[] {"com.bankapp.model.dao"});
		lsb.setHibernateProperties(getHibernateProperties());
		return lsb;
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.show.sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		return null;
	}

	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager ht = new HibernateTransactionManager();
		ht.setSessionFactory(sessionFactory);
		return ht;
	}
	
}
