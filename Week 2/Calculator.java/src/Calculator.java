import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		int choice = 1;
		int res = 0;
		int num1 = 1, num2 = 1;
		Scanner sc = new Scanner(System.in);
		while(choice != 5) {
			
			System.out.println("Select an option from the menu by entering the corresponding number:");
			System.out.println("1. Addition (+)");
			System.out.println("2. Subtraction (-)");
			System.out.println("3. Multiplication (*)");
			System.out.println("4. Division (/)");
			System.out.println("5. Exit");
			System.out.print("Choice: ");
			
			choice = sc.nextInt();
			
			if(choice != 5) {
			
				System.out.println("Enter your first number: ");
				num1 = sc.nextInt();
				System.out.println("Enter your second number: ");
				num2 = sc.nextInt();
			}
			
			
			switch(choice) {
			
			case 1:
				
				res = sum(num1, num2);
				System.out.println(num1+" + "+num2+ " = " +res);
				break;
				
			case 2:
				
				res = subtract(num1, num2);
				System.out.println(num1+" - "+num2+" = "+res);
				break;
				
			case 3:
				
				res = product(num1, num2);
				System.out.println(num1+" * "+num2+" = "+res);
				break;
			
			case 4:
				
				double reslt = divide(num1, num2);
				
				if(Double.isNaN(reslt)) {
					System.out.println("Cannot divide by 0. ");
				}else {
					System.out.println(num1+" / "+num2+" = "+reslt);
				}
				break;
			
			case 5:
				
				System.out.println("Goodbye");
				break;
			
			default:
				
				System.out.println("Invalid input.");
				break;
				
			}
			
			
		}
		
		System.exit(0);

	}
	
	public static int sum(int num1, int num2) {
		
		int result = num1 + num2;
		return result;
	}
	
	public static int product(int num1, int num2) {
		
		int result = num1 * num2;
		return result;
	}
	
	public static double divide(int num1, int num2) {
		
		double result; 
		
		if(num2 == 0) {
			result = Double.NaN; 
		}else {
			result = (double) num1/num2;
		}
		
		return result;
		
	}
	
	public static int subtract(int num1, int num2) {
		
		int result = num1 - num2;
		
		return result;
	
	}

}
