package com.theatreManagement.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		System.getProperties().put( "server.port", 8081);
		SpringApplication.run(ProjectApplication.class, args);
	}

}
