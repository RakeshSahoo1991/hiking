/**
 * 
 */
package com.element.hiking.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.element.hiking.datamodels.BookingDAO;
import com.element.hiking.datamodels.HikerDAO;
import com.element.hiking.datamodels.TrailsDAO;
import com.element.hiking.models.BookingDetails;
import com.element.hiking.models.HikerDetails;
import com.element.hiking.models.Trails;

/**This class is used to map the model object to data model object and vice versa
 * @author srake
 *
 */
@Component
public class DataMapper {
	
	/**
	 * This method maps list of trail data object to list trail model object
	 * @param trailsDAOs
	 * @return list of trails
	 */
	public List<Trails> getResponseTrails(List<TrailsDAO> trailsDAOs){
		List<Trails> responseTrails = new ArrayList<Trails>();
		
		trailsDAOs.forEach(trailDAO -> responseTrails.add(getResponseTrail(trailDAO)));
		
		return responseTrails;
		
	}

	/**
	 * This method maps trail data object to trail model object
	 * @param trailDAO
	 * @return trail model object 
	 */
	public Trails getResponseTrail(TrailsDAO trailDAO) {
		Trails trail = new Trails();
		trail.setTrailId(trailDAO.getId());
		trail.setName(trailDAO.getName());
		trail.setMaxAge(trailDAO.getMaxAge());
		trail.setMinAge(trailDAO.getMinAge());
		trail.setStartTime(trailDAO.getStartTime());
		trail.setEndTime(trailDAO.getEndTime());
		trail.setPrice(trailDAO.getPrice());
		return trail;
	}
	
	/**
	 * This method maps trail model object to trail data object
	 * @param Trails model object
	 * @return trail data object 
	 */
	public TrailsDAO getTrailDAO(Trails trail) {
		TrailsDAO trailDAO = new TrailsDAO();
		trailDAO.setName(trail.getName());
		trailDAO.setMaxAge(trail.getMaxAge());
		trailDAO.setMinAge(trail.getMinAge());
		trailDAO.setStartTime(trail.getStartTime());
		trailDAO.setEndTime(trail.getEndTime());
		trailDAO.setPrice(trail.getPrice());
		return trailDAO;
	}
	/**
	 * This method maps booking request model to booking data model
	 * @param bookingRequest
	 * @return booking data model
	 */
	public BookingDAO mapToBookingDAO(BookingDetails bookingRequest) {
		
		BookingDAO bookingDAO = new BookingDAO();
		bookingDAO.setBookingDate(bookingRequest.getBookingDate());
		bookingDAO.setTrailsId(bookingRequest.getTrailsId());
		bookingDAO.setHikerDetails(mapToHikerDAOList(bookingRequest.getHikerDetails()));
		return bookingDAO;
	}
	
	/**
	 * This method maps list of hiker request model to list of hiker data model
	 * @param hikerList
	 * @return list of hiker data model
	 */
	public List<HikerDAO> mapToHikerDAOList(List<HikerDetails> hikerList){
		List<HikerDAO> hikerDAOs = new ArrayList<HikerDAO>();
		hikerList.forEach(hiker -> hikerDAOs.add(gethikerDAO(hiker)));
		return hikerDAOs;
	}

	/**
	 * This method maps hiker request model to data model 
	 * @param hiker
	 * @return hiker data model
	 */
	private HikerDAO gethikerDAO(HikerDetails hiker) {
		HikerDAO hikerDAO = new HikerDAO();
		hikerDAO.setDateOfBirth(hiker.getDateOfBirth());
		hikerDAO.setEmailId(hiker.getEmailId());
		hikerDAO.setName(hiker.getName());
		hikerDAO.setPhoneNumber(hiker.getPhoneNumber());
		hikerDAO.setId(hiker.getId());
		
		return hikerDAO;
	}
	
	
	/**
	 * This method maps booking data model to booking request model
	 * @param bookingDao
	 * @return bookingDetails
	 */
	public BookingDetails mapToBookingResponse(BookingDAO bookingDao) {
		
		BookingDetails bookingResponse = new BookingDetails();
		bookingResponse.setBookingDate(bookingDao.getBookingDate());
		bookingResponse.setTrailsId(bookingDao.getTrailsId());
		bookingResponse.setHikerDetails(mapToHikerResponseList(bookingDao.getHikerDetails()));
		bookingResponse.setBookingID(bookingDao.getBookingID());
		return bookingResponse;
	}
	
	/**
	 * This method maps list of hiker data model to list of hiker response model
	 * @param hikerDAOList
	 * @return list of hiker response model
	 */
	public List<HikerDetails> mapToHikerResponseList(List<HikerDAO> hikerDAOList){
		List<HikerDetails> hikerList = new ArrayList<HikerDetails>();
		hikerDAOList.forEach(hiker -> hikerList.add(getHikerList(hiker)));
		return hikerList;
	}

	/**
	 * This method maps hiker data model to response model 
	 * @param hikerDAO
	 * @return hiker response model
	 */
	private HikerDetails getHikerList(HikerDAO hikerDAO) {
		HikerDetails hiker = new HikerDetails();
		hiker.setDateOfBirth(hikerDAO.getDateOfBirth());
		hiker.setEmailId(hikerDAO.getEmailId());
		hiker.setName(hikerDAO.getName());
		hiker.setPhoneNumber(hikerDAO.getPhoneNumber());
		hiker.setId(hikerDAO.getId());
		
		return hiker;
	}

}
