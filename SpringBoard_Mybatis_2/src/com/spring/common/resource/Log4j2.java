package com.spring.common.resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class Log4j2 {

	Logger logger;
	
	public Log4j2() {
		// TODO Auto-generated constructor stub
		logger = LogManager.getLogger(Log4j2.class);
	}
	
	public Object printMsg(ProceedingJoinPoint joinPoint) {
		
		Object obj=null;
		Object target=joinPoint.getTarget();
		String className = target.getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		
		try {
			logger.debug(className+"의 메소드>>#"+methodName+"수행 전");
			obj= joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			logger.debug(className+"의 메소드>>#"+methodName+"수행 후");
		}
		
		
		return obj;
		
	}
}
