package com.fafr;

import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;

import com.fafr.common.ApplicationLogger;
import com.fafr.common.testData.TestData;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
// @formatter:off
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {
				"com.fafr.features.stepDefinitions",
//				"src/main/java/com/fafr/features/stepDefinitions",
				},
		 plugin = {
	                "ReXray:target/reporting.log",
	                "pretty", 
	                "html:target/cucumber-html-report",
	                "json:target/cucumber.json"
	              }
//		,
//		 tags = {
//				 "@smoke"
//		 		}
		)
//@formatter:on
public class CucumberTestSuite {

//	private DataAccessObject<Test> dao;
//	private FacadeInterface<ResponseMessage> facade;
//	private TestController controller;
	
	@BeforeClass
	public void setup() {
		ApplicationLogger.logINFO("Initializing Test Data for Test Object!");
		TestData.initializeTestData();
//		controller = new TestController();
//		facade = new TestFacade();
//		controller = new TestController();

//		Runtime.getRuntime().addShutdownHook(new Thread() {
//			public void run() {
//				try {
//
//				} catch (Exception ex) {
//
//				}
//			}
//		});
	}

}