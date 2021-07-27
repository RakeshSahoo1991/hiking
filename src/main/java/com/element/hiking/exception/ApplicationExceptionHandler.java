/**
 * 
 */
package com.element.hiking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.element.hiking.models.ErrorModel;


/**
 * This class is responsible for handling all exception to service
 * @author srake
 *
 */
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final String INVALID_AGE ="INVALID_AGE";
	
	private static final String BOOKING_GENERAL_ERROR ="BOOKING_GENERAL_ERROR";
	
	
	/**
	 * This method sets appropriate error to the response, when there is a invalid age group in the service
	 * @param ex
	 * @return ResponsEntity of type ErrorModel
	 */
	@ExceptionHandler(value = { AgeLimitException.class })
    public ResponseEntity<ErrorModel> handleInvalidAge(AgeLimitException ex) {
		ErrorModel errorModel = new ErrorModel(INVALID_AGE, ex.getErrorMsg());
        return new ResponseEntity<ErrorModel>(errorModel,HttpStatus.CONFLICT);

    }
	
	/**
	 * This method sets appropriate error to the response, when there is any exception from booking service
	 * @param ex
	 * @return ResponsEntity of type ErrorModel
	 */
	@ExceptionHandler(value = { BookingException.class })
    public ResponseEntity<ErrorModel> handleBookingError(BookingException ex) {
		ErrorModel errorModel = new ErrorModel(BOOKING_GENERAL_ERROR, ex.getErrorMsg());
        return new ResponseEntity<ErrorModel>(errorModel,HttpStatus.CONFLICT);

    }
	
}
