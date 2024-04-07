package org.example.config;


import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "org.example.repository.mysql",
        entityManagerFactoryRef = "mySqlEntityManager",
        transactionManagerRef = "mySqlTransactionManager"
)
public class MySqlDataSourceConfig {

    @Bean("mysqlDb")
    @ConfigurationProperties(prefix = "mysql.datasource")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("mySqlEntityManager")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(
            EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
        Map<String, Object> jpaPropertiesMap = new HashMap<>();
        jpaPropertiesMap.put("hibernate.dialect","org.hibernate.dialect.HSQLDialect");

        return entityManagerFactoryBuilder.dataSource(mysqlDataSource())
                .packages("org.example.domain.mysql")
                .persistenceUnit("student_details")
                .properties(jpaPropertiesMap)
                .build();
    }

    @Bean("mySqlTransactionManager")
    public PlatformTransactionManager mysqlTransactionManager(
            @Qualifier("mySqlEntityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
    }
}
