
import java.util.Scanner;

public class FirstMethod {


	public static void main(String[] args) { // Caller method
		
		System.out.println("Enter a number to find its factorial: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		long factorial = factorialFinder(num);
		
		if(factorial == -1) {
			System.out.println("Cannot find factorial of number less than or equal to 0.");
		}
		else {
			System.out.println("Factorial of your number: " +factorial);
		}
	}
		
	public static long factorialFinder(int num) {
		
		long factorial = -1;
		
		if( num <=0) {
			factorial = -1;
		}
		
		else {
			factorial = 1;
			for (int i = num; i > 0; i--) {
				factorial *= i;
			}
        
			}
		return factorial;
        
	
	}
}



