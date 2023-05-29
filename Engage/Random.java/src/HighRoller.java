
import java.util.Random;
import java.util.Scanner;

public class HighRoller {

    public static void main(String[] args) {

        Random diceRoller = new Random();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many sides does the die have?");
        int sides = sc.nextInt();

        int rollResult = diceRoller.nextInt(sides) + 1;

        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);

        if (rollResult == 1) {
            System.out.println("You rolled a critical failure!");
        }
        else if(rollResult == sides) {
        	System.out.println("You rolled a critical! Nice job!");
        }
    }
}