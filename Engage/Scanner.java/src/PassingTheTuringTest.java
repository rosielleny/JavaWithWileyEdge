import java.util.Scanner;

public class PassingTheTuringTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("What is your name? ");
        String userName = scanner.nextLine();
        
        System.out.println("Nice to meet you, " + userName + "! My name is Rosie.");
        
        System.out.print("What is your favorite color? ");
        String favoriteColor = scanner.nextLine();
        
        System.out.println("Ah, " + favoriteColor + " is a lovely color!");
        
        System.out.print("How about your favorite food? ");
        String favoriteFood = scanner.nextLine();
        
        System.out.println("Mmm, " + favoriteFood + " sounds delicious!");
        
        System.out.print("Lastly, what is your favorite number? ");
        int favoriteNumber = scanner.nextInt();
        
        System.out.println("Oh, " + favoriteNumber + " is a great choice!");
        
        System.out.println("Thank you for the conversation, " + userName + "! Goodbye!");
        
        scanner.close();
    }
}