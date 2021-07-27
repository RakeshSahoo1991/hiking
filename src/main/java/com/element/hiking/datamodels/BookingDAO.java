/**
 * 
 */
package com.element.hiking.datamodels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @author srake
 *
 */
public class BookingDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 672998289864255642L;
	
	private Integer bookingID;
	private List<HikerDAO> hikerDetails;
	private String bookingDate;
	private Integer trailsId;
	
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
	 * @return the hikerDetails
	 */
	public List<HikerDAO> getHikerDetails() {
		if(hikerDetails == null)
			hikerDetails = new ArrayList<HikerDAO>();
		
		return hikerDetails;
	}
	/**
	 * @param hikerDetails the hikerDetails to set
	 */
	public void setHikerDetails(List<HikerDAO> hikerDetails) {
		this.hikerDetails = hikerDetails;
	}
	/**
	 * @return the bookingDate
	 */
	public String getBookingDate() {
		return bookingDate;
	}
	/**
	 * @param bookingDate the bookingDate to set
	 */
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
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
	
	
	
	

}
