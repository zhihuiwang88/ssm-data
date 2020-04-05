package com.json.web.entity;

import java.sql.Timestamp;

public class CarCity {
    /**
     * 
     */
	private Integer cityId;

    /**
     * 
     */
    private String cityName;

    /**
     * 
     */
    private String cityCode;

    /**
     * 
     */
    private String abbr;

    /**
     * 
     */
    private String engineNum;

    /**
     * 
     */
    private String enginenoNum;

    /**
     * 
     */
    private String classNum;

    /**
     * 
     */
    private String classnoNum;

    /**
     * 
     */
    private String registNum;

    /**
     * 
     */
    private Integer registnoNum;

    /**
     * 
     */
    private Timestamp createTime;

    /**
     * 
     */
    private Timestamp updateTime;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public String getEngineNum() {
		return engineNum;
	}

	public void setEngineNum(String engineNum) {
		this.engineNum = engineNum;
	}

	public String getEnginenoNum() {
		return enginenoNum;
	}

	public void setEnginenoNum(String enginenoNum) {
		this.enginenoNum = enginenoNum;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public String getClassnoNum() {
		return classnoNum;
	}

	public void setClassnoNum(String classnoNum) {
		this.classnoNum = classnoNum;
	}

	public String getRegistNum() {
		return registNum;
	}

	public void setRegistNum(String registNum) {
		this.registNum = registNum;
	}

	public Integer getRegistnoNum() {
		return registnoNum;
	}

	public void setRegistnoNum(Integer registnoNum) {
		this.registnoNum = registnoNum;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}