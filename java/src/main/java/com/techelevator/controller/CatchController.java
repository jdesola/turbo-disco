package com.techelevator.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.CatDAO;
import com.techelevator.model.Cat;

@RestController
@CrossOrigin
public class CatchController {
	
	private CatDAO catDao;
	
	public CatchController(CatDAO catDao) {
		this.catDao = catDao;
	}
	
	@RequestMapping (path ="/cats", method=RequestMethod.GET)
	public List<Cat> getCatz() {
		
		return catDao.listCats();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value="/tools/addCat", method = RequestMethod.POST)
	public void cat (@RequestBody Cat cat) {
		catDao.createCat(cat);
	}
	

	@RequestMapping(path="/cats", method=RequestMethod.PUT) 
	public void update(@RequestBody Cat updatedCat) { 
		catDao.updateCat(updatedCat); 
	}
	
	
	@RequestMapping(path="/cats/{catId}", method = RequestMethod.GET)
	public Cat getCatById(@PathVariable long catId) {
		 return catDao.getCatById(catId);
	}

}
