import java.util.Scanner;

public class VowelOrConsonant {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		char letter = 'a';
		char vowels[] = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
		boolean isVowel = true;
		
		System.out.println("Enter a letter of the alphabet:");
		
		if(sc.hasNextLine()) {
			
			String input = sc.nextLine();
			
			if(input.length() == 1) {
				
				letter = input.charAt(0);
				
				for(int i = 0; i < vowels.length; i++) {
					
					if(letter == vowels[i]) {
						
						isVowel = true;
						break;
					}
					else {
						
						isVowel = false;
					}
				}
			}
			else {
				System.out.println("Please only enter a single letter.");
			}
			
		}
		else {
			System.out.println("No input was provided.");
			}
		
		if(isVowel) {
			
			System.out.println(letter+" is a vowel.");
			
		}
		else if(letter == 'y' || letter == 'Y') {
			
			System.out.println(letter+ "is a consonant, but sometimes a vowel.");
		}
		else {
			System.out.println(letter+" is a consonant.");
		}

	}

}
