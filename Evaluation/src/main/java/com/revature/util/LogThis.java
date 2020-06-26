//This is Log4J class.
package com.revature.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogThis {
	
	static Logger Logger = LogManager.getLogger();
	
	public static void LogIt(String level, String message) {
		switch (level) {
		case "debug":
			Logger.debug(message);
			break;
		case "warn":
			Logger.warn(message);
			break;
		case "error":
			Logger.error(message);
			break;
		case "fatal":
			Logger.fatal(message);
			break;
		case "info":
			Logger.info(message);
			break;
		case "trace":
			Logger.trace(message);
			break;

		default:
			break;
		}
	}

}

