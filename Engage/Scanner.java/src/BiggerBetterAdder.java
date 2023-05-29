
import java.util.Scanner;
public class BiggerBetterAdder {
		
	    public static void main(String[] args) {
	    	
	    	Scanner sc  = new Scanner(System.in);
	    	
	    	System.out.println("Enter a number:");
	    	
	        int num1 = sc.nextInt();
	        
	        System.out.println("Enter a second number:");
	        
	        int num2 = sc.nextInt();
	        
	        System.out.println("Enter a final number:");
	        
	        int num3 = sc.nextInt();
	        
	        int sum = num1 + num2 + num3;
	        
	        System.out.println(num1 + " + " + num2 + " + " + num3 + " = " + sum);
	    }
	

}
