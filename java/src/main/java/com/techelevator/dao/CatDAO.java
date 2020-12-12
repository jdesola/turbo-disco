package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Cat;

public interface CatDAO {
	
	public void createCat(Cat newCat);
	
	public List<Cat> listCats();
	
	public void updateCat(Cat updatedCat);
	
	//public void updateFeatured(Cat featuredCat);
	
	public Cat getCatById(long catId);

}
