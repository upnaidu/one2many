package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.app.entity.AccoutDetails;

@SpringBootApplication(scanBasePackages = "com.app.*")
public class One2manyApplication {

	public static void main(String[] args) {
		SpringApplication.run(One2manyApplication.class, args);
		saveAccountByName();
		getAllAccounts();
	}

	private static void saveAccountByName() {

		final String uri = "http://localhost:8090/one2many/saveAccount/Marketing";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> result = restTemplate.postForEntity(uri, AccoutDetails.class, String.class);

		System.out.println(result);
	}

	private static void getAllAccounts() {

		final String urlGETList = "http://localhost:8090/one2many/findAll";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(urlGETList, Object[].class);
		Object[] objects = responseEntity.getBody();
		System.out.println("objects "+objects);
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();

	}
}
