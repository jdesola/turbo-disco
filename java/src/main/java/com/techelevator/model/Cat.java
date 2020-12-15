package com.techelevator.model;

public class Cat {
	
	private String name;
	private int age;
	private String skills;
	private String hairLength;
	private int priorExperienceMonths;
	private String previousJobs;
	private String description;
	private long id;
	private String color;
	private boolean featured;
	private String imageName;
	private boolean adopted;
	private int strengthRating;
	private int intelligenceRating;
	private int speedRating;
	private int staminaRating;
	private int locationId;
	
	public boolean isAdopted() {
		return adopted;
	}

	public void setAdopted(boolean isAdopted) {
		this.adopted = isAdopted;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean isFeatured) {
		this.featured = isFeatured;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getHairLength() {
		return hairLength;
	}
	public void setHairLength(String hairLength) {
		this.hairLength = hairLength;
	}
	public int getPriorExperienceMonths() {
		return priorExperienceMonths;
	}
	public void setPriorExperienceMonths(int priorExperienceMonths) {
		this.priorExperienceMonths = priorExperienceMonths;
	}
	public String getPreviousJobs() {
		return previousJobs;
	}
	public void setPreviousJobs(String previousJobs) {
		this.previousJobs = previousJobs;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageUrl) {
		this.imageName = imageUrl;
	}

	public int getStrengthRating() {
		return strengthRating;
	}

	public void setStrengthRating(int strengthRating) {
		this.strengthRating = strengthRating;
	}

	public int getIntelligenceRating() {
		return intelligenceRating;
	}

	public void setIntelligenceRating(int intelligenceRating) {
		this.intelligenceRating = intelligenceRating;
	}

	public int getSpeedRating() {
		return speedRating;
	}

	public void setSpeedRating(int speedRating) {
		this.speedRating = speedRating;
	}

	public int getStaminaRating() {
		return staminaRating;
	}

	public void setStaminaRating(int staminaRating) {
		this.staminaRating = staminaRating;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	
	







}
