package com.alexrgordon.projecthub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
public class ProjectHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectHubApplication.class, args);
		System.out.println(">>>>> Api Up...");
	}




}
