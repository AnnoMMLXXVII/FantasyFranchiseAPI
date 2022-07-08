package com.fantasy.franchise.player;

import model.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

	@BeforeEach
	void setUp() {
	}

	Player test = new Player("John", "LastName", new Date(2022, 01, 01), 250, "LegoLand", 07, "QB", 75);

	@Test
	void checkFirstNameNotNull() {
		assertThat(test.getFirstName()).as("First Name is null").isNotNull();
	}

	@Test
	void checkLastNameNotNull() {
		assertThat(test.getLastName()).as("Last Name is null").isNotNull();
	}

	@Test
	void checkNotTooYoung() {
		int age = 2022 - test.getBirthDate().getYear();
		assertThat(age).as("Too young").isGreaterThanOrEqualTo(19);
	}

	@Test
	void canBeLB() {
		boolean bigEnough = test.getWeight() >= 200 && test.getHeight() >= 70;
		assertThat(bigEnough).as("Not big enough").isTrue();
	}

	@Test
	void checkIfWentToCollege() {
		assertThat(test.getCollege()).as("Dropped out").isNotNull();
	}

	@Test
	void checkIfIDNotNull() {
		assertThat(test.getId()).as("ID is null").isNotNull();
	}

	@Test
	void checkIfTooShort() {
		boolean tallEnough = test.getHeight() >= 65;
		assertThat(tallEnough).as("Too short").isTrue();
	}

	@Test
	void checkIfTooLight() {
		boolean weighsEnough = test.getWeight() >= 140;
		assertThat(weighsEnough).as("Too light").isTrue();
	}

	@Test
	void checkIfTooFat() {
		boolean notFat = test.getWeight() >= 375;
		assertThat(notFat).as("Too fat").isTrue();
	}

	@Test
	void checkFirstAndLastNameNotEqual() {
		assertThat(test.getLastName() == test.getFirstName()).as("Names are the same").isFalse();
	}

	@Test
	void checkNotTooOld() {
		int age = 2022 - test.getBirthDate().getYear();
		assertThat(age).as("Too old").isLessThanOrEqualTo(50);
	}

}