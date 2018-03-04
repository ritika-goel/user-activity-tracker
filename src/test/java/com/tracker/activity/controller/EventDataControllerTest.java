package com.tracker.activity.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tracker.activity.constants.JunitConstants;
import com.tracker.activity.entity.EventData;
import com.tracker.activity.entity.Response;
import com.tracker.activity.exception.CommonException;
import com.tracker.activity.service.EventDataService;

public class EventDataControllerTest {

	@InjectMocks
	private EventDataController eventDataController;

	@Mock
	private EventDataService eventDataService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSaveEventData() {
		Response response = new Response();
		response.setTitle(JunitConstants.TITLE);
		when(eventDataService.saveEventData(any(EventData.class))).thenReturn(response);
		Response actual = eventDataController.saveEventData(new EventData());
		Assert.assertEquals(JunitConstants.TITLE, actual.getTitle());
	}

	@Test
	public void testGetPercentageDistinctBookings() throws CommonException {
		Response response = new Response();
		response.setTitle(JunitConstants.TITLE);
		when(eventDataService.getPercentageDistinctBookings()).thenReturn(response);
		Response actual = eventDataController.getPercentageDistinctBookings();
		Assert.assertEquals(JunitConstants.TITLE, actual.getTitle());
	}

	@Test
	public void testGetDistinctEventCategories() {
		Response response = new Response();
		response.setTitle(JunitConstants.TITLE);
		when(eventDataService.getDistinctEventCategories()).thenReturn(response);
		Response actual = eventDataController.getDistinctEventCategories();
		Assert.assertEquals(JunitConstants.TITLE, actual.getTitle());
	}

	@Test
	public void testGetDistinctUsersByCategoryAndDate() throws ParseException, CommonException {
		Response response = new Response();
		response.setTitle(JunitConstants.TITLE);
		when(eventDataService.getDistinctUsersByCategoryAndDate(any(String.class), any(Timestamp.class)))
				.thenReturn(response);
		SimpleDateFormat dtf = new SimpleDateFormat(JunitConstants.TS_PATTERN);
		Date parsedTs = dtf.parse(JunitConstants.TS);
		Response actual = eventDataController.getDistinctUsersByCategoryAndDate(JunitConstants.SEARCH,
				parsedTs.getTime());
		Assert.assertEquals(JunitConstants.TITLE, actual.getTitle());
	}
	
	@Test(expected=CommonException.class)
	public void testGetDistinctUsersByCategoryAndDateInvalidCategory() throws ParseException, CommonException {
		Response response = new Response();
		response.setTitle(JunitConstants.TITLE);
		when(eventDataService.getDistinctUsersByCategoryAndDate(any(String.class), any(Timestamp.class)))
				.thenReturn(response);
		SimpleDateFormat dtf = new SimpleDateFormat(JunitConstants.TS_PATTERN);
		Date parsedTs = dtf.parse(JunitConstants.TS);
		eventDataController.getDistinctUsersByCategoryAndDate(JunitConstants.INVALID,
				parsedTs.getTime());		
	}
	
	@Test
	public void testGetUniqueVisiters(){
		Response response = new Response();
		response.setTitle(JunitConstants.TITLE);
		when(eventDataService.getUniqueVisiters(any(String.class), any(Long.class)))
				.thenReturn(response);		
		Response actual = eventDataController.getUniqueVisiters(JunitConstants.VISIT,
				"3");
		Assert.assertEquals(JunitConstants.TITLE, actual.getTitle());
	}
}
