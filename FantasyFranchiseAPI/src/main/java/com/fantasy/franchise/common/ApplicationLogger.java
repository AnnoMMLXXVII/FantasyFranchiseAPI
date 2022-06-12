package com.fantasy.franchise.common;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApplicationLogger {
	private static Logger logger = LogManager.getLogger();

	public static void logINFO(String string) {
		logger.atLevel(Level.INFO);
		logger.traceEntry();
		logger.info("INFO - {}", string);
	}

	public static void logWARN(String string) {
		logger.atLevel(Level.WARN);
		logger.traceEntry();
		logger.warn("WARN - {}", string);
	}

	public static void logERROR(String string) {
		logger.atLevel(Level.ERROR);
		logger.traceEntry();
		logger.error("ERROR - {}", string);
	}

	public static void logDEBUG(String string) {
		logger.atLevel(Level.DEBUG);
		logger.traceEntry();
		logger.debug("DEBUG - {}", string);
	}

	public static void logFATAL(String string) {
		logger.atLevel(Level.FATAL);
		logger.traceEntry();
		logger.fatal("FATAL - {}", string);
	}

}
