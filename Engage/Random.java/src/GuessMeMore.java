
import java.util.Scanner;
import java.util.Random;

public class GuessMeMore {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		int thint = random.nextInt(201)-100;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Guess the number: ");
		int userNum = scanner.nextInt();
		
		if(userNum == thint) {
			System.out.println("Wow, nice guess! That was it!");
		}
		else if(userNum < thint) {
			System.out.println("Ha, nice try - too low! I chose "+thint+".");
		}
		else if(userNum >thint) {
			System.out.println("Too bad, way too high. I chose "+thint+".");
		}

	}

}