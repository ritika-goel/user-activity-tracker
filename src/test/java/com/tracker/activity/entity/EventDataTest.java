package com.tracker.activity.entity;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tracker.activity.constants.JunitConstants;

public class EventDataTest {

	private EventData eventData = new EventData();

	@Before
	public void setUp() throws ParseException {
		eventData.setAppVersion(JunitConstants.APP_VERSION);
		eventData.setGender(JunitConstants.GENDER);
		eventData.setAppPlatform(JunitConstants.APP_PLATFORM);
		eventData.setEvSource(JunitConstants.EV_SOURCE);
		eventData.setIpAddress(JunitConstants.IP_ADDRESS);
		eventData.setEventType(JunitConstants.EVENT_TYPE);
		eventData.setUa(JunitConstants.UA);
		eventData.setDeviceId(JunitConstants.DEVICE_ID);
		eventData.setUserId(JunitConstants.USER_ID);
		eventData.setDeviceNetwork(JunitConstants.DEVICE_NETWORK);
		eventData.setOsVersion(JunitConstants.OS_VERSION);
		eventData.setScrResolution(JunitConstants.SRC_RESOLUTION);
		eventData.setSiteId(JunitConstants.SITE_ID);
		eventData.setEventName(JunitConstants.EVENT_NAME);
		eventData.setCid(JunitConstants.C_ID);
		SimpleDateFormat dtf = new SimpleDateFormat(JunitConstants.TS_PATTERN);
		Date parsedTs = dtf.parse(JunitConstants.TS);
		eventData.setTs(new Timestamp(parsedTs.getTime()));
	}

	@Test
	public void testSetters() {
		Assert.assertEquals(JunitConstants.APP_VERSION, eventData.getAppVersion());
		Assert.assertEquals(JunitConstants.GENDER, eventData.getGender());
		Assert.assertEquals(JunitConstants.APP_PLATFORM, eventData.getAppPlatform());
		Assert.assertEquals(JunitConstants.EV_SOURCE, eventData.getEvSource());
		Assert.assertEquals(JunitConstants.IP_ADDRESS, eventData.getIpAddress());
		Assert.assertEquals(JunitConstants.EVENT_TYPE, eventData.getEventType());
		Assert.assertEquals(JunitConstants.UA, eventData.getUa());
		Assert.assertEquals(JunitConstants.DEVICE_ID, eventData.getDeviceId());
		Assert.assertEquals(JunitConstants.USER_ID, eventData.getUserId());
		Assert.assertEquals(JunitConstants.DEVICE_NETWORK, eventData.getDeviceNetwork());
		Assert.assertEquals(JunitConstants.OS_VERSION, eventData.getOsVersion());
		Assert.assertEquals(JunitConstants.SRC_RESOLUTION, eventData.getScrResolution());
		Assert.assertEquals(JunitConstants.SITE_ID, eventData.getSiteId());
		Assert.assertEquals(JunitConstants.EVENT_NAME, eventData.getEventName());
		Assert.assertEquals(JunitConstants.C_ID, eventData.getCid());
		Assert.assertEquals(new Timestamp(JunitConstants.FAST_TIME), eventData.getTs());
	}
}
