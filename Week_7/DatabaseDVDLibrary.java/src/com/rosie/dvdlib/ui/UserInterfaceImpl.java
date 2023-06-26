package com.rosie.dvdlib.ui;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

import com.rosie.dvdlib.businesslogic.*;
import com.rosie.dvdlib.dto.*;

public class UserInterfaceImpl implements UserInterface {
	
	private BusinessLogicImpl dvdBusinessLogic = new BusinessLogicImpl();

	// Method to display a menu from which the user can choose options
	@Override
	public void showMenu() {
		
		System.out.println("Menu:");
		System.out.println("1. Add DVD to library");
		System.out.println("2. Remove DVD from library");
		System.out.println("3. Edit DVD information");
		System.out.println("4. Show all DVDs");
		System.out.println("5. Search DVD by title");
		System.out.println("0. Quit");

	}

	/* Performs the menu by checking which option the user chose and calling the relevant
	 * functions from the business logic layer
	 */
	@Override
	public void performMenu(int choice) {
		
		Scanner sc = new Scanner(System.in);
		
			switch(choice) {
			
			case 1: // Add DVD to library
				
				DVD dvd = new DVD();
				// Setting each piece of info for the new DVD
				System.out.println("Enter title: ");
				dvd.setTitle(sc.nextLine());
				System.out.println("Enter MPAA rating: ");
				dvd.setMpaaRating(sc.nextLine());
				System.out.println("Enter name of director: ");
				dvd.setDirectorName(sc.nextLine());
				System.out.println("Enter studio: ");
				dvd.setStudio(sc.nextLine());
				System.out.println("Add a personal rating or note: ");
				dvd.setUserNote(sc.nextLine());
				
				try {
					dvdBusinessLogic.addDVD(dvd);
					System.out.println("DVD added to library");
					}
				catch(Exception e){
					System.out.println("DVD not added");
				}
				break;
			
			case 2: // Remove DVD from library
				System.out.println("Enter the title of the DVD you wish to delete: ");
				String title = sc.nextLine();
				
					if(dvdBusinessLogic.deleteDVD(title)>0){ // Will return true if DVD was found and removed
						System.out.println(title +" deleted from DVD Library");
					}
					else {
						System.out.println(title +" not found in Library. No changes made.");
					}
					break;
			
			case 3: // Edit DVD information
				
				int choiceEdit = 1;
				
				
				while(choiceEdit < 7 && choiceEdit > 0) {
					
					System.out.println("Enter the title of the DVD you wish to edit: ");
					String title1 = sc.nextLine();
					DVD foundDvd = dvdBusinessLogic.searchDVDs(title1); // Will return the if DVD was found
					
					if(foundDvd != null){  // If DVD was found, prints info
						System.out.println(foundDvd);
						System.out.println("Which value would you like to edit? ");
						System.out.println("1. Title");
						System.out.println("2. MPAA Rating");
						System.out.println("3. Director Name");
						System.out.println("4. Studio");
						System.out.println("5. Personal rating or note");
						System.out.println("0. Cancel");
						
						choiceEdit = sc.nextInt(); // Taking user input for choiceEdit
						sc.nextLine(); // Consume the newline character
						
						switch(choiceEdit) {
						
						case 1: // Edit title
							
							System.out.println("Enter the new title: ");
							dvdBusinessLogic.updateDVDs(foundDvd.getTitle(), "title", sc.nextLine());
					
							break;
						
						case 2: // Edit MPAA rating
							
							System.out.println("Enter new MPAA rating: ");
							dvdBusinessLogic.updateDVDs(foundDvd.getTitle(), "MPAA", sc.nextLine());
							break;
							
						case 3: // Edit director
							
							System.out.println("Enter new name of director: ");
							dvdBusinessLogic.updateDVDs(foundDvd.getTitle(), "DirectorName", sc.nextLine());
							
							break;
						
						case 4: // Edit studio
							
							System.out.println("Enter new studio: ");
							dvdBusinessLogic.updateDVDs(foundDvd.getTitle(), "Studio", sc.nextLine());
							break;
							
						case 5: // Edit user note
							
							System.out.println("Add new personal rating or note: ");
							dvdBusinessLogic.updateDVDs(foundDvd.getTitle(), "UserRating", sc.nextLine());
							break;
						
						case 0:
							System.out.println("No changes made.");
							break;
							
						default:
							
							System.out.println("Invalid input.");
						}
						
					}
					else {
						System.out.println(title1 +" not found in Library.");
					}
					break;
				}
				
			
			case 4: // Show all DVDs
				// Creates  list object to store the linked list of DVDs returned by business logic
				List<DVD> dvdLibrary = dvdBusinessLogic.getAllDVDs();
				// For each element in dvdLibrary, print the element
				for(DVD dvd1: dvdLibrary) { 
					System.out.println(dvd1);
				}
				
				break;
			
			case 5: // Search for DVDs by title
				System.out.println("Enter the title of the DVD you wish to view: ");
				String title1 = sc.nextLine();
				DVD foundDvd = dvdBusinessLogic.searchDVDs(title1); // Will return the if DVD was found
				
					if(foundDvd != null){  // If DVD was found, prints info
						System.out.println(foundDvd);
					}
					else {
						System.out.println(title1 +" not found in Library.");
					}
					break;
			
			case 0: // Quit
				
				System.out.println("Goodbye");
				System.exit(0);
				
			default:
				System.out.println("Invalid choice. Try again.");
			}
			
			
		}

	}


