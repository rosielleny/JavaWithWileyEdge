
import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is your age? ");
        int age = scanner.nextInt();

        int maxHeartRate = 220 - age;
        int targetHRZoneLower = (int) (maxHeartRate * 0.5);
        int targetHRZoneUpper = (int) (maxHeartRate * 0.85);

        System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute.");
        System.out.println("Your target HR Zone is " + targetHRZoneLower + " - " + targetHRZoneUpper + " beats per minute.");

        scanner.close();
    }
}