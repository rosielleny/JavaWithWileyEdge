public class MoreBucketsMoreFun {

    public static void main(String[] args) {

        
        int butterflies, beetles, bugs;

        butterflies = 5;
        beetles = 9;

        bugs = butterflies + beetles;
        
        System.out.println("There are only " + butterflies + " butterflies,");
        System.out.println("but there are " + bugs + " bugs in all.");
        System.out.println("Uh oh, my dog ate one.");
        
        butterflies--; // Here butterflies is decremented by 1 to show the dog age one
        
        System.out.println("Now there are only " + butterflies + " butterflies left.");
        System.out.println("But there are still " + bugs + " bugs left...");
        System.out.println("Wait a minute!");
        System.out.println("... maybe my computer can't do maths, after all!");
        
        /*The number of bugs does not change because bugs would need to be recalculated
         * with the new value for butterflies. As is, it still holds a calculation based
         * on the original value for butterflies.
         */
    }
}

