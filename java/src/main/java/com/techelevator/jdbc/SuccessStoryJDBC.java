package com.techelevator.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.dao.SuccessStoryDAO;
import com.techelevator.model.Cat;
import com.techelevator.model.SuccessStory;

@Component
public class SuccessStoryJDBC implements SuccessStoryDAO {

	private final JdbcTemplate jdbcTemplate;
	
	public SuccessStoryJDBC(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void createSuccessStory(SuccessStory story) {
		String sql = "insert into success_stories values (?,?,?,?)";
		jdbcTemplate.update(sql, story.getCatId(), story.getAdopterName(), story.getDateAdopted(),story.getSuccessStory());
	}
	
	public List<SuccessStory> successStories = new ArrayList<SuccessStory>();

}
