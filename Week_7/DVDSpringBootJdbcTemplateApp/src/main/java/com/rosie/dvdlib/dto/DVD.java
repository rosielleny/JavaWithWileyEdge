package com.rosie.dvdlib.dto;

public class DVD {
	// Data transfer object DVD, containing the following 
	private String title; 
	private String mpaaRating;
	private String directorName;
	private String studio;
	private String userNote; // User rating or personal note
	
	
	
	
	public DVD(String title, String mpaaRating, String directorName, String studio,
			String userNote) {
		this.title = title;
		this.mpaaRating = mpaaRating;
		this.directorName = directorName;
		this.studio = studio;
		this.userNote = userNote;
	}
	
	public DVD() {
	    this.title = "";
	    this.mpaaRating = "";
	    this.directorName = "";
	    this.studio = "";
	    this.userNote = "";
	}
	
	// Getters, Setters, ToString
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getMpaaRating() {
		return mpaaRating;
	}
	public void setMpaaRating(String mpaaRating) {
		this.mpaaRating = mpaaRating;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
	public String getUserNote() {
		return userNote;
	}
	public void setUserNote(String userNote) {
		this.userNote = userNote;
	}
	@Override
	public String toString() {
		return "DVD [title=" + title + ", mpaaRating=" + mpaaRating + ", directorName="
				+ directorName + ", studio=" + studio + ", userNote=" + userNote + "]";
	}
	
	

}

