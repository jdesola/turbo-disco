package com.techelevator.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.jdbc.CatJDBC;
import com.techelevator.model.Cat;


import org.junit.Assert;


public class JDBC_CatDAO_IntergrationTest extends DAOIntegrationTest{

	private CatDAO catDao;
	private Cat testCat;
	
	@Before
	public void setup() {
		DataSource dataSource = this.getDataSource();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		catDao = new CatJDBC(dataSource);
		testCat = new Cat();
		testCat.setAge(2);
		testCat.setDescription("Loves ramen");
		testCat.setHairLength("Short");
		testCat.setName("Naruto Uzumaki");
		testCat.setPreviousJobs("Hokage");
		testCat.setSkills("Rasengan, Rasen-Shuriken");
		testCat.setPriorExperienceMonths(6);
		testCat.setColor("Brown");
	}
	
	
	@Test
	public void get_list_of_cats() {
		List<Cat> originalList = new ArrayList<Cat>();
		List<Cat> newList = new ArrayList<Cat>();
		originalList = catDao.listCats();
		int originalSize = originalList.size();
		newList = catDao.listCats();
		newList.add(testCat);
		int newListSize = newList.size();
		Assert.assertEquals(originalSize + 1 , newListSize);
		 
	}
	
}
