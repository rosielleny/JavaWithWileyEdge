package com.rosie.dvdlib.dto;

import java.util.List;

public class DVDList {
	
	private List<DVD> dvds;
	
	public DVDList() {}
	
	public DVDList(List<DVD> dvds) {
		
		super();
		this.dvds = dvds;
	}
	
	public List<DVD> getDVDs() {
		return dvds;
	}

	public void setDVDs(List<DVD> dvds) {
		this.dvds = dvds;
	}
}
