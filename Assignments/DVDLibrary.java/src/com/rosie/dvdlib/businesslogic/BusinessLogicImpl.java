package com.rosie.dvdlib.businesslogic;

import java.util.LinkedList;
import com.rosie.dvdlib.dataaccess.*;

import com.rosie.dvdlib.dto.DVD;
/* Class containing all methods necessary to interact with the data access layer
 * and perform the functions required by the UI layer
 */
public class BusinessLogicImpl implements BusinessLogic {
	
	private DataAccessImpl dataAccess; //= new DataAccessImpl();
	private LinkedList<DVD> dvdLibrary;
	
	public BusinessLogicImpl(DataAccessImpl dataAccess) {
		super();
		this.dataAccess = dataAccess;	
		 try {
		        dvdLibrary = dataAccess.readRecords();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}

	/*public BusinessLogicImpl() { // Initialises the dvdLibrary by reading records from the data access layer
		
		try {
			
			dvdLibrary = dataAccess.readRecords();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	@Override
	public LinkedList<DVD> getAllDVDs() {
		// returns the dvdLibrary list to show the user the whole library
		return dvdLibrary; 
	}

	@Override
	public boolean addDVD(DVD dvd){
		// adds the newly created dvd object to the dvdLibrary list
		return dvdLibrary.add(dvd); 
	}

	@Override
	public boolean deleteDVD(String title) {
		
		for(DVD dvd:dvdLibrary) {
			// If there is a dvd object with a title matching the user's input, that object will be deleted
			if(title.equalsIgnoreCase(dvd.getTitle())) {
				return dvdLibrary.remove(dvd);
			}		
		}
		return false;
	}

	@Override
	public void saveAllDVDs() {
		// Calls function to write to the file, saving the user's changes
		try {
			dataAccess.writeRecords(dvdLibrary); 
		}catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public DVD searchDVDs(String title) {
		// If there is a dvd object with a title matching the user's input, that dvd object will be returned
		for(DVD dvd:dvdLibrary) {
			if(title.equalsIgnoreCase(dvd.getTitle())) { 
				return dvd;
			}		
		}
		return null;
	}

}
