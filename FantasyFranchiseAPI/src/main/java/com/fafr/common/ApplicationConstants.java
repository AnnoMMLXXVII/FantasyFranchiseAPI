package com.fafr.common;

/**
 * Class that will house a list of static constants
 * 
 * @author Haku Wei
 *
 */
public class ApplicationConstants {
	public static String DB_DRIVER = "";
	public static String DB_CLIENT = "";
	public static String DB_SECRET = "";
	public static String DB_JDBCURL = "";
	public static String ALL_STRING_REGEX = "\"([^\"]*)\"";

	public static enum PLAYER_ATTRIBUTES {
		ID, FIRSTNAME, LASTNAME, BIRTHDATE, WEIGHT, COLLEGE, POSITION, HEIGHT;
	}
}
