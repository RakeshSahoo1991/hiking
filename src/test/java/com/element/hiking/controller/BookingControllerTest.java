/**
 * 
 */
package com.element.hiking.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.element.hiking.models.BookingDetails;
import com.element.hiking.models.HikerDetails;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class is responsible for controller test without mocking the Service
 * response as most of the exceptions are thrown from service
 * @author srake
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class BookingControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	@Order(1)
	void shouldBookATrail() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/booking/bookTrail").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(creatBooking("1991-05-06")))).andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	void shouldReturn409BookTrail() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/booking/bookTrail").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(creatBooking("2017-05-06")))).andExpect(status().isConflict());
	}
	
	
	@Test
	@Order(3)
	void shouldReturnBookingDetailsviewBooking() throws Exception {

		mockMvc.perform(
				get("/booking/{bookingId}", 1))
				.andExpect(status().isOk());
	}
	
	@Test
	@Order(4)
	void shouldReturn409ViewBooking() throws Exception {

		mockMvc.perform(
				get("/booking/{bookingId}", 20))
				.andExpect(status().isConflict());

	}
	
	@Test
	@Order(5)
	void shouldReturnSuccessDeletBooking() throws Exception {

		mockMvc.perform(
				get("/booking/{bookingId}", 1))
				.andExpect(status().isOk());

	}

	private BookingDetails creatBooking(String dob) {
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setBookingDate("2021-08-23");
		bookingDetails.setTrailsId(2);
		
		HikerDetails hiker = new HikerDetails();
		hiker.setName("Rakesh Sahoo");
		hiker.setEmailId("rakesh@gmail.com");
		hiker.setPhoneNumber("+49037477755");
		hiker.setDateOfBirth(dob);
		
		bookingDetails.getHikerDetails().add(hiker);
		return bookingDetails;
	}

}
