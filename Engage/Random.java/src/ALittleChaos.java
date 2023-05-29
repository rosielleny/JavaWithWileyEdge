
import java.util.Random;

public class ALittleChaos {

    public static void main(String[] args) {

        Random randomizer = new Random();

        System.out.println("Random can make integers: " + randomizer.nextInt());
        System.out.println("Or a double: " + randomizer.nextDouble(200));
        System.out.println("Or even a boolean: " + randomizer.nextBoolean());

        int num = randomizer.nextInt(100);

        System.out.println("You can store a randomized result: " + num);
        System.out.println("And use it over and over again: " + num + ", " + num);

        System.out.println("Or just keep generating new values");
        System.out.println("Here's a bunch of numbers from 0 - 100: ");

        System.out.print(randomizer.nextInt(200) + 50 + ", ");
        System.out.print(randomizer.nextInt(51) + 50 + ", ");
        System.out.print(randomizer.nextInt(300) + 50 + ", ");
        System.out.print(randomizer.nextInt(2) -50+ ", ");
        System.out.print(randomizer.nextInt(51) +50+ ", ");
        System.out.println(randomizer.nextInt(4)+30);
    }
}

/* When randomizer.nextInt(101) is changed to randomizer.nextInt(51) + 50 the range of values output
* is changed. All numbers are over 50 as we have added 50 to every single one.
*/
/* Random numbers can be included in a math statement. The result will just be different each time 
* due to the inclusion of random numbers. Math.random() can also be used for doubles.
*/

/* System.out.print(randomizer.nextInt(200) + 50 + ", ");
System.out.print(randomizer.nextInt(51) + 50 + ", ");
System.out.print(randomizer.nextInt(99) + 50 + ", ");
System.out.print(randomizer.nextInt(51) -50+ ", ");
System.out.print(randomizer.nextInt(51) +50+ ", ");
System.out.println(randomizer.nextInt(51)+50); */

// Results in:

/*Here's a bunch of numbers from 0 - 100: 
95, 56, 125, -42, 74, 79*/


/*System.out.print(randomizer.nextInt(200) + 50 + ", ");
System.out.print(randomizer.nextInt(51) + 50 + ", ");
System.out.print(randomizer.nextInt(300) + 50 + ", ");
System.out.print(randomizer.nextInt(2) -50+ ", ");
System.out.print(randomizer.nextInt(51) +50+ ", ");
System.out.println(randomizer.nextInt(4)+30);*/

// Results in:

/*Here's a bunch of numbers from 0 - 100: 
95, 55, 50, -49, 68, 31*/

// System.out.println("Or a double: " + randomizer.nextDouble(200));

// Results in: 

// Or a double: 18.803080965458953

