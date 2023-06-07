import java.util.Scanner;

public class ReverseNum {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a number to reverse its digits: ");
		int num = scanner.nextInt();
		int number = num;
		int result = 0;
		int remainder;
		
		
		while(num != 0) {
			
			remainder = num%10;
			num = num/10;
			
			result = result*10 +remainder;
			
			
			
		}
		
		System.out.println("The reverse of "+number+" is: "+result);
		
		if(number == result) {
			
			System.out.println(number+ " is a palindrome.");
		}
		else {
			System.out.println(number+ " is not a palindrome.");
		}

	}

}
