package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.dao.CatDAO;
import com.techelevator.model.Cat;

public class CatJDBC implements CatDAO{
	
	private final JdbcTemplate jdbcTemplate;
	
	public CatJDBC(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public int createCat(Cat newCat) {
		String sql = "INSERT INTO catch_cats (name, age, skills, hair_length, prior_experience_months, prior_jobs, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
		int rowsUpdated = jdbcTemplate.update(sql, newCat.getName(), newCat.getAge(), newCat.getSkills(), newCat.getHairLength(), newCat.getPriorExperienceMonths(),
							newCat.getPreviousJobs(), newCat.getDescription());
		return rowsUpdated;
	}


	@Override
	public List<Cat> listCats() {
		List<Cat> catList = new ArrayList <Cat>();
		String sql = "select name, age, skills, hair_length, prior_experience_months, prior_jobs, description from catch_cats";
		
		
		
		return catList;
	}
	
	
	
	

	
	
}
