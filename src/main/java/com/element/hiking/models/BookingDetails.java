/**
 * 
 */
package com.element.hiking.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author srake
 *
 */
public class BookingDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2763327891966132514L;
	
	private Integer bookingID;
	private List<HikerDetails> hikerDetails;
	private Trails trailsInfo;
	private Integer trailsId;
	private String bookingDate;
	
	
	/**
	 * @return the hikerDetails
	 */
	public List<HikerDetails> getHikerDetails() {
		if(hikerDetails == null)
			hikerDetails = new ArrayList<HikerDetails>();
		
		return hikerDetails;
	}
	/**
	 * @param hikerDetails the hikerDetails to set
	 */
	public void setHikerDetails(List<HikerDetails> hikerDetails) {
		this.hikerDetails = hikerDetails;
	}
	/**
	 * @return the bookingID
	 */
	public Integer getBookingID() {
		return bookingID;
	}
	/**
	 * @param bookingID the bookingID to set
	 */
	public void setBookingID(Integer bookingID) {
		this.bookingID = bookingID;
	}

	/**
	 * @return the trailsInfo
	 */
	public Trails getTrailsInfo() {
		return trailsInfo;
	}
	/**
	 * @param trailsInfo the trailsInfo to set
	 */
	public void setTrailsInfo(Trails trailsInfo) {
		this.trailsInfo = trailsInfo;
	}
	/**
	 * @return the trailsId
	 */
	public Integer getTrailsId() {
		return trailsId;
	}
	/**
	 * @param trailsId the trailsId to set
	 */
	public void setTrailsId(Integer trailsId) {
		this.trailsId = trailsId;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}	

}
