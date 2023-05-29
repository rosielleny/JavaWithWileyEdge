import java.util.Scanner;

public class ReverseFactorising {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a whole number: ");
		
		int userNum = scanner.nextInt();
		
		int result = 1;
		
		for(; userNum > 0;) {
			
			result *= userNum--;
		}
		
		System.out.println("Result: "+result);

	}

}
