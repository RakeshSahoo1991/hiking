package com.element.hiking.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.element.hiking.datamodels.BookingDAO;
import com.element.hiking.datamodels.HikerDAO;
import com.element.hiking.datamodels.TrailsDAO;
import com.element.hiking.mapper.DataMapper;
import com.element.hiking.models.BookingDetails;
import com.element.hiking.models.HikerDetails;
import com.element.hiking.models.Trails;
import com.element.hiking.repository.BookingRepository;
import com.element.hiking.repository.TrailRepository;


@RunWith(MockitoJUnitRunner.class)
public class BookingServiceTest {
	
	@InjectMocks
	BookingService service;
	
	@Mock
	private BookingRepository repositoryMock;
	
	@Mock
	private TrailRepository trailRepoMock;
	
	@Mock
	private DataMapper mapperMock;
	
	@Before
    public void init() {
		
        MockitoAnnotations.initMocks(this);
    }

    
	@Test
	public void bookTrail() throws Exception {
		when(repositoryMock.bookTrail(Mockito.any(BookingDAO.class))).thenReturn(creatBookingDAORes());
		when(mapperMock.getResponseTrail(Mockito.any(TrailsDAO.class))).thenReturn(TrailsMock());
		when(mapperMock.mapToBookingResponse(Mockito.any(BookingDAO.class))).thenReturn(creatBookingRes());
		when(mapperMock.mapToBookingDAO(Mockito.any(BookingDetails.class))).thenReturn(creatBookingDAOReq());
    	when(trailRepoMock.getTrailById(Mockito.anyInt())).thenReturn(new TrailsDAO(2,"Gondor","10:00","13:00",11,50,59.90));
		BookingDetails bookingDetails = service.bookTrail(creatBookingReq());
		assertEquals(new Integer(1), bookingDetails.getBookingID());
		verify(repositoryMock, times(1)).bookTrail(creatBookingDAOReq());
	}
	 

    @Test
    public void getBookingById() throws Exception {
		when(mapperMock.mapToBookingResponse(Mockito.any(BookingDAO.class))).thenReturn(creatBookingRes());
		when(mapperMock.getResponseTrail(Mockito.any(TrailsDAO.class))).thenReturn(TrailsMock());
    	when(repositoryMock.getBookingById(Mockito.anyInt())).thenReturn(creatBookingDAORes());
    	when(trailRepoMock.getTrailById(Mockito.anyInt())).thenReturn(new TrailsDAO(2,"Gondor","10:00","13:00",11,50,59.90));
    	BookingDetails bookingDetails = service.getBookingById(1);
    	assertEquals(new Integer(1), bookingDetails.getBookingID());
    	verify(repositoryMock, times(1)).getBookingById(1);
    }

    @Test
    public void cancelBooking() {
    }
    
    private BookingDetails creatBookingReq() {
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setBookingDate("2021-08-23");
		bookingDetails.setTrailsId(2);
		
		HikerDetails hiker = new HikerDetails();
		hiker.setName("Rakesh Sahoo");
		hiker.setEmailId("rakesh@gmail.com");
		hiker.setPhoneNumber("+49037477755");
		hiker.setDateOfBirth("1991-05-06");
		
		bookingDetails.getHikerDetails().add(hiker);
		return bookingDetails;
	}
    
    private BookingDetails creatBookingRes() {
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setBookingDate("2021-08-23");
		bookingDetails.setTrailsId(2);
		bookingDetails.setBookingID(1);
		
		HikerDetails hiker = new HikerDetails();
		hiker.setName("Rakesh Sahoo");
		hiker.setEmailId("rakesh@gmail.com");
		hiker.setPhoneNumber("+49037477755");
		hiker.setDateOfBirth("1991-05-06");
		
		bookingDetails.getHikerDetails().add(hiker);
		return bookingDetails;
	}
    private BookingDAO creatBookingDAORes() {
    	BookingDAO bookingDAO = new BookingDAO();
    	bookingDAO.setBookingID(1);
    	bookingDAO.setBookingDate("2021-08-23");
    	bookingDAO.setTrailsId(2);
		
    	HikerDAO hiker = new HikerDAO();
		hiker.setName("Rakesh Sahoo");
		hiker.setEmailId("rakesh@gmail.com");
		hiker.setPhoneNumber("+49037477755");
		hiker.setDateOfBirth("1991-05-06");
		
		bookingDAO.getHikerDetails().add(hiker);
		return bookingDAO;
	}
    private BookingDAO creatBookingDAOReq() {
    	BookingDAO bookingDAO = new BookingDAO();
    	bookingDAO.setBookingDate("2021-08-23");
    	bookingDAO.setTrailsId(2);
		
    	HikerDAO hiker = new HikerDAO();
		hiker.setName("Rakesh Sahoo");
		hiker.setEmailId("rakesh@gmail.com");
		hiker.setPhoneNumber("+49037477755");
		hiker.setDateOfBirth("1991-05-06");
		
		bookingDAO.getHikerDetails().add(hiker);
		return bookingDAO;
	}
    private Trails TrailsMock() {
    	Trails trail = new Trails();
    	trail.setTrailId(2);
    	trail.setName("Gondor");
    	trail.setStartTime("10:00");
    	trail.setEndTime("13:00");
    	trail.setMinAge(11);
    	trail.setMaxAge(50);
    	trail.setPrice(59.90);
    	return trail;
    }
    
}