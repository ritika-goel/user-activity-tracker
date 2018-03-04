package com.tracker.activity.exception;

import java.util.Map;

public class CommonException extends Exception {	
	private static final long serialVersionUID = 1L;
	
	private final Map<String, String> errorHeaderMap;
	private final Map<String, Object> errorDetailMap;
	private final Integer httpStatusCode;

	/***************** constructors ***********************/
	public CommonException(Map<String, String> errorHeaderMap, Map<String, Object> errorDetailMap,
			Integer httpStatusCode, String errMsg) {
		super(errMsg);
		this.errorHeaderMap = errorHeaderMap;
		this.errorDetailMap = errorDetailMap;
		this.httpStatusCode = httpStatusCode;
	}	

	/***************** getters and setters ***********************/
	public Map<String, String> getErrorHeaderMap() {
		return errorHeaderMap;
	}

	public Map<String, Object> getErrorDetailMap() {
		return errorDetailMap;
	}

	public Integer getHttpStatusCode() {
		return httpStatusCode;
	}		
}
