package com.tracker.activity.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracker.activity.constants.Constants;

@Entity
public class EventData {
	@Id
	@GeneratedValue
	private Long eventDataId;

	@JsonProperty(Constants.APP_VERSION)
	private String appVersion;

	@JsonProperty(Constants.GENDER)
	private String gender;

	@JsonProperty(Constants.APP_PLATFORM)
	private String appPlatform;

	@JsonProperty(Constants.EV_SOURCE)
	private String evSource;

	@JsonProperty(Constants.IP_ADDRESS)
	private String ipAddress;

	@JsonProperty(Constants.EVENT_TYPE)
	private String eventType;

	@JsonProperty(Constants.UA)
	private String ua;

	@JsonProperty(Constants.DEVICE_ID)
	private String deviceId;

	@JsonProperty(Constants.USER_ID)
	private String userId;

	@JsonProperty(Constants.DEVICE_NETWORK)
	private String deviceNetwork;

	@JsonProperty(Constants.OS_VERSION)
	private String osVersion;

	@JsonProperty(Constants.SRC_RESOLUTION)
	private String scrResolution;

	@JsonProperty(Constants.SITE_ID)
	private String siteId;

	@JsonProperty(Constants.EVENT_NAME)
	private String eventName;

	@JsonProperty(Constants.C_ID)
	private String cid;

	@JsonProperty(Constants.TS)
	private Timestamp ts;

	/**************** Getters & Setters ****************/
	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAppPlatform() {
		return appPlatform;
	}

	public void setAppPlatform(String appPlatform) {
		this.appPlatform = appPlatform;
	}

	public String getEvSource() {
		return evSource;
	}

	public void setEvSource(String evSource) {
		this.evSource = evSource;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getUa() {
		return ua;
	}

	public void setUa(String ua) {
		this.ua = ua;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeviceNetwork() {
		return deviceNetwork;
	}

	public void setDeviceNetwork(String deviceNetwork) {
		this.deviceNetwork = deviceNetwork;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getScrResolution() {
		return scrResolution;
	}

	public void setScrResolution(String scrResolution) {
		this.scrResolution = scrResolution;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
}
