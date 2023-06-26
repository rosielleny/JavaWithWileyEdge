package com.rosie.dvdlib.businesslogic;

import java.util.LinkedList;
import java.util.List;

import com.rosie.dvdlib.dataaccess.*;

import com.rosie.dvdlib.dto.DVD;
/* Class containing all methods necessary to interact with the data access layer
 * and perform the functions required by the UI layer
 */
public class BusinessLogicImpl implements BusinessLogic {
	
	private DataAccessImpl dataAccess = new DataAccessImpl();
	
	
	@Override
	public List<DVD> getAllDVDs() {
		// returns the dvdLibrary list to show the user the whole library
		return dataAccess.getAllRecords(); 
	}

	@Override
	public boolean addDVD(DVD dvd) {
		return dataAccess.addRecord(dvd)>0;
	}

	@Override
	public int deleteDVD(String title) {
		
		return dataAccess.deleteRecord(title);
	}

	@Override
	public int updateDVDs(String title, String field, String newValue) {
		
		return dataAccess.updateRecord(title, field, newValue);
		
	}
	
	@Override
	public DVD searchDVDs(String title) {
		List<DVD> dvdLibrary = getAllDVDs();
		// If there is a dvd object with a title matching the user's input, that dvd object will be returned
		for(DVD dvd:dvdLibrary) {
			if(title.equalsIgnoreCase(dvd.getTitle())) { 
				return dvd;
			}		
		}
		return null;
	}



}
