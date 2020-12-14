package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.SuccessStory;

public interface SuccessStoryDAO {
	
	public void createSuccessStory(SuccessStory story);
	
	public List<SuccessStory> listSuccessStories();
}
