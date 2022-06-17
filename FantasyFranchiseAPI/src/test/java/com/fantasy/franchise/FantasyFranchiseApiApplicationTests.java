package com.fantasy.franchise;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.fantasy.franchise.controller.test.TestController;
import com.fantasy.franchise.dao.DataAccessObject;
import com.fantasy.franchise.dao.test.TestData;
import com.fantasy.franchise.facade.FacadeInterface;
import com.fantasy.franchise.facade.test.TestFacade;
import com.fantasy.franchise.model.test.Test;
import com.fantasy.franchise.responseMessage.ResponseMessage;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
// @formatter:off
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = {
				"com.fantasy.franchise.features.stepDefinitions",
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