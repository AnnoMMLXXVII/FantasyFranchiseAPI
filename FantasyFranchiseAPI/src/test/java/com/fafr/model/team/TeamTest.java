package com.fafr.model.team;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TeamTest {

	private Team expected;
	private Team actual;

	@BeforeEach
	void setUp() throws Exception {
		expected = new Team();
		actual = new Team("Patriots", "New England", "East", "AFC", "NE", 52);
	}

	@Test
	void testTwoTeamObjectsAreNotTheSame() {
		assertThat(expected).as("Expected Team matches Actual but should not").isNotEqualTo(actual);
	}

	@Test
	void testTeamNameMatchesActual() {
		expected.setName("Patriots");
		assertThat(expected.getName()).as("Expected Team Name does not match Actual").isEqualTo(actual.getName());
	}

	@Test
	void testTeamLocationMatchesActual() {
		expected.setCity("New England");
		assertThat(expected.getCity()).as("Expected Team City does not match Actual").isEqualTo(actual.getCity());
	}

	@Test
	void testTeamDivisionMatchesActual() {
		expected.setDivision("East");
		assertThat(expected.getDivision()).as("Expected Team Division does not match Actual")
				.isEqualTo(actual.getDivision());
	}

	@Test
	void testTeamConferenceMatchesActual() {
		expected.setConference("AFC");
		assertThat(expected.getConference()).as("Expected Team Conference does not match Actual")
				.isEqualTo(actual.getConference());
	}

	@Test
	void testTeamAbbreviationMatchesActual() {
		expected.setAbbreviation("NE");
		assertThat(expected.getAbbreviation()).as("Expected Team Abbreviation does not match Actual")
				.isEqualTo(actual.getAbbreviation());
	}

	@Test
	void testTeamRosterCountMatchesActual() {
		expected.setNumPlayers(52);
		assertThat(expected.getNumPlayers()).as("Expected Team Roster Count does not match Actual")
				.isEqualTo(actual.getNumPlayers());
	}

}
