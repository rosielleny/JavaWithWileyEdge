import java.util.Scanner;

public class PalindromeIdentifier {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a number to check if it is a palindrome: ");
		long number = scanner.nextLong();
		
		boolean answer = checkPalindrome(number);
		
		if(answer == true) {
			System.out.println("Your number is a palindrome.");
		}
		else {
			System.out.println("Your number is not a palindrome.");
		}
		

	}
	
	public static long reverseNum(long num) {
		
		long result = 0;
		long remainder;
		
		
		while(num != 0) {
			
			remainder = num%10;
			num = num/10;
			
			result = result*10 +remainder;
		}
		return result;	
			
		
	}
	
	public static boolean checkPalindrome(long num) {
		
		long result = reverseNum(num);
		
		if(num == result) {
			
			return true;
		}
		else {
			return false;
		}
		
	}

}
