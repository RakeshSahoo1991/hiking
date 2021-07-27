/**
 * 
 */
package com.element.hiking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.element.hiking.models.BookingDetails;
import com.element.hiking.service.BookingService;

/**
 * @author srake
 *
 */
@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService service;
	
	@PostMapping(value = "/bookTrail", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<BookingDetails> bookTrail(@RequestBody BookingDetails bookingRequest){
		
		return new ResponseEntity<BookingDetails>(service.bookTrail(bookingRequest),HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{bookingId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<BookingDetails> viewBooking(@PathVariable("bookingId") Integer bookingId) {
		
		return new ResponseEntity<BookingDetails>(service.getBookingById(bookingId),HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{bookingId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> deletBooking(@PathVariable("bookingId") Integer bookingId){
		return new ResponseEntity<String>("Successfully Cancelled the Booking",HttpStatus.OK);
		
	}

}
