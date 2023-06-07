import java.util.Scanner;

public class CircleCalc {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// Area and Circumference Calculation
		
		System.out.println("Enter the radius of the circle: ");
		float radius = scanner.nextFloat(); // Taking input from user
		
		float pi = 3.142F;
		float area = pi*radius*radius;
		float circumference = 2*pi*radius;
		
		System.out.println("Area of the circle: "+area);
		System.out.println("Circumference of the circle: "+circumference);
		
		// Value Swapper
		
		System.out.println("Enter value 1: ");
		int value1 = scanner.nextInt();
		
		System.out.println("Enter value 2: ");
		int value2 = scanner.nextInt();
		
		System.out.println("Value 1 is "+value1+" and Value 2 is "+ value2);
		
		int valueStore = value2;
		value2 = value1;
		value1 = valueStore;
		
		System.out.println("When swapped, Value 1 is " + value1 + " and Value 2 is "+value2);
		

	}

}

		