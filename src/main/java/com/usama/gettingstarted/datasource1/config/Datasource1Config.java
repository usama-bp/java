package com.usama.gettingstarted.datasource1.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "studentEntityManagerFactory",
    transactionManagerRef = "studentTransactionManager",
    basePackages = {
            "com.usama.gettingstarted.datasource1.repository"
})
public class Datasource1Config {
    @Primary
    @Bean(name = "studentDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.fungun")
    public DataSource studentDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "studentEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("studentDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("com.usama.gettingstarted.datasource1").persistenceUnit("db1").build();
    }

    @Primary
    @Bean(name = "studentTransactionManager")
    public PlatformTransactionManager studentTransactionManager(
            @Qualifier("studentEntityManagerFactory") EntityManagerFactory studentEntityManagerFactory ) {
        return new JpaTransactionManager(studentEntityManagerFactory);
    }
}
