package com.fantasy.franchise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fantasy.franchise.dao.test.TestData;

@SpringBootApplication
@EnableAutoConfiguration
public class FantasyFranchiseApiApplication {

	public static void main(String[] args) {
		TestData.initializeTestData();
		SpringApplication.run(FantasyFranchiseApiApplication.class, args);
	}

}
