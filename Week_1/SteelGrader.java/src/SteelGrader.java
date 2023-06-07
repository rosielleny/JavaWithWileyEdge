import java.util.Scanner;
public class SteelGrader {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Carbon Content: ");
		int carbon = scanner.nextInt();
		
		System.out.println("Enter Hardness: ");
		double hardness = scanner.nextDouble();
		
		System.out.println("Enter Tensile Strength: ");
		int tensile = scanner.nextInt();
		
		// Determining which conditions are met
		
		boolean condition1 = false;
		boolean condition2 = false;
		boolean condition3 = false;
		
		if(carbon > 5700) {
			
			condition1 = true;
		}
		if(hardness < 0.7) {
			
			condition2 = true;
		}
		if(tensile >= 97) {
			
			condition3 = true;
		}
		
		// Assigning grades based on which conditions are met
		
		
		if(condition1 == true && condition2 == true && condition3 == true) {
			System.out.println("Grade 10");
		}
		
		else if(condition1 == true && condition2 == true && condition3 == false) {
			System.out.println("Grade 9");
		}
		
		else if(condition1 == false && condition2 == true && condition3 == true) {
			System.out.println("Grade 8");
		}
		
		else if(condition1 == true && condition2 == false && condition3 == true) {
			System.out.println("Grade 7");
		}
		
		else if(condition1 == true || condition2 == true || condition3 == true) {
			System.out.println("Grade 6");
		}
		else {
			System.out.println("Grade 5");
		}
				

	}

}
