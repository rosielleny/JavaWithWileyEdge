import java.util.Scanner;

public class StayPositive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int number;
        
        // Prompt the user for a positive integer
        do {
            System.out.print("Enter a positive integer: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a positive integer.");
                sc.next(); // Clear the invalid input
            }
            number = sc.nextInt();
        } while (number <= 0);
        
        
        int valuesPerLine = 10;
        
        int count = 0; // Counter for values per line
        
        System.out.println("Counting down:");
        while (number >= 0) {
            System.out.print(number + " ");
            
            // Check if the line should wrap
            if (++count % valuesPerLine == 0) {
                System.out.println();
            }
            
            number--;
        }
        
        System.out.println("\nCountdown completed!");
        sc.close();
    }
}