import java.util.Scanner;

public class AllTheTrivia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("What unit is equivalent to 1,024 Gigabytes? ");
        String giga = scanner.nextLine();
        
        System.out.print("Which planet is the only one that rotates clockwise in our Solar System? ");
        String planet = scanner.nextLine();
        
        System.out.print("The largest volcano ever discovered in our Solar System is located on which planet? ");
        String volcano = scanner.nextLine();
        
        System.out.print("What is the most abundant element in the earth's atmosphere? ");
        String element = scanner.nextLine();
        
        System.out.println();
        
        System.out.println("Wow, 1,024 Gigabytes is a " + planet + "!");
        System.out.println("I didn't know that the largest ever volcano was discovered on " + giga + "!");
        System.out.println("That's amazing that " + volcano + " is the most abundant element in the atmosphere...");
        System.out.println(element + " is the only planet that rotates clockwise, neat!");
        
    }
}