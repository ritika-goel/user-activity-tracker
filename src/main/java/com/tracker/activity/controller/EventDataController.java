package com.tracker.activity.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.activity.constants.Constants;
import com.tracker.activity.entity.EventData;
import com.tracker.activity.entity.Response;
import com.tracker.activity.exception.CommonException;
import com.tracker.activity.service.EventDataService;
import com.tracker.activity.utils.Utils;

@RestController
@RequestMapping(value = Constants.BASE_URL)
public class EventDataController {

	private static final Logger LOGGER = LogManager.getLogger(EventDataController.class);

	@Autowired
	private EventDataService eventDataService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response saveEventData(@RequestBody EventData data) {
		LOGGER.info("Inside saveEventData()");
		return eventDataService.saveEventData(data);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Response getDistinctUsersByCategoryAndDate(
			@RequestParam(required = false, defaultValue = Constants.EVENT_TYPE_PAYMENT) String category,
			@RequestParam(required = true) Long date) throws CommonException {
		LOGGER.info("Inside getDistinctUsersByCategoryAndDate()");
		List<Map<String, String>> errorList = new ArrayList<>();
		if (!Utils.isCategoryValid(category)) {
			errorList.add(Utils.populateErrorMap(Constants.INVALID_CATEGORY_SRC, Constants.INVALID_CATEGORY_RESP_MSG));
		}
		Utils.throwCommonException(errorList, HttpStatus.BAD_REQUEST.value(), Constants.INVALID_PARAM_BASE_MSG);
		Timestamp ts = Utils.getTimestamp(date);
		return eventDataService.getDistinctUsersByCategoryAndDate(category, ts);
	}

	@RequestMapping(value = Constants.PERCENT_BOOKINGS, method = RequestMethod.GET)
	public Response getPercentageDistinctBookings() throws CommonException {
		LOGGER.info("Inside getPercentageDistinctBookings()");
		return eventDataService.getPercentageDistinctBookings();
	}

	@RequestMapping(value = Constants.EVENT_CATEGORY, method = RequestMethod.GET)
	public Response getDistinctEventCategories() {
		LOGGER.info("Inside getPercentageDistinctBookings()");
		return eventDataService.getDistinctEventCategories();
	}

	@RequestMapping(value = Constants.VISITERS, method = RequestMethod.GET)
	public Response getUniqueVisiters(@RequestParam(required = true) String category,
			@RequestParam(required = true) String freq) {
		LOGGER.info("Inside getUniqueVisiters()");
		return eventDataService.getUniqueVisiters(category, Long.parseLong(freq));
	}
}
