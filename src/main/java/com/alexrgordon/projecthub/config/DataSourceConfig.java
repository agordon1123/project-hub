package com.alexrgordon.projecthub.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Configuration
public class DataSourceConfig {

    public DataSourceConfig() { }

    @Bean(name="appDataSource")
	@ConfigurationProperties("app.datasource")
	public DataSource dataSource() {
        return DataSourceBuilder.create().build();
	}

}
