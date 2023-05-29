import java.util.Scanner;

public class ForLoop {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a whole number: ");
		int num = scanner.nextInt(); // Taking input from user
		
		for(int count = 1; count <= 10; count++) {
			
			int result = num*count;
			
			System.out.println(num+" x "+count+" = "+result);
			
		}

	}

}
