package com.fantasy.franchise.features.stepDefinitions.test;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fantasy.franchise.features.stepLibraries.test.TestStepLibraries;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class TestStepDefinition {

	private static Logger logger = LogManager.getLogger();

	@Steps(shared = true)
	private TestStepLibraries testStepLibraries;

	@Given("^Test Data Access Object is not null$")
	public void validateTestDAOIsNotNull() {
		testStepLibraries.validateTestDataObjectIsNotNull();
	}

	@Given("^Test DAO get all call returns non empty list$")
	public void userCreatesConnectionToTheDatabase() {
		testStepLibraries.validateDataIsNotEmpty();
	}

	@Given("^Test DAO get by character \"([^\"]*)\" is (greater than|equal to|less than) (\\d+)$")
	public void testDataContainsTheCharacter(String c, String condition, int expected) throws SQLException {
		int size = testStepLibraries.testDataContainsTheCharacter(c);
		testStepLibraries.validateActualAndExpectedMeetExpectedCondition(size, condition, expected);
	}

}
