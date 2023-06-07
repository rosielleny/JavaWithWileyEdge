
import java.util.Scanner;

public class SumOfCounting {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a whole number: ");
		
		int userNum = scanner.nextInt();
		
		int result = 0;
		
		for(int count = userNum; count > 0; count--) {
			
			result += count;
		}
		
		System.out.println("Sum of counting: "+result);

	}

}
