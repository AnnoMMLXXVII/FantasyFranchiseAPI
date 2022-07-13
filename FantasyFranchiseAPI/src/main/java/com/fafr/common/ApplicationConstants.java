package com.fafr.common;

/**
 * Class that will house a list of static constants
 * 
 * @author Haku Wei
 *
 */
public class ApplicationConstants {
	public static final String DB_DRIVER = "";
	public static final String DB_CLIENT = "";
	public static final String DB_SECRET = "";
	public static final String DB_JDBCURL = "";
	public static final String ALL_STRING_REGEX = "\"([^\"]*)\"";
	public static final String DIGITS_ONLY_REGEX = "\\d+";

	public static enum PLAYER_ATTRIBUTES {
		ID, FIRSTNAME, LASTNAME, BIRTHDATE, WEIGHT, COLLEGE, POSITION, HEIGHT;
	}

	public enum CONFERENCES {
		AFC, NFC;
	}

	public enum DIVISIONS {
		EAST, WEST, NORTH, SOUTH;

	}

	public static enum TEAMS {

		// AFC East
		NE("New England", "Patriots"), BUF("Buffalo", "Bills"), MIA("Miami", "Dolphins"), NYJ("New York", "Jets"),

		// AFC West
		KC("Kansas City", "Chiefs"), DEN("Denver", "Broncos"), LAC("Los Angeles", "Chargers"),
		LV("Las Vegas", "Raiders"),

		// AFC North
		CIN("Cincinnati", "Bengals"), BAL("Baltimore", "Ravens"), PIT("Pittsburgh", "Steelers"),
		CLE("Cleveland", "Browns"),

		// AFC South
		IND("Indianapolis", "Colts"), TEN("Tennesee", "Titans"), HOU("Houston", "Texans"),
		JAG("Jacksonville", "Jaguars"),

		// NFC East
		WAS("Washington", "Commanders"), DAL("Dallas", "Cowboys"), PHI("Philadelphia", "Eagles"),
		NYG("New York", "Giants"),

		// NFC West
		LAR("Los Angeles", "Rams"), SEA("Seattle", "Seahawks"), SF("San Francisco", "49ers"),
		ARI("Arizona", "Cardinals"),

		// NFC North
		MIN("Minnesota", "Vikings"), GB("Green Bay", "Packers"), CHI("Chicago", "Bears"), DET("Detroit", "Lions"),

		// NFC South
		CAR("Carolina", "Panthers"), NO("New Orleans", "Saints"), ATL("Atlanta", "Falcons"),
		TB("Tampa Bay", "Buccaneers")

		;

		private String location;
		private String nickname;

		TEAMS(String location, String nickname) {
			this.location = location;
			this.nickname = nickname;
		}

		public String getLocation() {
			return location;
		}

		public String getNickname() {
			return nickname;
		}

	}
}
