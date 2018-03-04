package com.tracker.activity.entity;

import org.junit.Before;
import org.junit.Test;

import com.tracker.activity.constants.JunitConstants;

import org.junit.Assert;

public class ResponseTest {

	private Response response = new Response();

	@Before
	public void setUp() {
		response.setTitle(JunitConstants.TITLE);
		response.setDescription(JunitConstants.DESCRIPTION);
		response.setVersion(JunitConstants.VERSION);
		response.setApiResponseCode(JunitConstants.API_RESP_CODE);
		response.setRespDateTime(JunitConstants.RESP_DATE_TIME);
		response.setResponseMsg(JunitConstants.RESP_MSG);
		response.setData(JunitConstants.DATA);
	}

	@Test
	public void testSetters() {
		Assert.assertEquals(JunitConstants.TITLE, response.getTitle());
		Assert.assertEquals(JunitConstants.DESCRIPTION, response.getDescription());
		Assert.assertEquals(JunitConstants.VERSION, response.getVersion());
		Assert.assertEquals(JunitConstants.API_RESP_CODE, response.getApiResponseCode());
		Assert.assertEquals(JunitConstants.RESP_DATE_TIME, response.getRespDateTime());
		Assert.assertEquals(JunitConstants.RESP_MSG, response.getResponseMsg());
		Assert.assertEquals(JunitConstants.DATA, response.getData());		
	}
}
