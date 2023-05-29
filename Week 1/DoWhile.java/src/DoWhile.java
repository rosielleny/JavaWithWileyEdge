import java.util.Scanner;

public class DoWhile {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		int choice;
		
		do {
		
			System.out.println("Select an option from the menu by entering the corresponding number:");
			System.out.println("1. Calculate Area of Rectangle");
			System.out.println("2. Calculate Area of Circle");
			System.out.println("3. Calculate Area of Right Angled Triangle");
			System.out.println("4. Calculate Area of Square");
			System.out.println("5. Exit");
		
			System.out.println("Choice: ");
		
			choice = scanner.nextInt();
		
			switch(choice) {
		
			case 1:
				System.out.println("Enter the length of the rectangle: ");
				double lengthR = scanner.nextDouble();
				System.out.println("Enter the width of the rectangle: ");
				double widthR = scanner.nextDouble();
				double areaR = lengthR*widthR;
				System.out.println("Area of the rectangle: "+areaR);
				break;
		
			case 2:
				System.out.println("Enter the radius of the circle: ");
				double radius = scanner.nextDouble();
				double areaC = 3.142*radius*radius;
				System.out.println("Area of the circle:" +areaC);
				break;
			
			case 3:
				System.out.println("Enter the length of the traingle: ");
				double lengthT = scanner.nextDouble();
				System.out.println("Enter the width of the trangle: ");
				double widthT = scanner.nextDouble();
				double areaT = (lengthT*widthT)/2;
				System.out.println("Area of the triangle: "+areaT);
				break;
			
			case 4:
				System.out.println("Enter the width of the square: ");
				double widthS = scanner.nextDouble();
				double areaS = widthS*widthS;
				System.out.println("Area of the square: "+areaS);
				break;
			
			case 5:
				System.out.println("Goodbye");
				break;
				
					
			default:
				System.out.println("Input Invalid");
		}
		}while(choice != 5);
		
		System.exit(0);

	}

}
