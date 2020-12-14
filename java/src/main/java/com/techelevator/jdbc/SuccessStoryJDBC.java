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
		String sql = "insert into success_stories (cat_id, adopter_name, date_adopted, story) values (?,?,?,?)";
		jdbcTemplate.update(sql, story.getCatId(), story.getAdopterName(), story.getDateAdopted(),story.getSuccessStory());
	}
	
	@Override
	public List<SuccessStory> listSuccessStories() {
		List<SuccessStory> successStoriesList = new ArrayList<SuccessStory>();
		String sql = "select catch_cats.name , date_adopted , story , cat_id, adopter_name, success_stories.id from success_stories join catch_cats on success_stories.cat_id = catch_cats.id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			SuccessStory story = mapRowToStory(results);
			successStoriesList.add(story);
		}
		return successStoriesList;
	}
	
	private SuccessStory mapRowToStory(SqlRowSet row) {
		SuccessStory storyMap = new SuccessStory();
		storyMap.setStoryId(row.getLong("id"));
		storyMap.setCatName(row.getString("name"));
		storyMap.setCatId(row.getLong("cat_id"));
		storyMap.setAdopterName(row.getString("adopter_name"));
		storyMap.setDateAdopted(row.getDate("date_adopted"));
		storyMap.setSuccessStory(row.getString("story"));
		
		return storyMap;
	}
}
