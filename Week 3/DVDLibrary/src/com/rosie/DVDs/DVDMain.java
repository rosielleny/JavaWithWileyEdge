package com.rosie.DVDs;
import java.util.LinkedList;

public class DVDMain {

	public static void main(String[] args) {
		
		LinkedList<DVD> dvdLibrary = new LinkedList<>();

        dvdLibrary.add(new DVD("Title 1", "Release Date 1", "MPAA Rating 1", "Director 1", "Studio 1", "User Rating 1"));
        dvdLibrary.add(new DVD("Title 2", "Release Date 2", "MPAA Rating 2", "Director 2", "Studio 2", "User Rating 2"));
        dvdLibrary.add(new DVD("Title 3", "Release Date 3", "MPAA Rating 3", "Director 3", "Studio 3", "User Rating 3"));
		
        for (DVD dvd : dvdLibrary) {
            System.out.println(dvd);
            System.out.println();
        }
		
	}

}
