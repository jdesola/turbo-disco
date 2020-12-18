package com.techelevator.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.SuccessStoryDAO;
import com.techelevator.model.SuccessStory;

@RestController
@CrossOrigin
public class SuccessStoryController {

	private SuccessStoryDAO successStoryDao;
	
	public SuccessStoryController(SuccessStoryDAO successStoryDao) {
		this.successStoryDao = successStoryDao;
	}
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value="/tools/successStoryForm", method = RequestMethod.POST)
	public void SuccessStory (@RequestBody SuccessStory story) {
		successStoryDao.createSuccessStory(story);
	}
	
	@RequestMapping (path ="/successStories", method=RequestMethod.GET)
	public List<SuccessStory> getSuccessStories() {
		return successStoryDao.listSuccessStories();
	}
}
