import java.util.Scanner;

public class CircularNumberChecker {

	public static long circler(long num) {
		
		long remainder = num%10;
		long new_num = num/10;
		int powerOfTen = 1;
		
		while(num > 9) {
			
			num/=10;
			
			powerOfTen *= 10;
			
		}
		
		
		long circled = (remainder*powerOfTen) + new_num;
		
		return circled;
	}
	
	public static long multByLast(long num) {
		
		long remainder = num%10;
		long result = num*remainder;
		
		return result;
	}
	
	public static boolean checker(long num) {
		
		long circled = circler(num);
		long multiplied = multByLast(num);
		
		if(circled == multiplied) {
			return true;
		}else {
		return false;
				}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		
		long num = sc.nextLong();
		
		if(checker(num) == true) {
			System.out.println("Your number is a circular number.");
		}
		else {
			System.out.println("Your number is not a circular number.");
		}

	}

}
