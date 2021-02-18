package com.banzo.catfood.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Pointcut("execution(* com.banzo.catfood.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.banzo.catfood.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.banzo.catfood.repository.*.*(..))")
	private void forRepositoryPackage() {}

	@Pointcut("forControllerPackage() || forServicePackage() || forRepositoryPackage()")
	private void forAppFlow() {}

	@Before("forAppFlow()")
	public void logBeforeMethodCall(JoinPoint theJoinPoint) {

		String method = theJoinPoint.getSignature().toShortString();
		logger.info("Before calling method: " + method);

		Object[] args = theJoinPoint.getArgs();
		
		for (Object arg : args) {
			logger.info("Method argument: " + arg);
		}
	}

	@AfterReturning(pointcut="forAppFlow()", returning="result")
	public void logAfterMethodExecuted(JoinPoint theJoinPoint, Object result) {

		String method = theJoinPoint.getSignature().toShortString();
		logger.info("Results from method: " + method);

		logger.info("Returned data: " + result);
	}
}
