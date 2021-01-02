package com.alexrgordon.projecthub.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Configuration
@Component
public class DataSourceConfig {

    // @Value("${app.datasource.driver-class-name}")
    final String driverClassName = "com.mysql.cj.jdbc.Driver";
    // @Value("${app.datasource.url}")
    final String url = "jdbc:mysql://localhost:3306/project_hub_db?zeroDateTimeBehavior=convertToNull&autoReconnect=true&failOverReadOnly=false&maxReconnects=10&serverTimezone=UTC";
    // @Value("${app.datasource.username}")
    final String username = "root";
    // @Value("${app.datasource.password}")
    final String password = "Americano";

    public DataSourceConfig() { }

    @Bean(name="appDataSource")
	// @ConfigurationProperties("app.datasource")
	public DataSource dataSource() {
        // return DataSourceBuilder.create().build();
        
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClassName);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
	}

}
