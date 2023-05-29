package com.rosie.dvdlib.dataaccess;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import com.rosie.dvdlib.dto.DVD;

public class DataAccessImpl implements DataAccess {
	
	LinkedList dvdLibrary = new LinkedList<>();
	
	// Method for writing to the file ie. storing and saving the library and changes made to it by the user
	@Override
	public boolean writeRecords(LinkedList<DVD> dvdLibrary) throws Exception {
	    FileWriter fileWriter = new FileWriter("DVD_Library.txt");
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    
	    // Iterate over each DVD in the dvdLibrary
	    for (DVD dvd : dvdLibrary) { 
	        String dvdStr = dvd.getTitle() + "," + dvd.getReleaseDate() + "," + dvd.getMpaaRating() + "," + dvd.getDirectorName() + "," + dvd.getStudio() + "," + dvd.getUserNote();
	        
	        // Write the individual DVD string to the file
	        printWriter.println(dvdStr);
	    }
	    
	    printWriter.close(); // Close the PrintWriter
	    
	    return true;
	}

	/* Method for reading the file, seeing what dvds are in there already, converting the file
	 * into a list of objects which can be manipulated by the rest of the program
	 */
	@Override
	public LinkedList<DVD> readRecords() throws Exception {
		
		LinkedList<DVD> dvdLibrary = new LinkedList<DVD>();
		
		FileReader fileReader = new FileReader("DVD_Library.txt");
		
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		Scanner scanner = new Scanner(bufferedReader);
		
		while(scanner.hasNext()) {
			
			String currentLine = scanner.nextLine();
			// Splits the current line into an array of substrings using comma as the delimiter
			String values[]=currentLine.split(",");
			// Creates a new DVD object using the values extracted from the line
			DVD dvd=new DVD((values[0]), values[1], values[2], values[3], (values[4]), values[5]);
			// Adds the DVD object to the dvdLibrary LinkedList
			dvdLibrary.add(dvd);
		}
		
		fileReader.close();
		bufferedReader.close();
		
		return dvdLibrary;
	}

}
