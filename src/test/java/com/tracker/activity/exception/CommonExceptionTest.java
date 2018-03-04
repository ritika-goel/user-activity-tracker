package com.tracker.activity.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import com.tracker.activity.constants.JunitConstants;

public class CommonExceptionTest {

	private CommonException e;

	@Before
	public void setUp() {
		Map<String, String> errorHeaderMap = new LinkedHashMap<>();
		errorHeaderMap.put(JunitConstants.TITLE, JunitConstants.TITLE);
		Map<String, Object> errorDetailMap = new LinkedHashMap<>();
		errorDetailMap.put(JunitConstants.ERRORS, JunitConstants.ERRORS);
		Integer httpStatusCode = HttpStatus.BAD_REQUEST.value();
		e = new CommonException(errorHeaderMap, errorDetailMap, httpStatusCode, JunitConstants.BAD_REQUEST);
	}

	@Test
	public void testGetters() {
		Assert.assertEquals(JunitConstants.BAD_REQUEST, e.getMessage());
		Assert.assertEquals(new Integer("400"), e.getHttpStatusCode());
		Assert.assertEquals(new Integer("400"), e.getHttpStatusCode());
		Assert.assertEquals(JunitConstants.TITLE, e.getErrorHeaderMap().get(JunitConstants.TITLE));
		Assert.assertEquals(JunitConstants.ERRORS, e.getErrorDetailMap().get(JunitConstants.ERRORS));
	}
}
