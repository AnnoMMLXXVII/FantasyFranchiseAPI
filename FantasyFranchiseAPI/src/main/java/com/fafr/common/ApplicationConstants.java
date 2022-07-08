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
}
