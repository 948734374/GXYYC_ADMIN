package com.mcfish.util;

/**
 * 日志类
 * 
 * @author ZhouXiaobing
 * @date 2018年3月24日 上午8:53:33
 * @version 1.0
 */
public class Logger {

	private org.apache.log4j.Logger logger;

	private Logger(org.apache.log4j.Logger log4jLogger) {
		logger = log4jLogger;
	}

	
	/**
	 * 获取构造器，根据类初始化Logger对象
	 * @author ZhouXiaobing
	 * @date 2018年3月24日 上午8:53:53
	 * @param Class  Class对象
	 * @return Logger对象
	 */
	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class classObject) {
		return new Logger(org.apache.log4j.Logger.getLogger(classObject));
	}

	/**
	 * 获取构造器，根据类名初始化Logger对象
	 * @author ZhouXiaobing 
	 * @date 2018年3月24日 上午8:54:59 
	 * @param String 类名字符串
	 * @return Logger对象
	 * @param loggerName
	 */
	public static Logger getLogger(String loggerName) {
		return new Logger(org.apache.log4j.Logger.getLogger(loggerName));
	}

	public void debug(Object object) {
		logger.debug(object);
	}

	public void debug(Object object, Throwable e) {
		logger.debug(object, e);
	}

	public void info(Object object) {
		logger.info(object);
	}

	public void info(Object object, Throwable e) {
		logger.info(object, e);
	}

	public void warn(Object object) {
		logger.warn(object);
	}

	public void warn(Object object, Throwable e) {
		logger.warn(object, e);
	}

	public void error(Object object) {
		logger.error(object);
	}

	public void error(Object object, Throwable e) {
		logger.error(object, e);
	}

	public void fatal(Object object) {
		logger.fatal(object);
	}

	public String getName() {
		return logger.getName();
	}

	public org.apache.log4j.Logger getLog4jLogger() {
		return logger;
	}

	public boolean equals(Logger newLogger) {
		return logger.equals(newLogger.getLog4jLogger());
	}
}