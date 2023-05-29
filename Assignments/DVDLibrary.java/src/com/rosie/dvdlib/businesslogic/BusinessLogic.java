package com.rosie.dvdlib.businesslogic;

import java.util.LinkedList;

import com.rosie.dvdlib.dto.*;

public interface BusinessLogic {
	
	LinkedList<DVD> getAllDVDs();
	boolean addDVD(DVD dvd);
	boolean deleteDVD(String title);
	public void saveAllDVDs();
	public DVD searchDVDs(String title);

}
