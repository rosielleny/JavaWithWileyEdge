import java.util.Scanner;

public class OneDDoubleArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double numsArray[] = new double[8];
		
		for(int index = 0; index < 8; index++) {
			
			System.out.println("Enter value "+(index+1)+":");
			numsArray[index] = sc.nextDouble();
		}
		
		double result = 0;
		
		for(int index = 0; index < 8; index++) {
			
			result += numsArray[index];
			
		}
		
		System.out.println("Sum of values: "+result);

	}

}
