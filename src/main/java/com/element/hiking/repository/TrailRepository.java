/**
 * 
 */
package com.element.hiking.repository;

import java.util.List;

import com.element.hiking.datamodels.TrailsDAO;

/**
 * @author srake
 *
 */
public interface TrailRepository {
	
	List<TrailsDAO> getAllTrails();
	
	TrailsDAO getTrailById(Integer trailId);
	
	TrailsDAO creatTrail(TrailsDAO trail);

}
