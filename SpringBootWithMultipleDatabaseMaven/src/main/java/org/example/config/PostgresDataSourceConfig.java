package org.example.config;


import javax.sql.DataSource;
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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(
        basePackages = "org.example.repository.postgres",
        entityManagerFactoryRef = "postgresEntityManager",
        transactionManagerRef = "postgresTransactionManager"
)
public class PostgresDataSourceConfig {

    @Primary
    @Bean("postgresDb")
    @ConfigurationProperties(prefix = "postgres.datasource")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Primary
    @Bean("postgresEntityManager")
    public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(
            EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
        Map<String, Object> jpaPropertiesMap = new HashMap<>();
        jpaPropertiesMap.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        return entityManagerFactoryBuilder.dataSource(postgresDataSource())
                .packages("org.example.domain.postgres")
                .persistenceUnit("brands_mapping")
                .properties(jpaPropertiesMap)
                .build();
    }

    @Primary
    @Bean("postgresTransactionManager")
    public PlatformTransactionManager postgresTransactionManager(
            @Qualifier("postgresEntityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
    }
}
