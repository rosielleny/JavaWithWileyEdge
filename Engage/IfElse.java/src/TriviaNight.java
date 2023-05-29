import java.util.Scanner;

public class TriviaNight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("It's TRIVIA NIGHT! Are you ready?!\n");

        // First Question
        System.out.println("FIRST QUESTION!");
        System.out.println("What is the Lowest Level Programming Language?");
        System.out.println("1) Source Code\t\t2) Assembly Language");
        System.out.println("3) C#\t\t\t4) Machine Code\n");
        System.out.print("YOUR ANSWER: ");
        int answer1 = scanner.nextInt();

        if (answer1 == 4) {
            score++;
            System.out.println("Correct!\n");
        } else {
            System.out.println("Incorrect!\n");
        }

        // Second Question
        System.out.println("SECOND QUESTION!");
        System.out.println("Website Security CAPTCHA Forms Are Descended From the Work of?");
        System.out.println("1) Grace Hopper\t\t2) Alan Turing");
        System.out.println("3) Charles Babbage\t4) Larry Page\n");
        System.out.print("YOUR ANSWER: ");
        int answer2 = scanner.nextInt();

        if (answer2 == 2) {
            score++;
            System.out.println("Correct!\n");
        } else {
            System.out.println("Incorrect!\n");
        }

        // Third Question
        System.out.println("LAST QUESTION!");
        System.out.println("Which of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?");
        System.out.println("1) Serenity\t\t2) The Battlestar Galactica");
        System.out.println("3) The USS Enterprise\t4) The Millennium Falcon\n");
        System.out.print("YOUR ANSWER: ");
        int answer3 = scanner.nextInt();

        if (answer3 == 3) {
            score++;
            System.out.println("Correct!\n");
        } else {
            System.out.println("Incorrect!\n");
        }

        System.out.println("You got " + score + " correct!");

        if (score == 3) {
            System.out.println("Awesome! You nailed all the questions!");
        } else if (score >= 1) {
            System.out.println("Well done! You did a great job!");
        } else {
            System.out.println("Better luck next time! Keep practicing!");
        }
    }
}