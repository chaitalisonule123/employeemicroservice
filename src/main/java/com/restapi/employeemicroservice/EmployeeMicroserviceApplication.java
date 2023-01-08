package com.restapi.employeemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication()
@EnableScheduling
public class EmployeeMicroserviceApplication {
	public static void main(String[] args) {

		SpringApplication.run(EmployeeMicroserviceApplication.class, args);
	}
}
