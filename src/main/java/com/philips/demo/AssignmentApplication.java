package com.philips.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.philips.demo.AssignmentApplication;
@SpringBootApplication
@ComponentScan(basePackages  = {"com.philips.*"})
@EntityScan(basePackages  = {"com.philips.*"})
@EnableJpaRepositories(basePackages = "com.philips.*")
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AssignmentApplication.class);
		
		System.out.println("started appp----------");
		Environment env = app.run(args).getEnvironment();
		System.out.println("application ** "+env.getProperty("spring.datasource.url"));
		env.getProperty("url");
		System.out.println("ended app-----------");
	}
	}



