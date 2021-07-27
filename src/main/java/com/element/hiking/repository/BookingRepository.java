/**
 * 
 */
package com.element.hiking.repository;

import com.element.hiking.datamodels.BookingDAO;

/**
 * @author srake
 *
 */
public interface BookingRepository {
	
	
	BookingDAO bookTrail(BookingDAO bookingDetails)throws Exception;
	
	BookingDAO getBookingById(Integer bookingId)throws Exception;
	
	void cancelBooking(Integer bookingId)throws Exception;

}
