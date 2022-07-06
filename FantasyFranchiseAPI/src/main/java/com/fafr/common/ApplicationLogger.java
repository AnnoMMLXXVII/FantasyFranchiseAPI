package com.fafr.common;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApplicationLogger {
	private static Logger logger = LogManager.getLogger();
	private static String message = "";
	private static Level level = null;
	
	public static String getLogMessage() {
		return message;
	}
	
	public static Level getLogLevel() {
		return level;
	}

	public static void logINFO(String string) {
		logger.atLevel(level = Level.INFO);
		logger.traceEntry();
		logger.info("INFO - {}", message = string);
	}

	public static void logWARN(String string) {
		logger.atLevel(level = Level.WARN);
		logger.traceEntry();
		logger.warn("WARN - {}", message = string);
	}

	public static void logERROR(String string) {
		logger.atLevel(level = Level.ERROR);
		logger.traceEntry();
		logger.error("ERROR - {}", message = string);
		message = string;
	}

	public static void logDEBUG(String string) {
		logger.atLevel(level = Level.DEBUG);
		logger.traceEntry();
		logger.debug("DEBUG - {}", message = string);
		message = string;
	}

	public static void logFATAL(String string) {
		logger.atLevel(level = Level.FATAL);
		logger.traceEntry();
		logger.fatal("FATAL - {}", message = string);
	}

}
