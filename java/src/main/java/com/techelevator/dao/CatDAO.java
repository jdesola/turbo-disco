package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Cat;

public interface CatDAO {
	
	public int createCat(Cat newCat);
	
	public List<Cat> listCats();
	
	

}
