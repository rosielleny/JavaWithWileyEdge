
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
	
	public static void showMenu() {
		
		System.out.println("Make your choice by entering the corresponding number from the menu:");
		System.out.println("1. Rock");
		System.out.println("2. Paper");
		System.out.println("3. Scissors");
	}
	
	/* Function for the Player and Computer to make their choice between Rock/Paper/Scissors
	 * Also manages game loop until all rounds have been played
	 */
	public static void play(int rounds) { 
		
		Scanner sc = new Scanner(System.in);
		
		int playerWins = 0, computerWins = 0, ties = 0;
		int[] choices = {1, 2, 3}; // Array for the computer to choose from 1 = Rock, 2 = Paper, 3 = Scissors
		int playerChoice, computerChoice;
		boolean validChoice = true;
		
			for(int round = 1; round <= rounds; round++) {
			
					
				int randomIndex = new Random().nextInt(choices.length);
				computerChoice = choices[randomIndex]; // Computer's choice
			

				do {
				    showMenu();
				    playerChoice = sc.nextInt(); // Player's choice

				    int outcome = roundWinner(playerChoice, computerChoice);
				    validChoice = true;
				    
				    if (outcome == 1) {
				        System.out.println("It's a tie!");
				        ties += 1;
				        
				    } else if (outcome == 2) {
				        System.out.println("Computer wins the round!");
				        computerWins += 1;
				        
				    } else if (outcome == 3) {
				        System.out.println("Player wins the round!");
				        playerWins += 1;
				        
				    } else if (outcome == 4) {
				    	System.out.println("Please make a valid choice.\n");
				        validChoice = false;
				    }
				} while (validChoice == false);
			
		}
			
			gameWinner(computerWins, playerWins, ties);
		
	}
	/* roundWinner determines the winner of a single round, returning an integer to the play() function
	* 1 = tie, 2 = computer win, 3 = player win, 4 = user had invalid entry. play() uses these numbers
	* to print an appropriate message before continuing the game loop.
	*/
	public static int roundWinner(int playerChoice, int computerChoice) {
	    if (playerChoice == computerChoice) { // If there is a tie
	        return 1;
	    } else {
	        switch (playerChoice) {
	            case 1: // Rock
	                switch (computerChoice) {
	                    case 2: // Paper
	                        return 2; // Computer Wins
	                    case 3: // Scissors
	                        return 3; // Player Wins
	                }
	            case 2: // Paper
	                switch (computerChoice) {
	                    case 1: // Rock
	                        return 3; // Player Wins
	                    case 3: // Scissors
	                        return 2; // Computer Wins
	                }
	            case 3: // Scissors
	                switch (computerChoice) {
	                    case 1: // Rock
	                        return 2; // Computer Wins
	                    case 2: // Paper
	                        return 3; // Player Wins
	                }
	            default:
	                return 4; // Player has made an error
	        }
	    }
	}
	/* gameWinner() prints final scores, then determines the final winner by comparing total scores and 
	* printing an appropriate message
	*/
	public static void gameWinner(int computerWins, int playerWins, int ties) {
		
		System.out.println("Scores\nComputer: "+computerWins+"\nPlayer: "+playerWins+"\nTies: "+ties);
		
		if(computerWins > playerWins) {
			
			System.out.println("Computer wins the game!");
		}
		else if(computerWins < playerWins) {
			
			System.out.println("Player wins the game!");
		}
		else {
			System.out.println("It's a tie!");
		}
	}
	/* In main, the number of rounds to play is obtained before giving this to the play() method
	* then once the game has been played, main asks if player wants to play again, looping if yes,
	quitting if no */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean playAgain = true;
		
		System.out.println("Welcome to Rock, Paper, Scissors. ");
			
			while(playAgain == true) { // Will loop until the user chooses not to play again
				
				System.out.println("Enter the number of rounds (1-10) you wish to play: ");
				
				int rounds = sc.nextInt();
				
				if(rounds <1 || rounds >10) {
					
					System.out.println("Invalid input.");
					System.exit(0);
				}
				else {
				
				play(rounds);
			
				System.out.println("Would you like to play again? y/n");
				String again = sc.next();
				
				if(again.equalsIgnoreCase("y")|| again.equalsIgnoreCase("y")) {
					
					playAgain = true;
					
				}
				else {
					
					playAgain = false;
					System.out.println("Goodbye");
				
	
				}
			}
			
			
		}
		
		System.exit(0);

	}

}