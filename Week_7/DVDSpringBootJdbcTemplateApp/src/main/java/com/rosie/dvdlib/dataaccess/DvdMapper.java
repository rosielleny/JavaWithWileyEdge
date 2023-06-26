package com.rosie.dvdlib.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rosie.dvdlib.dto.DVD;

public class DvdMapper implements RowMapper<DVD> {

	@Override
	public DVD mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		String title = rs.getString("title");
		String mpaa = rs.getString("MPAA");
		String directorName = rs.getString("DirectorName");
		String studio = rs.getString("Studio");
		String userRating = rs.getString("UserRating");
		
		DVD dvd = new DVD(title, mpaa, directorName, studio, userRating);
		return dvd;
	}

}
