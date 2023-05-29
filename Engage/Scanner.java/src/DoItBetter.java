import java.util.Scanner;

public class DoItBetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("How many miles can you run? ");
        int miles = scanner.nextInt();
        
        System.out.println("That's impressive, but I can run " + (miles * 2 + 1) + " miles!");
        
        System.out.println("How many hot dogs can you eat? ");
        int hotDogs = scanner.nextInt();
        
        System.out.println("You can eat " + hotDogs + " hot dogs? Well, I can eat " + (hotDogs * 2 + 1) + "!");
        
        System.out.println("How many languages do you know? ");
        int languages = scanner.nextInt();
        
        
        System.out.println("You know " + languages + " languages? I know " + (languages * 2 + 1) + "!");
        
        System.out.println(); 
        
    }
}
        
        