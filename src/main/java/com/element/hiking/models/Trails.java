/**
 * 
 */
package com.element.hiking.models;

import java.io.Serializable;

/**
 * @author srake
 *
 */
public class Trails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5328928239990673598L;
	
	private Integer trailId;
	private String name;
	private String startTime;
	private String endTime;
	private Integer minAge;
	private Integer maxAge;
	private Double price;
	/**
	 * @return the trailId
	 */
	public Integer getTrailId() {
		return trailId;
	}
	/**
	 * @param trailId the trailId to set
	 */
	public void setTrailId(Integer trailId) {
		this.trailId = trailId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the minAge
	 */
	public Integer getMinAge() {
		return minAge;
	}
	/**
	 * @param minAge the minAge to set
	 */
	public void setMinAge(Integer minAge) {
		this.minAge = minAge;
	}
	/**
	 * @return the maxAge
	 */
	public Integer getMaxAge() {
		return maxAge;
	}
	/**
	 * @param maxAge the maxAge to set
	 */
	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	} 
	
	

}
