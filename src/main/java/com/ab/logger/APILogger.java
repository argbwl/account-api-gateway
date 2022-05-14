package com.ab.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class APILogger {
	
	private Logger logger;
	
	protected APILogger(Logger logger) {
		this.logger=logger;
	}
	
	public static APILogger getLogger(Class<?> classs) {
		APILogger apiLogger = new APILogger(LoggerFactory.getLogger(classs));
		return apiLogger;
	}
	
	public void info(String message, Object...values) {
		logger.info(message,values);
	}
	
	public void info(String message) {
		logger.info(message);
	}
	
	public void error(String message, Object...values) {
		logger.error(message,values);
	}
	
	public void error(String message) {
		logger.error(message);
	}
	
	public void warn(String message, Object...values) {
		logger.warn(message,values);
	}
	
	public void warn(String message) {
		logger.warn(message);
	}

}
