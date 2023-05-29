import java.util.Scanner;

public class KnockKnock {

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        System.out.print("Knock Knock! Guess who!! ");
        String nameGuess = inputReader.nextLine();

        if(nameGuess.equalsIgnoreCase("Marty McFly")){
            System.out.println("Hey! That's right! I'm back!");
            System.out.println(".... from the Future."); 
        }else{
            System.out.println("Dude, do I -look- like " + nameGuess);
        }
    }
}


// If .equals is changed to ==, the statement is read as false no matter what and the else is triggered
// Getting the case wrong would previously case a false, I have fixed this by adding the .equalsIgnoreCase