package com.tracker.activity.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import com.tracker.activity.constants.JunitConstants;
import org.junit.Assert;

public class GlobalExceptionHandlerTest {

	private GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

	@Test
	public void testHandleException() {
		Map<String, String> errorHeader = new LinkedHashMap<>();
		errorHeader.put(JunitConstants.TITLE, JunitConstants.TITLE);
		Map<String, Object> errorDetails = new LinkedHashMap<>();
		errorDetails.put(JunitConstants.ERRORS, JunitConstants.ERRORS);
		CommonException e = new CommonException(errorHeader, errorDetails, HttpStatus.BAD_REQUEST.value(),
				JunitConstants.BAD_REQUEST);
		Map<String, Object> actual = globalExceptionHandler.handleException(e);
		Assert.assertEquals(JunitConstants.TITLE, actual.get(JunitConstants.TITLE));
		Assert.assertEquals(JunitConstants.ERRORS, actual.get(JunitConstants.ERRORS));
	}
}
