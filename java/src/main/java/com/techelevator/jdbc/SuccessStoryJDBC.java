package com.techelevator.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
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
	
	@Override
	public List<SuccessStory> listSuccessStories() {
		List<SuccessStory> successStoriesList = new ArrayList<SuccessStory>();
		String sql = "select catch_cats.name , date_adopted , story , cat_id, adopter_name from success_stories join catch_cats on catch_cats.id = success_stories.cat_id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			SuccessStory story = mapRowToStory(results);
			successStoriesList.add(story);
		}
		return successStoriesList;
	}
	
	private SuccessStory mapRowToStory(SqlRowSet row) {
		SuccessStory storyMap = new SuccessStory();
		storyMap.setCatId(row.getLong("cat_id"));
		storyMap.setAdopterName(row.getString("adopter_name"));
		storyMap.setDateAdopted(row.getDate("date_adopted"));
		storyMap.setSuccessStory(row.getString("story"));
		
		return storyMap;
	}
}
