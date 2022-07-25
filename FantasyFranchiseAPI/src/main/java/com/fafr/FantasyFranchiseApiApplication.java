package com.fafr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fafr.testData.PlayerTestData;
import com.fafr.testData.TestData;

@SpringBootApplication
@EnableAutoConfiguration
public class FantasyFranchiseApiApplication {

	public static void main(String[] args) {
		
		//TestData.initializeTestData();
		PlayerTestData.readPlayerCSV();
		SpringApplication.run(FantasyFranchiseApiApplication.class, args);
	}

}
