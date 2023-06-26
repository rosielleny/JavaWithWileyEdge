package com.rosie.dvdlib.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.rosie.dvdlib.dto.DVD;

public class DataAccessImpl implements DataAccess {
	
	

	@Override
	public List<DVD> getAllRecords() {
		Connection connection = null;
		PreparedStatement preparedStatement;
		List<DVD> dvdList = new ArrayList<DVD>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DVDLibrary", "root", "Bluebell137");
			
			preparedStatement = connection.prepareStatement("SELECT * FROM DVDLibrary");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// Creating the DVD object
			while(resultSet.next()) {
				String title = resultSet.getString("title");
				String mpaa = resultSet.getString("MPAA");
				String directorName = resultSet.getString("DirectorName");
				String studio = resultSet.getString("Studio");
				String userRating = resultSet.getString("UserRating");
				
				DVD dvd = new DVD(title, mpaa, directorName, studio, userRating);
				dvdList.add(dvd);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		return dvdList;
	}

	@Override
	public int addRecord(DVD dvd) {
		
		Connection connection = null;
		PreparedStatement preparedStatement;
		
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DVDLibrary", "root", "Bluebell137");
			
			preparedStatement = connection.prepareStatement("INSERT INTO DVDLibrary VALUES(?,?,?,?,?)");
			
			preparedStatement.setString(1, dvd.getTitle());
			preparedStatement.setString(2, dvd.getMpaaRating());
			preparedStatement.setString(3, dvd.getDirectorName());
			preparedStatement.setString(4, dvd.getStudio());
			preparedStatement.setString(5, dvd.getUserNote());

			int rows = preparedStatement.executeUpdate();
			
			return rows;
			
		}catch(ClassNotFoundException | SQLException e){
			
			e.printStackTrace();
			
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				return 0;
			}
		}
		return 0;
	}

	@Override
	public int deleteRecord(String title) {
		
		Connection connection = null;
		PreparedStatement preparedStatement;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DVDLibrary", "root", "Bluebell137");
			
			preparedStatement = connection.prepareStatement("DELETE FROM DVDLibrary WHERE title=?");
			
			preparedStatement.setString(1, title);
			
			int rows = preparedStatement.executeUpdate();
			
			return rows;
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			return 0;
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}


	@Override
	public int updateRecord(String title, String field, String newValue) {
		
		Connection connection = null;
		PreparedStatement preparedStatement;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DVDLibrary", "root", "Bluebell137");
			
			String query = "UPDATE DVDLibrary SET " + field + " = ? WHERE title = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, newValue);
			preparedStatement.setString(2, title);
			
			int rows = preparedStatement.executeUpdate();
			
			return rows;
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			return 0;
		}finally {
			try {
				
				connection.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}
	
	

}
