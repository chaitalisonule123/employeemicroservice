package com.restapi.employeemicroservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
class EmployeeMicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Greeting message . . .")
	public void getGreetingsTest() throws URISyntaxException {
		System.out.println("Test started for : getGreetingsTest()");
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/getMsg/Akhilesh";
		URI uri = new URI(url);
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		Assertions.assertEquals(200, response.getStatusCodeValue());
		System.out.println(response.toString());
		System.out.println("Test getGreetingsTest() ended.");
	}

	@Test
	@DisplayName("List of all employees . . .")
	public void findEmployeeById() throws URISyntaxException {
		System.out.println("Test started for : getEmployeeById()");
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/findemployeebyid/5";
		URI uri = new URI(url);
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		Assertions.assertEquals(200, response.getStatusCodeValue());
		System.out.println(response.toString());
		System.out.println("Test getEmployeeById() ended.");
	}

	@Test
	@DisplayName("Data of highest salaried employee . . .")
	public void highestSalaryEmployee() throws URISyntaxException {
		System.out.println("Test started for : highestSalaryEmployee()");
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/highestsalaryemployee";
		URI uri = new URI(url);
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		Assertions.assertEquals(200, response.getStatusCodeValue());
		System.out.println(response.toString());
		System.out.println("Test highestSalaryEmployee() ended.");
	}

	@Test
	@DisplayName("Employee deleted . . .")
	public void deleteEmployee() throws URISyntaxException {
		System.out.println("Test started for : deleteEmployee()");
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/deleteemployee/5";
		URI uri = new URI(url);
		ResponseEntity<Employee> response = restTemplate.postForEntity(uri, restTemplate, Employee.class);
		Assertions.assertEquals(200, response.getStatusCodeValue());
		System.out.println(response.toString());
		System.out.println("Test deleteEmployee() ended . . .");
	}
}