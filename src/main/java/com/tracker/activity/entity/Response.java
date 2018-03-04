package com.tracker.activity.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracker.activity.constants.Constants;

public class Response implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty(Constants.TITLE)
	private String title;

	@JsonProperty(Constants.DESCRIPTION)
	private String description;

	@JsonProperty(Constants.VERSION)
	private String version;

	@JsonProperty(Constants.API_RESP_CODE)
	private String apiResponseCode;

	@JsonProperty(Constants.RESP_MSG)
	private String responseMsg;

	@JsonProperty(Constants.RESP_DATE_TIME)
	private String respDateTime;

	@JsonProperty(Constants.DATA)
	private transient Object data;

	/****************** getters and setters *****************/
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getApiResponseCode() {
		return apiResponseCode;
	}

	public void setApiResponseCode(String apiResponseCode) {
		this.apiResponseCode = apiResponseCode;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public String getRespDateTime() {
		return respDateTime;
	}

	public void setRespDateTime(String respDateTime) {
		this.respDateTime = respDateTime;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
