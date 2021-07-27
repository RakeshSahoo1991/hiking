/**
 * 
 */
package com.element.hiking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.element.hiking.mapper.DataMapper;
import com.element.hiking.models.Trails;
import com.element.hiking.repository.TrailRepository;

/**
 * @author srake
 *
 */
@Service
public class TrailService {
	
	@Autowired
	TrailRepository repository;
	
	@Autowired
	DataMapper mapper;
	
	/**
	 * This method retrieve all the trails available for the hikers
	 * @return list of trail
	 */
	public List<Trails> getAllTrails(){
		
		return mapper.getResponseTrails(repository.getAllTrails());
	}
	
	
	public Trails getTrail(Integer trailId) {
		return mapper.getResponseTrail(repository.getTrailById(trailId));
		
	}
	
	public Trails creatTrail(Trails trail) {
		return mapper.getResponseTrail(repository.creatTrail(mapper.getTrailDAO(trail)));
	}

}
