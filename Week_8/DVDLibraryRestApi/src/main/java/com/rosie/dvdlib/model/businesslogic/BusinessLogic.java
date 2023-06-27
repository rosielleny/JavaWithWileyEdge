package com.rosie.dvdlib.model.businesslogic;

import java.util.LinkedList;
import java.util.List;

import com.rosie.dvdlib.dto.*;

public interface BusinessLogic {
	
	List<DVD> getAllDVDs();
	boolean addDVD(DVD dvd);
	int deleteDVD(String title);
	int updateDVDs(String title, String field, String newValue);
	DVD searchDVDs(String title);

}
