package com.tracker.activity.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
import com.tracker.activity.repository.EventDataRepository;

public class EventDataServiceTest {

	@InjectMocks
	private EventDataService eventDataService;

	@Mock
	private EventDataRepository eventDataRepository;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSaveEventData() {
		EventData eventData = new EventData();
		when(eventDataRepository.save(any(EventData.class))).thenReturn(eventData);
		Response actual = eventDataService.saveEventData(eventData);
		Assert.assertEquals(eventData.hashCode(), actual.getData().hashCode());
	}

	@Test
	public void testGetDistinctEventCategories() {
		List<EventData> categories = new ArrayList<>();
		EventData data1 = new EventData();
		data1.setEventName(JunitConstants.SEARCH);
		categories.add(data1);
		EventData data2 = new EventData();
		data2.setEventName(JunitConstants.VISIT);
		categories.add(data2);
		EventData data3 = new EventData();
		data1.setEventName(JunitConstants.SEARCH);
		categories.add(data3);
		when(eventDataRepository.findAll()).thenReturn(categories);
		Response actual = eventDataService.getDistinctEventCategories();
		Assert.assertEquals(categories.size(), ((List<String>) actual.getData()).size());
	}

	@Test
	public void testGetDistinctUsersByCategoryAndDate() throws ParseException {
		List<String> users = Arrays.asList(JunitConstants.USERS);
		when(eventDataRepository.findUniqueUserByEventTypeAndTs(any(String.class), any(Timestamp.class)))
				.thenReturn(users);
		SimpleDateFormat dtf = new SimpleDateFormat(JunitConstants.TS_PATTERN);
		Date parsedTs = dtf.parse(JunitConstants.TS);
		Response actual = eventDataService.getDistinctUsersByCategoryAndDate(JunitConstants.SEARCH,
				new Timestamp(parsedTs.getTime()));
		Assert.assertEquals(users.size(), ((List<String>) actual.getData()).size());
	}

	@Test
	public void testGetPercentageDistinctBookings() throws ParseException, CommonException {
		when(eventDataRepository.findUniqueUserInADay(any(String.class), any(String.class), any(String.class)))
				.thenReturn(5L);
		Response actual = eventDataService.getPercentageDistinctBookings();
		Assert.assertEquals(Double.parseDouble("100"), (double) actual.getData(), 0);
	}

	@Test
	public void testGetUniqueVisiters() {
		List<String> users = Arrays.asList(JunitConstants.USERS);
		when(eventDataRepository.getUniqueVisiters(any(String.class), any(String.class), any(String.class),
				any(Long.class))).thenReturn(users);
		Response actual = eventDataService.getUniqueVisiters(JunitConstants.VISIT, 3L);
		Assert.assertEquals(users.size(), ((List<String>) actual.getData()).size());
	}
}
