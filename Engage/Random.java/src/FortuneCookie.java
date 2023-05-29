
import java.util.Random;
public class FortuneCookie {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		String[] quotes = {"Not all those who wander are lost.",
				"All we have to decide is what to do with the time that is given us.",
			    "It's a dangerous business, Frodo, going out your door.",
			    "My precious!",
			    "Go where you must go, and hope!",
			    "It's the job that's never started as takes longest to finish.",
			    "Moonlight drowns out all but the brightest stars.",
			    "All's well that ends better.",
			    "Someone else always has to carry on the story.",
			    "Do not scorn pity that is the gift of a gentle heart."};
		
		
		int randomIndex = random.nextInt(quotes.length);
		
		System.out.println(quotes[randomIndex]);

	}

}
