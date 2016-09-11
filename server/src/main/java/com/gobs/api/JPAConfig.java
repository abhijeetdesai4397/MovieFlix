package com.gobs.api;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.logging.SessionLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfig {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean= new LocalContainerEntityManagerFactoryBean();
		containerEntityManagerFactoryBean.setDataSource(getDatasource());
		containerEntityManagerFactoryBean.setJpaProperties(getProperties());
		containerEntityManagerFactoryBean.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
		containerEntityManagerFactoryBean.setPackagesToScan("com.gobs.api.bean");
		return containerEntityManagerFactoryBean;
	}
	
	@Bean
	public DataSource getDatasource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("movieflix");
		dataSource.setPassword("movieflix");
		return dataSource;
	}
	
	private Properties getProperties()
	{
		Properties props=new Properties();
		props.setProperty(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.CREATE_ONLY);
		props.setProperty(PersistenceUnitProperties.LOGGING_LEVEL, SessionLog.FINE_LABEL);
		props.setProperty(PersistenceUnitProperties.WEAVING,"false");
		return props;
	}

	@Bean
	public PlatformTransactionManager getTransactionManager(EntityManagerFactory emf)
	{
		PlatformTransactionManager transactionManager=new JpaTransactionManager(emf);
		return transactionManager;
	}
}
