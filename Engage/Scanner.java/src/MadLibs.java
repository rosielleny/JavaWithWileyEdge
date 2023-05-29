import java.util.Scanner;

public class MadLibs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's play MAD LIBS!\n");

        System.out.print("I need a noun: ");
        String noun1 = scanner.nextLine();

        System.out.print("Now an adjective: ");
        String adjective1 = scanner.nextLine();

        System.out.print("Another noun: ");
        String noun2 = scanner.nextLine();

        System.out.print("And a number: ");
        int number = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character

        System.out.print("Another adjective: ");
        String adjective2 = scanner.nextLine();

        System.out.print("A plural noun: ");
        String pluralNoun1 = scanner.nextLine();

        System.out.print("Another one: ");
        String pluralNoun2 = scanner.nextLine();

        System.out.print("One more: ");
        String pluralNoun3 = scanner.nextLine();

        System.out.print("A verb (infinitive form): ");
        String verb1 = scanner.nextLine();

        System.out.print("Same verb (past participle): ");
        String verb2 = scanner.nextLine();

        System.out.println("\n*** NOW LET'S GET MAD (libs) ***");
        System.out.println(noun1 + ": the " + adjective1 + " frontier. These are the voyages of the starship " + noun2 +
                ". Its " + number + "-year mission: to explore strange " + adjective2 + " " + pluralNoun1 +
                ", to seek out " + adjective2 + " " + pluralNoun2 + " and " + pluralNoun3 + ", to boldly " + verb1 +
                " where no one has " + verb2 + " before.");

        scanner.close();
    }
}