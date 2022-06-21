package com.fafr.features.stepLibraries.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.fafr.dao.DataAccessObject;
import com.fafr.dao.test.TestDAO;
import com.fafr.facade.FacadeInterface;
import com.fafr.facade.test.TestFacade;
import com.fafr.responseMessage.ResponseMessage;
import com.fantasy.franchise.model.test.Test;

import net.thucydides.core.annotations.Step;

public class TestStepLibraries {

	private DataAccessObject<Test> dao = TestDAO.getInstance();
	private FacadeInterface<ResponseMessage> facade = TestFacade.getInstance();

	@Step()
	public void validateDataIsNotEmpty() {
		List<Test> data = dao.getAll();
		assertThat(data.size()).as("Test Data is empty!").isGreaterThan(0);

	}

	@Step()
	public int testDataContainsTheCharacter(String c) {
		List<Test> results = ((TestDAO) dao).getByChar(c);
		return results.size();
	}

	@Step
	public void validateTestDataObjectIsNotNull() {
		assertThat(dao).as("Test DAO object is null!").isNotNull();
	}

	public void validateActualAndExpectedMeetExpectedCondition(String actual, String condition, String expected) {
		if ("greater than".equalsIgnoreCase(condition)) {
			assertThat(actual).as("Actual does not meet expected!").isGreaterThan(expected);
		} else if ("equal to".equalsIgnoreCase(condition)) {
			assertThat(actual).as("Actual does not meet expected!").isEqualTo(expected);
		} else {
			assertThat(actual).as("Actual does not meet expected!").isLessThan(expected);
		}
	}

	public void validateActualAndExpectedMeetExpectedCondition(Integer actual, String condition, Integer expected) {
		if ("greater than".equalsIgnoreCase(condition)) {
			assertThat(actual).as("Actual does not meet expected!").isGreaterThan(expected);
		} else if ("equal to".equalsIgnoreCase(condition)) {
			assertThat(actual).as("Actual does not meet expected!").isEqualTo(expected);
		} else {
			assertThat(actual).as("Actual does not meet expected!").isLessThan(expected);
		}
	}

}
