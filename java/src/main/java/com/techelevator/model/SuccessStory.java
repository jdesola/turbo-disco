package com.techelevator.model;

import java.sql.Date;

public class SuccessStory {
	private long storyId;
	private long catId;
	private String catName;
	private String adopterName;
	private Date dateAdopted;
	private String successStory;
	
	public long getStoryId() {
		return storyId;
	}
	public void setStoryId(long storyId) {
		this.storyId = storyId;
	}
	
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public long getCatId() {
		return catId;
	}
	public void setCatId(long catId) {
		this.catId = catId;
	}
	public String getAdopterName() {
		return adopterName;
	}
	public void setAdopterName(String adopterName) {
		this.adopterName = adopterName;
	}
	public Date getDateAdopted() {
		return dateAdopted;
	}
	public void setDateAdopted(Date dateAdopted) {
		this.dateAdopted = dateAdopted;
	}
	public String getSuccessStory() {
		return successStory;
	}
	public void setSuccessStory(String successStory) {
		this.successStory = successStory;
	}
	
	
}
