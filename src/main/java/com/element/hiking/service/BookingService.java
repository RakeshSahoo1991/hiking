/**
 * 
 */
package com.element.hiking.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.element.hiking.datamodels.TrailsDAO;
import com.element.hiking.exception.AgeLimitException;
import com.element.hiking.exception.BookingException;
import com.element.hiking.mapper.DataMapper;
import com.element.hiking.models.BookingDetails;
import com.element.hiking.models.HikerDetails;
import com.element.hiking.repository.BookingRepository;
import com.element.hiking.repository.TrailRepository;

/**
 * @author srake
 *
 */
@Service
public class BookingService {
	
	@Autowired
	BookingRepository repository;
	
	@Autowired
	TrailRepository trailRepo;
	
	@Autowired
	DataMapper mapper;

	/**
	 * This method is responsible for saving the booking details
	 * @param bookingDetails
	 * @return saved booking details with id
	 */
	public BookingDetails bookTrail(BookingDetails bookingDetails) throws BookingException,AgeLimitException{
		BookingDetails bookingInfo = null;
		try {
			ageValidation(bookingDetails);
			bookingInfo = mapper.mapToBookingResponse(repository.bookTrail(mapper.mapToBookingDAO(bookingDetails)));
			bookingInfo.setTrailsInfo(mapper.getResponseTrail(trailRepo.getTrailById(bookingInfo.getTrailsId())));
		} catch (AgeLimitException e) {
			throw e;
		}catch (Exception e) {
			throw new BookingException("Error booking the Trail, please try again later");
		}
		return bookingInfo;
	}
	
	/**
	 * This method is responsible to view the booking based on the bookingId
	 * @param bookingId
	 * @return bookingdetails 
	 */
	public BookingDetails getBookingById(Integer bookingId) throws BookingException{
		BookingDetails bookingInfo = null;
		try {
			bookingInfo = mapper.mapToBookingResponse(repository.getBookingById(bookingId));
			bookingInfo.setTrailsInfo(mapper.getResponseTrail(trailRepo.getTrailById(bookingInfo.getTrailsId())));
			return bookingInfo;
		} catch (BookingException e) {
			throw e;
		}catch (Exception e) {
			throw new BookingException("Error viewing the booking details, please try again later");
		}	
		
	}
	/**
	 * This method is responsible for canceling the booking
	 * @param bookingId
	 * @throws BookingException
	 */
	public void cancelBooking(Integer bookingId) throws BookingException{
		try {
			repository.cancelBooking(bookingId);
		} catch (Exception e) {
			throw new BookingException("Error canceling the booking,please try again later");
		}
	}

	/**
	 * This Method does the age group validation required for the hiking
	 * @param bookingDetails
	 */
	private void ageValidation(BookingDetails bookingDetails) throws AgeLimitException{

		TrailsDAO trailsInfo = trailRepo.getTrailById(bookingDetails.getTrailsId());
		
		for (HikerDetails hiker : bookingDetails.getHikerDetails()) {
			// date formate(yyyy-mm-dd)
			long diffInYears = ChronoUnit.YEARS.between(LocalDate.parse(hiker.getDateOfBirth()), LocalDate.now());
			if (diffInYears < trailsInfo.getMinAge()
					|| diffInYears > trailsInfo.getMaxAge()) {
				throw new AgeLimitException(
						"this trail is available for age group between " + trailsInfo.getMinAge()
								+ " - " + trailsInfo.getMaxAge());
			}
		}

	}

}
