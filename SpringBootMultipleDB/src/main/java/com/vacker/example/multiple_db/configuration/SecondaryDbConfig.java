package com.vacker.example.multiple_db.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "secondaryEntityManagerFactory", 
        transactionManagerRef = "secondaryTransactionManager",
        basePackages = { "com.vacker.example.multiple_db.domain.secondary" })
public class SecondaryDbConfig {
	
	@Bean(name = "secondaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.secondary")
    public DataSource barDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("secondaryDataSource") DataSource secondaryDataSource) {
        return builder
                .dataSource(secondaryDataSource)
                .packages("com.vacker.example.multiple_db.domain.secondary")
                .persistenceUnit("$$$$$$ SECONDARY $$$$$$")
                .build();
    }

    @Bean(name = "secondaryTransactionManager")
    public PlatformTransactionManager barTransactionManager(
            @Qualifier("secondaryEntityManagerFactory") EntityManagerFactory secondaryEntityManagerFactory) {
        return new JpaTransactionManager(secondaryEntityManagerFactory);
    }
}
