package com.rosie.dvdlib.model.businesslogic;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.rosie.dvdlib.dto.DVD;
import com.rosie.dvdlib.model.dataaccess.DataAccessImpl;
/* Class containing all methods necessary to interact with the data access layer
 * and perform the functions required by the UI layer
 */
@CrossOrigin
@Service("dvdService")
public class BusinessLogicImpl implements BusinessLogic {
	
	@Autowired
	private DataAccessImpl dataAccess;
	
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
		
		return dataAccess.searchRecord(title);
	}



}
