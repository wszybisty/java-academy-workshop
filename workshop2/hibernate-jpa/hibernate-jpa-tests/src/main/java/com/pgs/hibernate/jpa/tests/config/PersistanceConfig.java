package com.pgs.hibernate.jpa.tests.config;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 *
 * @author wszybisty
 */
@Configuration
public class PersistanceConfig {
    @Value("${spring.datasource.url}")
    private String url;
    
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;
    
    @Value("${spring.datasource.username}")
    private String username;
    
    @Value("${spring.datasource.password}")
    private String password;
    
    @Value("${hibernate.dialect}")
    private String hibernateDialect;
    
    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddl;
    
    @Value("${hibernate.format_sql}")
    private String formatSql;
    
    @Value("${hibernate.show_sql}")
    private String showSql;
    
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        
        return dataSource;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan("com.pgs.hibernate.jpa.tests.model");
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactory.setJpaProperties(new Properties(){{
            put("hibernate.dialect", hibernateDialect);
            put("hibernate.hbm2ddl.auto", hbm2ddl);
            put("hibernate.show_sql", showSql);
            put("hibernate.format_sql", formatSql);
        }});
        
        return entityManagerFactory;
    }
    
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        final JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }
}
