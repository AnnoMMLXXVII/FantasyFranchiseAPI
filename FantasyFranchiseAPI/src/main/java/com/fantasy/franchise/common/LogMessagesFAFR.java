package com.fantasy.franchise.common;

/**
 * Reuseable Log messsages
 * 
 * Format
 * 	Jira Key - FAFR
 * 	First Letter of Log Level
 * 		- INFO - I
 * 		- WARNING - W
 * 		- ERROR - E
 * 	3-digit Sequence
 * 		- 000...00N...0NN...NNN
 * @author Haku Wei
 *
 */
public class LogMessagesFAFR {
	// INFO LOG MESSAGES

	// WARNING LOG MESSAGES
	public static final String FAFR_W_000 = "Unable to parse to JSON - using toString()";
	public static final String FAFR_W_001 = "Data List is Empty";

	// ERROR LOG MESSAGES
	public static final String FAFR_E_000 = "Object is null";
	public static final String FAFR_E_001 = "Incoming parameter is not valid: Null, Illegal, or Empty";

}
