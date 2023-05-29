import java.util.Scanner;

public class ObjectOrientedFactorialMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        CalculateFactorial calculator = new CalculateFactorial();
        
        calculator.setNumber(num);

        long fact = calculator.getFactorial();

        System.out.println("The factorial of " + num + " is: " + fact);
    }
}