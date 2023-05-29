import java.util.Scanner;

public class GuessMe {

	public static void main(String[] args) {
		int thint = 26;
		
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
