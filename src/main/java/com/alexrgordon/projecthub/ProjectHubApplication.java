package com.alexrgordon.projecthub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.alexrgordon.projecthub.dal.repository")
public class ProjectHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectHubApplication.class, args);
		System.out.println(">>>>> Api Up...");
	}

}
