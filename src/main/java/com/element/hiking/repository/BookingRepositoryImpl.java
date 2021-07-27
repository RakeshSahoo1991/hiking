/**
 * 
 */
package com.element.hiking.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.element.hiking.datamodels.BookingDAO;
import com.element.hiking.exception.BookingException;

/**
 * This is repository call as of now I have used static map to stored the data in future will be replaced by data base
 * @author srake
 *
 */
@Repository
public class BookingRepositoryImpl implements BookingRepository {
	
	private static Map<Integer,BookingDAO> bookingRecord = new HashMap<Integer, BookingDAO>();
	
	private static Integer bookingId = 0;

	/**
	 * This method create a booking record based on the booking information
	 * @param bookingDAO
	 * @return BookingDAO with generated booking ID
	 */
	@Override
	public BookingDAO bookTrail(BookingDAO bookingDetails) throws Exception{
		bookingDetails.setBookingID(++bookingId);
		bookingRecord.put(bookingDetails.getBookingID(), bookingDetails);
		return bookingDetails;
	}

	/**
	 * This method returns a booking record for the requested bookingId 
	 * @param Integer bookingId
	 * @return booking record for the bokingId
	 */
	@Override
	public BookingDAO getBookingById(Integer bookingId)throws BookingException {
		BookingDAO bookingDAO = bookingRecord.get(bookingId);
		if(bookingDAO == null)
		{
			throw new BookingException("No booking is availbe with this bookingId");
		}
		return bookingDAO;
	}

	/**
	 * This method deletes a booking record based on the bookingId
	 * @param bookingId
	 */
	@Override
	public void cancelBooking(Integer bookingId) throws Exception{
		bookingRecord.remove(bookingId);
		
	}

}
