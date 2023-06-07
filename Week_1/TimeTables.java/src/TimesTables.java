
import java.util.Scanner;

public class TimesTables {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a whole number: ");
		int num = scanner.nextInt(); // Taking input from user
		
		int counter = 1;
		
		while(counter <= 10) {
			
			int result = num*counter;
			
			System.out.println(num+" x "+counter+" = "+result);
			
			counter += 1;
			
	
		}

	}

}
