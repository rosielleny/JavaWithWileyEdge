import java.util.Random;

public class BarelyControlledChaos {

    public static void main(String[] args) {

        String color = colourPicker(); // call color method here
        String animal = animalPicker(); // call animal method again here
        String colorAgain = colourPicker(); // call color method again here
        int weight = numberPicker(5,200); // call number method,
            // with a range between 5 - 200
        int distance = numberPicker(10,20); // call number method,
            // with a range between 10 - 20
        int number = numberPicker(10000, 20000); // call number method,
            // with a range between 10000 - 20000
        int time = numberPicker(2,6); // call number method,
            // with a range between 2 - 6            

        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
            + number + " " + colorAgain + " poppies for nearly "
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
            + "let me tell you!");
    }

    public static String colourPicker() {
    	String[] colours = {"red", "green", "blue", "yellow", "orange"};
    	Random random = new Random();
    	int index = random.nextInt(colours.length);
        return colours[index];
    }
    
    public static String animalPicker() {
    	String[] animals = {"cat", "dog", "rabbit", "owl", "fish"};
    	Random random = new Random();
    	int index = random.nextInt(animals.length);
        return animals[index];
    }
    public static int numberPicker(int min, int max) {
    	Random random = new Random();
    	return random.nextInt(max - min+1) + min;
    }
}

