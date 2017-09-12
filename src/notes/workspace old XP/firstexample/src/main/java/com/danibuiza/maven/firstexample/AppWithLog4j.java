package com.danibuiza.maven.firstexample;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Hello world with Log4j!
 *
 */
public class AppWithLog4j 
{

	static final Logger logger = Logger.getLogger(AppWithLog4j.class);
	
    public static void main( String[] args )
    {
        //Configure logger
        BasicConfigurator.configure();
		//PropertyConfigurator.configure("log4j.properties");
        logger.debug("Hello World!");
		logger.info("Info");
		logger.warn("warning!");
		logger.error("error");
    }
}





