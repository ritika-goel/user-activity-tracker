package com.tracker.activity.constants;

public class Constants {

	public static final String APP_VERSION = "appVersion";
	public static final String GENDER = "gender";
	public static final String APP_PLATFORM = "appPlatform";
	public static final String EV_SOURCE = "evSource";
	public static final String IP_ADDRESS = "ipAddress";
	public static final String EVENT_TYPE = "eventType";
	public static final String UA = "ua";
	public static final String DEVICE_ID = "deviceId";
	public static final String USER_ID = "userId";
	public static final String DEVICE_NETWORK = "deviceNetwork";
	public static final String OS_VERSION = "osVersion";
	public static final String SRC_RESOLUTION = "scrResolution";
	public static final String SITE_ID = "siteId";
	public static final String EVENT_NAME = "eventName";
	public static final String C_ID = "cid";
	public static final String TS = "ts";

	public static final String SUCCESS_RESP_CODE = "200";
	public static final String SUCCESS_RESP_MSG = "Success";

	public static final int ERROR_DIVIDE_BY_ZERO = 4022;
	public static final String ERROR_DIVIDE_BY_ZERO_MSG = "Mathematical Error occurred";
	public static final String ERROR_SRC_VISITOR_CNT = "Visiter Count";
	public static final String ERR_NO_VISITERS_TODAY = "No visiters today.";

	public static final String ERRORS = "errors";

	public static final String INVALID_PARAM_BASE_MSG = "Invalid input params received";
	public static final String INVALID_PARAM_SOURCE = "Source";
	public static final String INVALID_PARAM_MSG = "Message";
	public static final String INVALID_CATEGORY_RESP_CODE = "4001";
	public static final String INVALID_CATEGORY_SRC = "Category";
	public static final String INVALID_CATEGORY_RESP_MSG = "Invalid category value";
	public static final String INVALID_DATE_SRC = "Date";
	public static final String INVALID_DATE_RESP_MSG = "Invalid date value";

	public static final String TITLE = "title";
	public static final String DESCRIPTION = "description";
	public static final String VERSION = "version";
	public static final String API_RESP_CODE = "api_resp_code";
	public static final String RESP_MSG = "resp_msg";
	public static final String RESP_DATE_TIME = "resp_date_time";
	public static final String DATA = "data";

	public static final String TITLE_VAL = "Activity Tracker";
	public static final String DESCRIPTION_VAL = "Activity Tracker Utility";
	public static final String VERSION_VAL = "v1.0";

	public static final String EVENT_TYPE_PAYMENT = "Payment";
	public static final String EVENT_TYPE_BOOKING = "Booking";
	public static final String EVENT_TYPE_VISIT = "Visit";
	public static final String EVENT_TYPE_SEARCH = "Search";

	public static final String BASE_URL = "app/users/";
	public static final String PERCENT_BOOKINGS = "percentBookings";
	public static final String EVENT_CATEGORY = "eventCategory";
	public static final String VISITERS = "visiters";

	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final String START_TIME = " 00:00:00.0";
	public static final String END_TIME = " 11:59:59.0";
	
	public static final Long SEVEN_DAYS = 7L;	

	public static final String QUERY_DISTINCT_USERS_BY_CATEGORY_AND_DATE = "SELECT DISTINCT ed.userId FROM EventData ed "
			+ "WHERE LOWER(ed.eventType) = :category AND ed.ts = :ts";
	public static final String QUERY_DISTINCT_USERS_IN_A_DAY = "SELECT DISTINCT COUNT(ed.userId) FROM EventData ed "
			+ "WHERE LOWER(ed.eventType) = :category AND ed.ts BETWEEN TO_TIMESTAMP(:start, 'YYYY-MM-DD HH24:MI:SS') AND TO_TIMESTAMP(:end, 'YYYY-MM-DD HH24:MI:SS')";
	public static final String QUERY_DISTINCT_USERS_VISIT = "SELECT ed.userId FROM EventData ed " 
			+ "WHERE LOWER(ed.eventType) = :category AND ed.ts BETWEEN TO_TIMESTAMP(:start, 'YYYY-MM-DD HH24:MI:SS') AND TO_TIMESTAMP(:end, 'YYYY-MM-DD HH24:MI:SS') "
			+ "GROUP BY ed.userId HAVING COUNT(*)>= :frequency";

	private Constants() {
	}
}
