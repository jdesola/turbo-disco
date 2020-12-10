package com.techelevator.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.techelevator.model.Cat;

public interface CatDAO {
	
	public void createCat(Cat newCat);
	
	public List<Cat> listCats();
	
	public void deleteCat(long catId);
	
	public void updateFeatured(Cat featuredCat);
	
	public Cat getCatById(long catId);

}
