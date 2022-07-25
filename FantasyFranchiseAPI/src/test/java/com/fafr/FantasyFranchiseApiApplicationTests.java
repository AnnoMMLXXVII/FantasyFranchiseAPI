package com.fafr;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.fafr.testData.TestData;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
// @formatter:off
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = {
				"com.fafr.features.stepDefinitions",
//				"src/main/java/com/fafr/features/stepDefinitions",
				},
		 plugin = {
	                "ReXray:target/reporting.log"
	              }
		)
//@formatter:on
public class FantasyFranchiseApiApplicationTests {

//	private DataAccessObject<Test> dao;
//	private FacadeInterface<ResponseMessage> facade;
//	private TestController controller;

	@BeforeClass
	public void setup() {
		TestData.initializeTestData();
//		controller = new TestController();
//		facade = new TestFacade();
//		controller = new TestController();

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {

				} catch (Exception ex) {

				}
			}
		});
	}

}