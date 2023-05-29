

public class SpacesRustlers {

    public static void main(String[] args) {

        int spaceships = 10;
        int aliens = 25;
        int cows = 100;

        if(aliens > spaceships){
            System.out.println("Vrroom, vroom! Let's get going!");
        } else{
            System.out.println("There aren't enough green guys to drive these ships!");
        }

        if(cows == spaceships){
            System.out.println("Wow, way to plan ahead! JUST enough room for all these walking hamburgers!");
        } else if (cows > spaceships){
            System.out.println("Dangit! I don't how we're going to fit all these cows in here!");
        } else {
            System.out.println("Too many ships! Not enough cows.");
        }
        
        if (aliens > cows) {
            System.out.println("Hurrah, we've got the grub! Hamburger party on Alpha Centauri!");
        } else if (cows >= aliens) {
            System.out.println("Oh no! The herds got restless and took over! Looks like we're hamburger now!!");
        }
    }
}

// The if provides a condition and if the condition is true, the statement will be run
// The else if runs only if the previous if was false, then if the else if's condition is true it will run
// Else if prevents the potential for multiple if statements to be executed if more than one is true

// Removing the else from else if currently does not change the code as the if before it is still not true
// If the if before it was true, it wouldn't run, and then it would run once the else was removed as well as the previous if statement