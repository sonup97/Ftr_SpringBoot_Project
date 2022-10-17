package com.tm1.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	public static final Log Logger=LogFactory.getLog(LoggingAspect.class);
	
	@AfterThrowing(pointcut = "execution(* com.tm1.service.*service.*(..))", throwing="exception")
	public void logServiceException(Exception exception) {
		Logger.error(exception.getMessage(),exception);
	}
}
