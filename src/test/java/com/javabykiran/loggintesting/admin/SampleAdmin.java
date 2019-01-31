package com.javabykiran.loggintesting.admin;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.java.Log4jClass;

public class SampleAdmin {

	static Logger logger = Logger.getLogger(SampleAdmin.class);
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("resource/log4j.properties");
		logger.debug("SampleAdmin debug message");
		logger.info("SampleAdmin info message");
		logger.warn("SampleAdmin warn message");
		logger.error("SampleAdmin error message");
		logger.fatal("SampleAdmin fatal message");
		SampleReport obj=new SampleReport();
		obj.generatereport();
		
	}
}
