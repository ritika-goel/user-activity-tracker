package com.tracker.activity.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.activity.constants.Constants;
import com.tracker.activity.entity.EventData;
import com.tracker.activity.entity.Response;
import com.tracker.activity.exception.CommonException;
import com.tracker.activity.repository.EventDataRepository;
import com.tracker.activity.utils.Utils;

@Service
public class EventDataService {
	private static final Logger LOGGER = LogManager.getLogger(EventDataService.class);

	@Autowired
	private EventDataRepository eventDataRepository;

	public Response saveEventData(EventData data) {
		LOGGER.info("Inside saveEventData()");
		eventDataRepository.save(data);
		Response response = Utils.getResponseObject();
		response.setData(data);
		LOGGER.info("Exit saveEventData()");
		return response;
	}

	public Response getDistinctEventCategories() {
		LOGGER.info("Inside getDistinctEventCategories()");
		List<String> eventCategories = eventDataRepository.findAll().stream().map(EventData::getEventName).distinct()
				.collect(Collectors.toList());
		Response response = Utils.getResponseObject();
		response.setData(eventCategories);
		LOGGER.info("Exit getDistinctEventCategories()");
		return response;
	}

	public Response getDistinctUsersByCategoryAndDate(String category, Timestamp ts) {
		LOGGER.info("Inside getDistinctUsersByCategoryAndDate()");
		List<String> distinctUsers = eventDataRepository.findUniqueUserByEventTypeAndTs(category.toLowerCase(), ts);
		Response response = Utils.getResponseObject();
		response.setData(distinctUsers);
		LOGGER.info("Exit getDistinctUsersByCategoryAndDate()");
		return response;
	}

	public Response getPercentageDistinctBookings() throws CommonException {
		LOGGER.info("Inside getPercentageDistinctBookings()");
		String todaysDate = Utils.getTodaysDate(Constants.DATE_FORMAT);
		String startDate = Utils.getStartDateTime(todaysDate);
		String endDate = Utils.getEndDateTime(todaysDate);
		Long bookingCount = eventDataRepository.findUniqueUserInADay(Constants.EVENT_TYPE_BOOKING, startDate, endDate);
		Long visitCount = eventDataRepository.findUniqueUserInADay(Constants.EVENT_TYPE_VISIT, startDate, endDate);
		if (visitCount == 0L) {
			List<Map<String, String>> errorList = new ArrayList<>();
			errorList.add(Utils.populateErrorMap(Constants.ERROR_SRC_VISITOR_CNT, Constants.ERR_NO_VISITERS_TODAY));
			Utils.throwCommonException(errorList, Constants.ERROR_DIVIDE_BY_ZERO, Constants.ERROR_DIVIDE_BY_ZERO_MSG);
		}
		Response response = Utils.getResponseObject();
		response.setData((Double.parseDouble(bookingCount.toString())) / visitCount * 100);
		LOGGER.info("Exit getPercentageDistinctBookings()");
		return (response);
	}

	public Response getUniqueVisiters(String category, Long freq) {
		LOGGER.info("Inside getUniqueVisiters()");
		String startDate = Utils.getPastDateTime(Constants.SEVEN_DAYS);
		String endDate = Utils.getTodaysDate(Constants.DATE_TIME_FORMAT);

		List<String> distinctUsers = eventDataRepository.getUniqueVisiters(category.toLowerCase(), startDate, endDate,
				freq);
		Response response = Utils.getResponseObject();
		response.setData(distinctUsers);
		LOGGER.info("Exit getUniqueVisiters()");
		return response;
	}
}
