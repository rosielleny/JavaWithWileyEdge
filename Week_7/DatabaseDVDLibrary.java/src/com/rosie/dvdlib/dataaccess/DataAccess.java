package com.rosie.dvdlib.dataaccess;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import com.rosie.dvdlib.dto.DVD;

public interface DataAccess {

	List<DVD> getAllRecords();
	int addRecord(DVD dvd);
	int deleteRecord(String title);
	int updateRecord(String title, String field, String newValue);
	

}
