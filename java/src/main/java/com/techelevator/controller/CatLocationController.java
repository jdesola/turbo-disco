package com.techelevator.controller;

import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.CatLocationDAO;
import com.techelevator.model.CatLocation;




@RestController
@CrossOrigin
public class CatLocationController {

	private CatLocationDAO catLocationDao;
	
	public CatLocationController(CatLocationDAO catLocationDao) {
		this.catLocationDao = catLocationDao;
	}

	@RequestMapping(value="/locations", method = RequestMethod.GET)
	public List<CatLocation>  getLocations() {
		return catLocationDao.listLocations();
	}
	
	
	
}