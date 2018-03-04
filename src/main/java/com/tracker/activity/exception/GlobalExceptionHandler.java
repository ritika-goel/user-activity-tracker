package com.tracker.activity.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger LOGGER = LogManager.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(CommonException.class)
	@ResponseBody
	public Map<String, Object> handleException(CommonException e) {
		LOGGER.info("Inside handleException()");
		Map<String, Object> errorResp = new LinkedHashMap<>();
		errorResp.putAll(e.getErrorHeaderMap());
		errorResp.putAll(e.getErrorDetailMap());
		LOGGER.info("Exit handleException()");
		return errorResp;
	}
}
