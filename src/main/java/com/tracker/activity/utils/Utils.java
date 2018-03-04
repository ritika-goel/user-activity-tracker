package com.tracker.activity.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tracker.activity.constants.Constants;
import com.tracker.activity.entity.Response;
import com.tracker.activity.exception.CommonException;

public class Utils {
	private static final Logger LOGGER = LogManager.getLogger(Utils.class);

	private Utils() {
	}

	public static boolean isCategoryValid(String category) {
		LOGGER.info("Inside isCategoryValid()");
		switch (category) {
		case Constants.EVENT_TYPE_PAYMENT:
		case Constants.EVENT_TYPE_VISIT:
		case Constants.EVENT_TYPE_SEARCH:
		case Constants.EVENT_TYPE_BOOKING:
			LOGGER.info("Exit isCategoryValid()");
			return true;
		default:
			LOGGER.info("Exit isCategoryValid()");
			return false;
		}
	}	
	
	public static Timestamp getTimestamp(Long val){
		LOGGER.info("Inside getTimestamp()");
		LOGGER.info("Exit getTimestamp()");
		return new Timestamp(val);
	}

	public static String getPastDateTime(Long days) {
		LOGGER.info("Inside getPastDateTime()");
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime pastDate = now.minusDays(days);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Constants.DATE_TIME_FORMAT);
		LOGGER.info("Exit getPastDateTime()");
		return dtf.format(pastDate);
	}
	
	public static String getStartDateTime(String date) {
		LOGGER.info("Inside getStartDateTime()");
		LOGGER.info("Exit getStartDateTime()");
		return date.concat(Constants.START_TIME);
	}

	public static String getEndDateTime(String date) {
		LOGGER.info("Inside getEndDateTime()");
		LOGGER.info("Exit getEndDateTime()");
		return date.concat(Constants.END_TIME);
	}

	public static String getTodaysDate(String format) {
		LOGGER.info("Inside getTodaysDate()");		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		LocalDateTime now = LocalDateTime.now();
		LOGGER.info("Exit getTodaysDate()");
		return dtf.format(now);
	}

	public static Response getResponseObject() {
		LOGGER.info("Inside getResponseObject()");
		Response response = new Response();
		buildResponseHeader(response, Constants.SUCCESS_RESP_CODE, Constants.SUCCESS_RESP_MSG);
		LOGGER.info("Exit getResponseObject()");
		return response;
	}

	public static void buildResponseHeader(Response response, String respCode, String respMsg) {
		LOGGER.info("Inside buildResponseHeader()");
		response.setTitle(Constants.TITLE_VAL);
		response.setDescription(Constants.DESCRIPTION_VAL);
		response.setVersion(Constants.VERSION_VAL);
		response.setRespDateTime(getTodaysDate(Constants.DATE_TIME_FORMAT));
		response.setApiResponseCode(respCode);
		response.setResponseMsg(respMsg);
		LOGGER.info("Exit buildResponseHeader()");
	}

	public static Map<String, String> buildErrorHeader(Integer respCode, String respMsg) {
		LOGGER.info("Inside buildErrorHeader()");
		Map<String, String> errorHeader = new LinkedHashMap<>();
		errorHeader.put(Constants.TITLE, Constants.TITLE_VAL);
		errorHeader.put(Constants.DESCRIPTION, Constants.DESCRIPTION_VAL);
		errorHeader.put(Constants.VERSION, Constants.VERSION_VAL);
		errorHeader.put(Constants.RESP_DATE_TIME, getTodaysDate(Constants.DATE_TIME_FORMAT));
		errorHeader.put(Constants.API_RESP_CODE, respCode.toString());
		errorHeader.put(Constants.RESP_MSG, respMsg);
		LOGGER.info("Exit buildErrorHeader()");
		return errorHeader;
	}

	public static Map<String, String> populateErrorMap(String src, String msg) {
		LOGGER.info("Inside populateErrorMap()");
		Map<String, String> errorMap = new LinkedHashMap<>();
		errorMap.put(Constants.INVALID_PARAM_SOURCE, src);
		errorMap.put(Constants.INVALID_PARAM_MSG, msg);
		LOGGER.info("Exit populateErrorMap()");
		return errorMap;
	}

	public static void throwCommonException(List<Map<String, String>> errorList, int respCode, String rspMsg)
			throws CommonException {
		LOGGER.info("Inside throwCommonException()");
		if (errorList != null && !errorList.isEmpty()) {
			Map<String, String> errorHeader = buildErrorHeader(respCode, rspMsg);
			Map<String, Object> errorDetails = new LinkedHashMap<>();
			errorDetails.put(Constants.ERRORS, errorList);			
			throw new CommonException(errorHeader, errorDetails, respCode, rspMsg);
		}
		LOGGER.info("Exit throwCommonException()");
	}
}
