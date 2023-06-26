package com.rosie.dvdlib.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rosie.dvdlib.dto.DVD;

@Repository("dvdDAO")
public class DataAccessImpl implements DataAccess {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<DVD> getAllRecords() {
		
		String query = "SELECT * FROM DVDLibrary";
		return jdbcTemplate.query(query, new DvdMapper());
	
	}

	@Override
	public int addRecord(DVD dvd) {
		
		String query = "INSERT INTO DVDLibrary VALUES(?,?,?,?,?)";
		return jdbcTemplate.update(query, dvd.getTitle(), dvd.getMpaaRating(), dvd.getDirectorName(), dvd.getStudio(), dvd.getUserNote());
	}

	@Override
	public int deleteRecord(String title) {
		
		String query = "DELETE FROM DVDLibrary WHERE title=?";
		return jdbcTemplate.update(query, title);
	}


	@Override
	public int updateRecord(String title, String field, String newValue) {
		String query = "UPDATE DVDLibrary SET " + field + " = '" + newValue + "' WHERE title = '" + title + "'";
		return jdbcTemplate.update(query);
	}
	
	@Override
	public DVD searchRecord(String title) {
		String query="SELECT * FROM DVDLibrary WHERE title = '"+ title + "'";
		try {
		return jdbcTemplate.queryForObject(query, new DvdMapper());
		}
		catch(EmptyResultDataAccessException exception) {
			return null;
		}
	}
	
	

}
