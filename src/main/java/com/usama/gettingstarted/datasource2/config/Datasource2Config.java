package com.usama.gettingstarted.datasource2.config;

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
        entityManagerFactoryRef = "departmentEntityManagerFactory",
        transactionManagerRef = "departmentTransactionManager",
        basePackages = {
                "com.usama.gettingstarted.datasource2.repository"
        }
)
public class Datasource2Config {

    @Bean(name = "departmentDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.gunfun")
    public DataSource departmentDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "departmentEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("departmentDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("com.usama.gettingstarted.datasource2").persistenceUnit("db2").build();
    }

    @Bean(name = "departmentTransactionManager")
    public PlatformTransactionManager departmentTransactionManager(
            @Qualifier("departmentEntityManagerFactory") EntityManagerFactory departmentEntityManagerFactory ) {
        return new JpaTransactionManager(departmentEntityManagerFactory);
    }

}
