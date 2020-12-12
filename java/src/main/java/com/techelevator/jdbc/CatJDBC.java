package com.techelevator.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.dao.CatDAO;
import com.techelevator.model.Cat;

@Component
public class CatJDBC implements CatDAO{
	
	private final JdbcTemplate jdbcTemplate;
	
	public CatJDBC(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public void createCat(Cat newCat) {
		String sql = "INSERT INTO catch_cats (name, age, skills, hair_length, prior_experience_months, prior_jobs, description, color, image_url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, newCat.getName(), newCat.getAge(), newCat.getSkills(), newCat.getHairLength(), newCat.getPriorExperienceMonths(),
							newCat.getPreviousJobs(), newCat.getDescription(), newCat.getColor(), newCat.getImageUrl());
	}


	@Override
	public List<Cat> listCats() {
		List<Cat> catList = new ArrayList <Cat>();
		String sql = "select * from catch_cats";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			Cat cat = mapRowToCat(results);
			catList.add(cat);
		}
		return catList;
	}
	
	@Override 
	public void updateCat(Cat updatedCat) { 
		String sql = "update catch_cats set name = ?, age = ?, skills = ?,  hair_length = ?, prior_experience_months = ?, prior_jobs = ?, description = ?, color = ?, image_url = ? where id = ?";
		jdbcTemplate.update(sql, updatedCat.getName(), updatedCat.getAge(), updatedCat.getSkills(), updatedCat.getHairLength(), updatedCat.getPriorExperienceMonths(), updatedCat.getPreviousJobs(), updatedCat.getDescription(), updatedCat.getColor(), updatedCat.getImageUrl(), updatedCat.getId()); 
	}
	
//	@Override
//	public void updateFeatured(Cat updatedCat ) {
//		String sql = "update catch_cats set isFeatured = ? where id = ?";
//		jdbcTemplate.update(sql, updatedCat.isFeatured(), updatedCat.getId());
//	}
	
	@Override
	public Cat getCatById(long catId) {
		String sql = "select * from catch_cats where id = ?";
		SqlRowSet catRows = jdbcTemplate.queryForRowSet(sql, catId);
		catRows.next();
		Cat newCat = mapRowToCat(catRows);
		return newCat;
	}

	
	private Cat mapRowToCat(SqlRowSet row ) {
		Cat catMap = new Cat();
		catMap.setAge(row.getInt("age"));
		catMap.setDescription(row.getString("description"));
		catMap.setHairLength(row.getString("hair_length"));
		catMap.setColor(row.getString("color"));
		catMap.setId(row.getLong("id"));
		catMap.setName(row.getString("name"));
		catMap.setPreviousJobs(row.getString("prior_jobs"));
		catMap.setPriorExperienceMonths(row.getInt("prior_experience_months"));
		catMap.setSkills(row.getString("skills"));
		catMap.setFeatured(row.getBoolean("isFeatured"));
		catMap.setImageUrl(row.getString("image_url"));
		catMap.setAdopted(row.getBoolean("isAdopted"));
		
		return catMap;
		
	}


	


	
	
	
	
	
	
	

	
	
}
