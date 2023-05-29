import java.util.Scanner;

public class PositiveOrNegative {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter a number: ");
		
		int num = scanner.nextInt(); // Taking user input
		
		if(num > 0) {
			System.out.println(num+" is positive.");
		}
		else{
			if(num < 0){

				System.out.println(num+ " is negative.");
			}
		
			else{
				System.out.println(num+ " is neither positive nor negative.");
			}
		}


	}
	}


