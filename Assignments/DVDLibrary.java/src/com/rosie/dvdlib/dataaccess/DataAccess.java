package com.rosie.dvdlib.dataaccess;
import java.util.LinkedList;
import java.io.BufferedReader;
import com.rosie.dvdlib.dto.DVD;

public interface DataAccess {

	public boolean writeRecords(LinkedList<DVD> dvdLibrary)throws Exception;
	public LinkedList<DVD> readRecords()throws Exception;
	

}
