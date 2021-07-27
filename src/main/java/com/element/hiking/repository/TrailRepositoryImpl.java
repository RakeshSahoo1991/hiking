/**
 * 
 */
package com.element.hiking.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.element.hiking.datamodels.TrailsDAO;

/**
 * This is repository call as of now I have used static map to stored the data in future will be replaced by data base
 * @author srake
 *
 */
@Repository
public class TrailRepositoryImpl implements TrailRepository{
	
	
	private static Map<Integer,TrailsDAO> trails = new HashMap<Integer, TrailsDAO>();
	
	private static Integer id = 3;
	
	static
	{
		TrailsDAO trail1 = new TrailsDAO(1,"Shire","07:00","09:00",5,100,29.90);
		TrailsDAO trail2 = new TrailsDAO(2,"Gondor","10:00","13:00",11,50,59.90);
		TrailsDAO trail3 = new TrailsDAO(3,"Mordor","14:00","19:00",18,40,99.90);
		trails.put(trail1.getId(), trail1);
		trails.put(trail2.getId(), trail2);
		trails.put(trail3.getId(), trail3);
	}

	/**
	 * This method retrieves all the trails available 
	 * @return List of trails
	 */
	@Override
	public List<TrailsDAO> getAllTrails() {
		
		return trails.values()
                .stream()
                .collect(Collectors.toList());
	}

	/**
	 * This methods returns a particular trail based on the id
	 * @return trailDAO
	 * @param trailId
	 */
	@Override
	public TrailsDAO getTrailById(Integer trailId) {
		return trails.get(trailId);
	}

	/**
	 * This method creates a new record of trail based on the trail information 
	 * @return TrailDAO
	 */
	@Override
	public TrailsDAO creatTrail(TrailsDAO trail) {
		trail.setId(++id);
		trails.put(trail.getId(), trail);
		return trail;
	}

}
