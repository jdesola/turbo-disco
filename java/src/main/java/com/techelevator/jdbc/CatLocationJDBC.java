package com.techelevator.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.dao.CatLocationDAO;
import com.techelevator.model.CatLocation;

@Component
public class CatLocationJDBC implements CatLocationDAO {
private final JdbcTemplate jdbcTemplate;
	
	public CatLocationJDBC(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<CatLocation> listLocations() {
		List<CatLocation> locationList = new ArrayList<CatLocation>();
		String sql = "select * from cat_locations";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			CatLocation location = mapRowToLocation(results);
			locationList.add(location);
		}
		return locationList;
	}
	
	
	private CatLocation mapRowToLocation(SqlRowSet row) {
		CatLocation locationMap = new CatLocation();
		locationMap.setId(row.getInt("id"));
		locationMap.setName(row.getString("location_name"));
		locationMap.setStreetAddress(row.getString("street_address"));
		locationMap.setCity(row.getString("city"));
		locationMap.setState(row.getString("state_abbr"));
		locationMap.setZipCode(row.getString("zip_code"));
		locationMap.setLatitude(row.getFloat("latitude"));
		locationMap.setLongitude(row.getFloat("longitude"));
		
		return locationMap;
	}

}
