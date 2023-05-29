import java.util.Scanner;

public class MiniZork {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.print("You are standing in an open field west of a white house,");
        System.out.println("with a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.print("Go to the house, or open the mailbox? ");

        String action = userInput.nextLine();

        if (action.equals("open the mailbox")) {
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? ");
            action = userInput.nextLine();

            if (action.equals("look inside")) {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? ");
                action = userInput.nextLine();

                if (action.equals("keep looking")) {
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you're alive. Possibly a wise choice.");
                }
            } else if (action.equals("stick your hand in")) {
                System.out.println("You stick your hand in the mailbox.");
                System.out.println("A strange force pulls you into the mailbox.");
                System.out.println("You find yourself in a magical forest.");
                System.out.print("Explore the forest or try to find your way back? ");
                action = userInput.nextLine();

                if (action.equals("explore the forest")) {
                    System.out.println("You venture deeper into the forest.");
                    System.out.println("After a while, you stumble upon a hidden treasure chest.");
                    System.out.println("Congratulations! You've found the hidden treasure!");
                } else if (action.equals("try to find your way back")) {
                    System.out.println("You wander through the forest, trying to find your way back.");
                    System.out.println("Unfortunately, you get lost and never find your way out.");
                    System.out.println("You remain trapped in the magical forest forever.");
                }
            }
        } else if (action.equals("go to the house")) {
            System.out.println("You approach the white house.");
            System.out.println("The front door is locked.");
            System.out.print("Try to open the door or go back to the field? ");
            action = userInput.nextLine();

            if (action.equals("try to open the door")) {
                System.out.println("You try to open the door, but it's stuck.");
                System.out.println("You give up and decide to go back to the field.");
                System.out.println("Better luck next time!");
            } else if (action.equals("go back to the field")) {
                System.out.println("You turn around and head back to the open field.");
                System.out.println("You enjoy the fresh air and open space.");
                System.out.println("It's a peaceful day in the field.");
            }
        }
    }
}