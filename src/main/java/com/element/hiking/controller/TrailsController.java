/**
 * 
 */
package com.element.hiking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.element.hiking.models.Trails;
import com.element.hiking.service.TrailService;

/**
 * @author srake
 *
 */
@RestController
@RequestMapping("/trails")
public class TrailsController {
	
	@Autowired
	TrailService service;
	
	@GetMapping(value = "/alltrails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Trails>> getAllTrails(){
		return ResponseEntity.ok(service.getAllTrails());
		
	}
	
	@GetMapping(value = "/{trailId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Trails> getTrail(@PathVariable("trailId") Integer trailId){
		return ResponseEntity.ok(service.getTrail(trailId));
	}
	
	@PostMapping(value = "/creatTrail",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Trails> creatTrail(@RequestBody Trails trail){
		return ResponseEntity.ok(service.creatTrail(trail));
	}
	
	

}
